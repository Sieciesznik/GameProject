/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class DataMovingObject extends DataGenericObject {

    double x;
    double y;
    double z;
    double vectX;
    double vectY;
    double vectZ;
    boolean collision;
    boolean gravity;
    double speed;
    boolean isMoving;
    boolean isControllable;

    public DataMovingObject(int id, String name, DataPanelScreenElement dpse, double x, double y, double z, double vectX, double vectY, double vectZ,
                            boolean collision, boolean gravity, double speed, boolean isMoving, boolean isControllable){
        super(id, name, dpse);

        this.x = x;
        this.y = y;
        this.z = z;
        this.vectX = vectX;
        this.vectY = vectY;
        this.vectZ = vectZ;
        this.collision = collision;
        this.gravity = gravity;
        this.speed = speed;
        this.isMoving = isMoving;
        this.isControllable = isControllable;
    }



    public void move(){
        x += vectX;
        y += vectY;
        if(gravity) z += vectZ;
        dataPanelScreenElement.positionX = (int)x;
        dataPanelScreenElement.positionY = (int)y;

    }

    public void stop(){
        vectX = 0;
        vectY = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getVectX() {
        return vectX;
    }

    public double getVectY() {
        return vectY;
    }

    public double getVectZ() {
        return vectZ;
    }

    public boolean isCollision() {
        return collision;
    }

    public boolean isGravity() {
        return gravity;
    }
}
