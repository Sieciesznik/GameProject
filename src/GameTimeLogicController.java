/**
 * Created by Arkadiusz Nowak on 27.05.2017.
 */
public class GameTimeLogicController {

    GameLogicPlayerController gameLogicPlayerController;
    GameLogicActiveController gameLogicActiveController;
    GameLogicIdleController gameLogicIdleController;
    GameLogicDisplayController gameLogicDisplayController;

    GameTimeLogicController(GameLogicPlayerController glpc, GameLogicActiveController glac, GameLogicIdleController glic, GameLogicDisplayController gldc){
        this.gameLogicPlayerController = glpc;
        this.gameLogicActiveController = glac;
        this.gameLogicIdleController = glic;
        this.gameLogicDisplayController = gldc;
    }

    public void runLogic(long tic){

        gameLogicPlayerController.runEffects();
        gameLogicActiveController.testMoveRight();
        gameLogicPlayerController.move(tic);
        gameLogicActiveController.move();

        gameLogicDisplayController.checkDisplay();

    }

}
