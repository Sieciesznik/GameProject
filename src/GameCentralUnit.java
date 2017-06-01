
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
    GameLogicDisplayController gameLogicDisplayController;
    GameLogicActiveController gameLogicActiveController;
    GameLogicIdleController gameLogicIdleController;
    GameLogicPlayerController gameLogicPlayerController;
    GameInitCharCreator gameInitCharCreator;

    public void  init(){

        gamePanel = new GamePanel();
        gamePanelAssetsHandler = new GamePanelAssetsHandler();
        gamePanelScreenBuilder = new GamePanelScreenBuilder(gamePanelAssetsHandler);
        gamePanel.screenBuilder = gamePanelScreenBuilder;

        gameLogicDisplayController = new GameLogicDisplayController(gamePanel.screenBuilder.panelScreenContent, 1000, 800);
        gameLogicPlayerController = new GameLogicPlayerController(gameLogicDisplayController);
        gameLogicActiveController = new GameLogicActiveController(gameLogicDisplayController);
        gameLogicIdleController = new GameLogicIdleController(gameLogicDisplayController);
        gameLogicActiveController.setGameLogicSiblingController(gameLogicIdleController);
        gameLogicIdleController.setGameLogicSiblingController(gameLogicActiveController);

        gameTimeLogicController = new GameTimeLogicController(gameLogicPlayerController, gameLogicActiveController, gameLogicIdleController, gameLogicDisplayController);
        gameTimeController = new GameTimeController(gamePanel, gameTimeLogicController);
        gameKeyboardController = new GameKeyboardController(gameLogicPlayerController);

        gameInitCharCreator = new GameInitCharCreator(gameLogicDisplayController, gameLogicActiveController, gameLogicIdleController);
    }
}
