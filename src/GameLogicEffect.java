/**
 * Created by Arkadiusz Nowak on 29.05.2017.
 */
public abstract class GameLogicEffect implements Effectable{

    DataGenericObject affectedObject;
    long startingTic;
    long targetTic;
    boolean isActive;
    int id;
    int priority;

    GameLogicEffect(DataGenericObject affectedObject, long startingTic, int duration){
        this.affectedObject = affectedObject;
        this.startingTic = startingTic;
        this.targetTic = startingTic + duration;
    }
}
