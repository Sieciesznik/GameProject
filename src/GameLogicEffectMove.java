import javax.xml.crypto.Data;

/**
 * Created by Arkadiusz Nowak on 01.06.2017.
 */
public class GameLogicEffectMove extends GameLogicEffect {

    boolean movedUp;
    boolean movedDown;
    boolean movedLeft;
    boolean movedRight;

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

        ((DataMovingObject)affectedObject).stop();

        double diagonalSpeed = 0.707;

        if(  movedUp && !movedDown  && (!movedLeft == !movedRight)) ((DataMovingObject)affectedObject).vectY.currentValue -= ((DataMovingObject)affectedObject).speed.currentValue;
        else    if( !movedUp &&  movedDown  && (!movedLeft == !movedRight)) ((DataMovingObject)affectedObject).vectY.currentValue += ((DataMovingObject)affectedObject).speed.currentValue;
        else    if((!movedUp == !movedDown) &&   movedLeft && !movedRight)  ((DataMovingObject)affectedObject).vectX.currentValue -= ((DataMovingObject)affectedObject).speed.currentValue;
        else    if((!movedUp == !movedDown) &&  !movedLeft &&  movedRight)  ((DataMovingObject)affectedObject).vectX.currentValue += ((DataMovingObject)affectedObject).speed.currentValue;

        else    if( movedUp && !movedDown &&  movedLeft && !movedRight){    ((DataMovingObject)affectedObject).vectY.currentValue -= ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed; ((DataMovingObject)affectedObject).vectX.currentValue -= ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed;}
        else    if( movedUp && !movedDown && !movedLeft &&  movedRight){    ((DataMovingObject)affectedObject).vectY.currentValue -= ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed; ((DataMovingObject)affectedObject).vectX.currentValue += ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed;}
        else    if(!movedUp &&  movedDown &&  movedLeft && !movedRight){    ((DataMovingObject)affectedObject).vectY.currentValue += ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed; ((DataMovingObject)affectedObject).vectX.currentValue -= ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed;}
        else    if(!movedUp &&  movedDown && !movedLeft &&  movedRight){    ((DataMovingObject)affectedObject).vectY.currentValue += ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed; ((DataMovingObject)affectedObject).vectX.currentValue += ((DataMovingObject)affectedObject).speed.currentValue * diagonalSpeed;}

    }

    @Override
    public void release() {

    }

    public void setFlags(boolean up, boolean down, boolean left, boolean right){
        this.movedUp = up;
        this.movedDown = down;
        this.movedLeft = left;
        this.movedRight = right;

    }
}
