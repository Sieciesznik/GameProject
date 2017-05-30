/**
 * Created by Arkadiusz Nowak on 27.05.2017.
 */
public class GameTimeLogicController {

    GameLogicPlayerController gameLogicPlayerController;
    GameLogicActiveController gameLogicActiveController;
    GameLogicIdleController gameLogicIdleController;

    GameTimeLogicController(GameLogicPlayerController glpc, GameLogicActiveController glac, GameLogicIdleController glic){
        this.gameLogicPlayerController = glpc;
        this.gameLogicActiveController = glac;
        this.gameLogicIdleController = glic;
    }

    public void runLogic(long tic){

        ShitTestGenerator.characters.get(0).move();
        ShitTestGenerator.characters.get(1).move();
        ShitTestGenerator.characters.get(2).move();

        gameLogicPlayerController.runEffects();
        gameLogicPlayerController.move(tic);


    }

}
