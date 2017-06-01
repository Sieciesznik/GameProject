import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Arkadiusz Nowak on 28.05.2017.
 */
public class GameLogicPlayerController extends GameLogicController{

    DataCharacterObject playerCharacter;
    int startingX = 800;
    int startingY = 500;
    int startingSpeed = 10;
    int startingHitPoints = 100;
    int startingManaPoints = 10;
    long tic;
    long animationTic;
    boolean isShiftPressed = false;
    Set <Integer> pressedKeys = new HashSet<>();

    public GameLogicPlayerController(GameLogicDisplayController gldc){
        super(gldc);
        playerCharacter = new DataCharacterObject(  0, "player", new DataPanelScreenElement(3, "player0", startingX, startingY),
                                                    startingX, startingY, 1,
                                                    true, true, startingSpeed, false, true,
                                                    startingHitPoints, startingManaPoints);
        playerCharacter.effects.put(0, new GameLogicEffectMove(playerCharacter, tic, 0));

        gameLogicDisplayController.addObject(playerCharacter);
    }

    void keyPressed(int keyCode){

        pressedKeys.add(keyCode);
        checkFlagKeys();
        checkSkillKeys();
        evaluateMovementKeys();

    }

    void keyReleased(int keyCode){

        pressedKeys.remove(keyCode);
        checkFlagKeys();
        checkSkillKeys();
        evaluateMovementKeys();
    }

    private void checkFlagKeys(){
        isShiftPressed = false;

        for(Integer i : pressedKeys){
            if(i==16) isShiftPressed = true;
        }
    }

    public void checkSkillKeys(){

        for(Integer i : pressedKeys){
            if(i==32 && !playerCharacter.effects.containsKey(1) && !playerCharacter.effects.containsKey(2))
                playerCharacter.effects.put(1, new GameLogicEffectDodge(playerCharacter, tic, 0));
        }
    }

    private void evaluateMovementKeys(){

        playerCharacter.stop();         //this is needed to maintain continuous movement

        playerCharacter.isMoving = false;

        boolean movedUp     = false;
        boolean movedDown   = false;
        boolean movedLeft   = false;
        boolean movedRight  = false;

        if(playerCharacter.isControllable){
            for(Integer i : pressedKeys){
                     if(i==87) movedUp    = true;            // 87 == 'w'
                else if(i==83) movedDown  = true;            // 83 == 's'
                else if(i==65) movedLeft  = true;            // 65 == 'a'
                else if(i==68) movedRight = true;            // 68 == 'd'
            }

        }

        GameLogicEffectMove effectMove = (GameLogicEffectMove) playerCharacter.effects.get(0);
        effectMove.setFlags(movedUp, movedDown, movedLeft, movedRight);

        //animation
        if(movedUp || movedDown || movedLeft || movedRight) {
            playerCharacter.isMoving = true;
            if (((tic - animationTic) / 30) % 2 == 0) {
                playerCharacter.dataPanelScreenElement.graphics = "player1";
            } else {
                playerCharacter.dataPanelScreenElement.graphics = "player2";
            }
        }
        else {
            animationTic = tic;
            playerCharacter.dataPanelScreenElement.graphics = "player0";
        }


    }

    public void move(long tic){
        this.tic = tic; //this way controller gets updated every tic
        playerCharacter.move();
    }

    public void runEffects(){
        for(Map.Entry <Integer, GameLogicEffect> entry : playerCharacter.effects.entrySet()){
            if (entry.getValue().isActive) entry.getValue().run(tic);
        }
    }
}
