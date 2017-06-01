import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arkadiusz Nowak on 01.06.2017.
 */
public class GameLogicDisplayController {

    ArrayList <DataMovingObject> controlledObjects = new ArrayList<>();
    ArrayList<DataPanelScreenElement> visibleScreenElements;
    ArrayList<DataPanelScreenElement> hiddenScreenElements = new ArrayList<>();
    Dimension panelSize;

    GameLogicDisplayController(ArrayList<DataPanelScreenElement> dpse, int panelWidth, int panelHeight){
        this.visibleScreenElements = dpse;
        this.panelSize = new Dimension(panelWidth, panelHeight);
    }

    public void addObject(DataMovingObject object){

        controlledObjects.add(object);

        if    ((object.x > 0 && object.x < panelSize.getWidth()) &&
                object.y > 0 && object.y < panelSize.getHeight())
            visibleScreenElements.add(object.dataPanelScreenElement);
        else
            hiddenScreenElements.add(object.dataPanelScreenElement);
    }

    public void checkDisplay(){

        for (int i = 0; i < hiddenScreenElements.size(); i++) {
            if ((hiddenScreenElements.get(i).positionX > 0 && hiddenScreenElements.get(i).positionX < panelSize.getWidth()) &&
                    hiddenScreenElements.get(i).positionY > 0 && hiddenScreenElements.get(i).positionY < panelSize.getHeight())
                visibleScreenElements.add(hiddenScreenElements.remove(i));
        }

        for (int i = 0; i < visibleScreenElements.size(); i++){
            if ((visibleScreenElements.get(i).positionX < 0 || visibleScreenElements.get(i).positionX > panelSize.getWidth()) ||
                    (visibleScreenElements.get(i).positionY < 0 || visibleScreenElements.get(i).positionY > panelSize.getHeight()))
                hiddenScreenElements.add(visibleScreenElements.remove(i));
        }

    }
}
