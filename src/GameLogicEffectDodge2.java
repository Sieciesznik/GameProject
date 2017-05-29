/**
 * Created by Arkadiusz Nowak on 29.05.2017.
 */
public class GameLogicEffectDodge2 extends GameLogicEffect {
    GameLogicEffectDodge2(DataGenericObject affectedObject, long startingTic, int duration) {
        super(affectedObject, startingTic, 18);
        this.isActive = true;
        this.id = 1;
        this.priority = 3;
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void run(long currentTic) {

        ((DataMovingObject)affectedObject).speed = 2;

        if(currentTic == targetTic) release();
    }

    @Override
    public void release() {
        affectedObject.effects.remove(this.id);
        ((DataMovingObject)affectedObject).speed = 5;
    }
}
