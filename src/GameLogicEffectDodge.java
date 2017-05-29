/**
 * Created by Arkadiusz Nowak on 29.05.2017.
 */
public class GameLogicEffectDodge extends GameLogicEffect {

    long currentTic;

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
        this.currentTic = currentTic;

        ((DataMovingObject)affectedObject).vectX += 10;
        ((DataMovingObject)affectedObject).isMoving = true;
        ((DataMovingObject)affectedObject).isControllable = false;

        if(currentTic == targetTic) release();
    }

    @Override
    public void release() {
        affectedObject.effects.remove(this.id);
        ((DataMovingObject)affectedObject).vectX = 0;
        ((DataMovingObject)affectedObject).isControllable = true;
        ((DataMovingObject)affectedObject).isMoving = false;
        affectedObject.effects.put(1, new GameLogicEffectDodge2(affectedObject, currentTic, 0)); //this effect has fixed duration
    }
}
