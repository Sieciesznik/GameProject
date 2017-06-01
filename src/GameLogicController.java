import java.util.ArrayList;

/**
 * Created by Arkadiusz Nowak on 28.05.2017.
 */
public class GameLogicController {

    ArrayList <DataMovingObject> controlledObjects;
    GameLogicController gameLogicSiblingController;
    GameLogicDisplayController gameLogicDisplayController;

    public GameLogicController(GameLogicDisplayController gldc){
        this.gameLogicDisplayController = gldc;
    }

    public void setGameLogicSiblingController(GameLogicController gameLogicSiblingController){
        this.gameLogicSiblingController = gameLogicSiblingController;
    }

    protected void passTheObject(int index){
        gameLogicSiblingController.controlledObjects.add(controlledObjects.get(index));
    }

    public void addObject(DataMovingObject object){
        controlledObjects.add(object);
    }
}
