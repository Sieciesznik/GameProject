/**
 * Created by Arkadiusz Nowak on 01.06.2017.
 */
public class GameLogicEffectMove extends GameLogicEffect {

    GameLogicEffectMove(DataGenericObject affectedObject, long startingTic, int duration) {
        super(affectedObject, startingTic, duration);
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

    }

    @Override
    public void release() {

    }
}
