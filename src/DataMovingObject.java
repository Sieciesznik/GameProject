import javafx.util.Pair;

import javax.xml.crypto.Data;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class DataMovingObject extends DataGenericObject {

    double x;
    double y;
    double z;
    DataAttribute vectX;
    DataAttribute vectY;
    double vectZ;
    boolean collision;
    boolean gravity;
    DataAttribute speed;
    boolean isMoving;
    boolean isControllable;

    public DataMovingObject(int id, String name, DataPanelScreenElement dpse, double x, double y, double z, double vectX, double vectY, double vectZ,
                            boolean collision, boolean gravity, double speed, boolean isMoving, boolean isControllable){
        super(id, name, dpse);

        this.x = x;
        this.y = y;
        this.z = z;
        this.vectX = new DataAttribute(vectX);
        this.vectY = new DataAttribute(vectY);
        this.vectZ = vectZ;
        this.collision = collision;
        this.gravity = gravity;
        this.speed = new DataAttribute(speed);
        this.isMoving = isMoving;
        this.isControllable = isControllable;
    }



    public void move(){
        x += vectX.currentValue;
        y += vectY.currentValue;
        if(gravity) z += vectZ;
        dataPanelScreenElement.positionX = (int)x;
        dataPanelScreenElement.positionY = (int)y;

    }

    public void stop(){
        vectX.returnToBase();
        vectY.returnToBase();
    }

}
