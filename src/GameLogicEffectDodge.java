import java.awt.*;

/**
 * Created by Arkadiusz Nowak on 29.05.2017.
 */
public class GameLogicEffectDodge extends GameLogicEffect {

    long currentTic;
    double x = 0;
    double y = 0;
    double temp = 0;

    GameLogicEffectDodge(DataGenericObject affectedObject, long startingTic, int duration) {
        super(affectedObject, startingTic, 12);
        this.isActive = true;
        this.id = 0;
        this.priority = 1;
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void run(long currentTic) {
        this.currentTic = currentTic-1;

        if(this.currentTic == this.startingTic) {        //at first tic
            double targetVector = 10;
            Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
            x = ((DataMovingObject) affectedObject).x - mouseLocation.getX();
            y = ((DataMovingObject) affectedObject).y - mouseLocation.getY();
            temp = Math.sqrt(           Math.pow(targetVector, 2)
                                                    /
                                    (Math.pow(x, 2) + Math.pow(y, 2))           );
        }

        ((DataMovingObject)affectedObject).vectX -= temp*x;
        ((DataMovingObject)affectedObject).vectY -= temp*y;
        ((DataMovingObject)affectedObject).isMoving = true;
        ((DataMovingObject)affectedObject).isControllable = false;

        if(currentTic == targetTic) release();
    }

    @Override
    public void release() {
        affectedObject.effects.remove(this.id);
        ((DataMovingObject)affectedObject).vectX = 0;
        ((DataMovingObject)affectedObject).vectY = 0;
        ((DataMovingObject)affectedObject).isControllable = true;
        ((DataMovingObject)affectedObject).isMoving = false;
        affectedObject.effects.put(1, new GameLogicEffectDodge2(affectedObject, currentTic, 0)); //this effect has fixed duration
    }
}
