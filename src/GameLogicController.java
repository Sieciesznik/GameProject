import java.util.ArrayList;

/**
 * Created by Arkadiusz Nowak on 28.05.2017.
 */
public class GameLogicController {

    ArrayList <DataMovingObject> controlledObjects;
    ArrayList <DataPanelScreenElement> dataPanelScreenElements;
    GameLogicController gameLogicSiblingController;

    public GameLogicController(ArrayList<DataPanelScreenElement> dpse){
        this.dataPanelScreenElements = dpse;
    }

    public void setGameLogicSiblingController(GameLogicController gameLogicSiblingController){
        this.gameLogicSiblingController = gameLogicSiblingController;
    }

    protected void passTheObject(int index){
        gameLogicSiblingController.controlledObjects.add(controlledObjects.get(index));
    }
}
