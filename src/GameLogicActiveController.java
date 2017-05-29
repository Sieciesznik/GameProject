import java.util.ArrayList;

/**
 * Created by Arkadiusz Nowak on 27.05.2017.
 */
public class GameLogicActiveController extends GameLogicController{

    public GameLogicActiveController(ArrayList<DataPanelScreenElement> dpse){
        super(dpse);


        dataPanelScreenElements.add(ShitTestGenerator.getNewActor(0,"hero", 600,170, 0, 0));
        dataPanelScreenElements.add(ShitTestGenerator.getNewActor(1,"druid", 230,400, 0.2, 0));
        dataPanelScreenElements.add(ShitTestGenerator.getNewActor(2,"hero", 200,500, 4, -2.3));

    }

}
