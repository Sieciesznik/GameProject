import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class DataGenericObject {

    int id;
    String name;
    DataPanelScreenElement dataPanelScreenElement;
    Map<Integer, GameLogicEffect> effects;

    public DataGenericObject(int id, String name, DataPanelScreenElement dataPanelScreenElement){
        this.id = id;
        this.name = name;
        this.dataPanelScreenElement = dataPanelScreenElement;
        this.effects = new HashMap<>();
    }

}
