/**
 * Created by Arkadiusz Nowak on 02.06.2017.
 */
public class GameInitCharCreator {// this class is a singleton

    int id = 1; //0 is taken by player
    GameLogicDisplayController gameLogicDisplayController;
    GameLogicActiveController gameLogicActiveController;
    GameLogicIdleController gameLogicIdleController;

    GameInitCharCreator(GameLogicDisplayController gldc, GameLogicActiveController glac, GameLogicIdleController glic){
        this.gameLogicDisplayController = gldc;
        this.gameLogicActiveController = glac;
        this.gameLogicIdleController = glic;

        addCharacter("warrior1","hero", 600,170, 10, true);
        addCharacter("druid","druid", 230,400, 10, true);
        addCharacter("warrior2","hero", 200,500, 10, true);
    }


    public DataCharacterObject createCharacter(String name, String graphics, double posX, double posY, double speed){

        return new DataCharacterObject(id++, name, new DataPanelScreenElement(3, graphics, (int)posX, (int)posY), posX, posY, 0,
                                        true, true, speed, false, true, 100, 10);
    }

    public void addCharacter(String name, String graphics, double posX, double posY, double speed, boolean isActive){
        DataCharacterObject newObject = createCharacter(name, graphics, posX, posY, speed);
        gameLogicDisplayController.addObject(newObject);
        if(isActive)    gameLogicActiveController.addObject(newObject);
        else            gameLogicIdleController.addObject(newObject);
    }
}
