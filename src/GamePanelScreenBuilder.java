import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class GamePanelScreenBuilder {

    private Graphics2D screen;
    private GamePanelAssetsHandler gamePanelAssetsHandler;
    public ArrayList<DataPanelScreenElement> panelScreenContent = new ArrayList<>();

    public GamePanelScreenBuilder(GamePanelAssetsHandler assetsHandler){
        this.gamePanelAssetsHandler = assetsHandler;
    }

    public Graphics2D getScreen(){
        build();
        return screen;
    }

    private void build(){

        for(DataPanelScreenElement element : panelScreenContent){
            screen.drawImage(gamePanelAssetsHandler.imageDataBase.get(element.graphics), element.positionX, element.positionY, null);
        }

    }

    public void setScreen(Graphics2D screen){
        this.screen = screen;
    }
}
