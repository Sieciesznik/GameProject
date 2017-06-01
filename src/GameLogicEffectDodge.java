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
        this.id = 1;
        this.priority = 2;
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
            double targetVector = 50;
            Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
            x = ((DataMovingObject) affectedObject).x - mouseLocation.getX();
            y = ((DataMovingObject) affectedObject).y - mouseLocation.getY();
            temp = Math.sqrt(           Math.pow(targetVector, 2)
                                                    /
                                    (Math.pow(x, 2) + Math.pow(y, 2))           );
        }

        ((DataMovingObject)affectedObject).vectX.currentValue -= temp*x;
        ((DataMovingObject)affectedObject).vectY.currentValue -= temp*y;
        ((DataMovingObject)affectedObject).isMoving = true;

        if(currentTic == targetTic) release();
    }

    @Override
    public void release() {
        affectedObject.effects.remove(this.id);
        ((DataMovingObject)affectedObject).vectX.returnToBase();
        ((DataMovingObject)affectedObject).vectY.returnToBase();
        ((DataMovingObject)affectedObject).isControllable = true;
        ((DataMovingObject)affectedObject).isMoving = false;
        affectedObject.effects.put(2, new GameLogicEffectDodge2(affectedObject, currentTic, 0)); //this effect has fixed duration
    }
}
