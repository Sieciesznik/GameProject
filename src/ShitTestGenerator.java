import java.util.ArrayList;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class ShitTestGenerator {

    public static ArrayList<DataCharacterObject> characters = new ArrayList<>();

    public static DataPanelScreenElement getNewActor(int id, String graphics, int x, int y, double vectX, double vectY){

        DataPanelScreenElement dpse = new DataPanelScreenElement(1, graphics, x, y);
        DataCharacterObject hero = new DataCharacterObject(id, "Test"+id, dpse, x, y, 1, vectX, vectY, 0, true, true, 5, true, true,100, 10);
        characters.add(hero);
        return dpse;
    }
}
