import java.util.ArrayList;

/**
 * Created by Arkadiusz Nowak on 27.05.2017.
 */
public class GameLogicActiveController extends GameLogicController{

    public GameLogicActiveController(GameLogicDisplayController gldc){
        super(gldc);
        controlledObjects = new ArrayList<>();

    }

    public void testMoveRight(){
        for(DataMovingObject o : controlledObjects){
            o.vectX.currentValue = o.speed.currentValue;
        }
    }

    public  void move(){
        for(DataMovingObject o : controlledObjects){
            o.move();
        }
    }

}
