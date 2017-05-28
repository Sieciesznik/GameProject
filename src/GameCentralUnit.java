/**
 * Created by Arkadiusz Nowak on 26.05.2017.
 */
public class GameCentralUnit {

    //Graphics
    GamePanel gamePanel;
    GamePanelScreenBuilder gamePanelScreenBuilder;
    GamePanelAssetsHandler gamePanelAssetsHandler;
    GameTimeController gameTimeController;
    GameTimeLogicController gameTimeLogicController;
    GameKeyboardController gameKeyboardController;
    GameLogicActiveController gameLogicActiveController;
    GameLogicIdleController gameLogicIdleController;
    GameLogicPlayerController gameLogicPlayerController;

    public void  init(){

        gamePanel = new GamePanel();
        gamePanelAssetsHandler = new GamePanelAssetsHandler();
        gamePanelScreenBuilder = new GamePanelScreenBuilder(gamePanelAssetsHandler);
        gamePanel.screenBuilder = gamePanelScreenBuilder;


        gameLogicPlayerController = new GameLogicPlayerController(gamePanelScreenBuilder.panelScreenContent);
        gameLogicActiveController = new GameLogicActiveController(gamePanelScreenBuilder.panelScreenContent);
        gameLogicIdleController = new GameLogicIdleController(gamePanelScreenBuilder.panelScreenContent);
        gameLogicActiveController.setGameLogicSiblingController(gameLogicIdleController);
        gameLogicIdleController.setGameLogicSiblingController(gameLogicActiveController);

        gameTimeLogicController = new GameTimeLogicController(gameLogicPlayerController, gameLogicActiveController, gameLogicIdleController);
        gameTimeController = new GameTimeController(gamePanel, gameTimeLogicController);
        gameKeyboardController = new GameKeyboardController(gameLogicPlayerController);
    }
}
