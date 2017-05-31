/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class DataCharacterObject extends DataFightingObject {


    public DataCharacterObject(int id, String name, DataPanelScreenElement dpse, double x, double y, double z,
                               boolean collision, boolean gravity, double speed, boolean isMoving, boolean isControllable, int hitPoints, int manaPoints) {
        super(id, name, dpse, x, y, z, collision, gravity, speed, isMoving, isControllable, hitPoints, manaPoints);
    }
}
