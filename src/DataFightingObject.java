/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class DataFightingObject extends DataMovingObject {

    int hitPoints;
    int manaPoints;

    public DataFightingObject(int id, String name, DataPanelScreenElement dpse, double x, double y, double z, double vectX, double vectY, double vectZ,
                              boolean collision, boolean gravity, double speed, boolean isMoving, boolean isControllable,
                              int hitPoints, int manaPoints) {
        super(id, name, dpse, x, y, z, vectX, vectY, vectZ, collision, gravity, speed, isMoving, isControllable);
        this.hitPoints = hitPoints;
        this.manaPoints = manaPoints;

    }
}
