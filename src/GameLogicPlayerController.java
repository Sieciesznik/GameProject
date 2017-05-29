import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Arkadiusz Nowak on 28.05.2017.
 */
public class GameLogicPlayerController extends GameLogicController{

    DataCharacterObject playerCharacter;
    int startingX = 800;
    int startingY = 500;
    int startingSpeed = 5;
    int startingHitPoints = 100;
    int startingManaPoints = 10;
    long tic;
    long animationTic;
    boolean isShiftPressed = false;

    public GameLogicPlayerController(ArrayList<DataPanelScreenElement> dpse){
        super(dpse);
        playerCharacter = new DataCharacterObject(  0, "player", new DataPanelScreenElement(0, "player0", startingX, startingY),
                                                    startingX, startingY, 1, 0, 0, 0,
                                                    true, true, startingSpeed, false, true,
                                                    startingHitPoints, startingManaPoints);
        dataPanelScreenElements.add(playerCharacter.dataPanelScreenElement);
    }

    public void keyPressed(Set<Integer> keysSet){
        evaluateMovementKeys(keysSet);

    }

    private void evaluateMovementKeys(Set<Integer> keysSet){

        playerCharacter.stop();
        playerCharacter.isMoving = false;

        boolean movedUp     = false;
        boolean movedDown   = false;
        boolean movedLeft   = false;
        boolean movedRight  = false;
        double diagonalSpeed = 0.707;
        isShiftPressed = false;

        for(Integer i : keysSet){

            if(i==16) isShiftPressed = true;

        }

        if(playerCharacter.isControllable){
            for(Integer i : keysSet){
                     if(i==87) movedUp    = true;            // 87 == 'w'
                else if(i==83) movedDown  = true;            // 83 == 's'
                else if(i==65) movedLeft  = true;            // 65 == 'a'
                else if(i==68) movedRight = true;            // 68 == 'd'
                else if(i==32 && !playerCharacter.effects.containsKey(0) && !playerCharacter.effects.containsKey(1)) playerCharacter.effects.put(0, new GameLogicEffectDodge(playerCharacter, tic, 0));
            }

                    if(  movedUp && !movedDown  && (!movedLeft == !movedRight)) playerCharacter.vectY -= playerCharacter.speed;
            else    if( !movedUp &&  movedDown  && (!movedLeft == !movedRight)) playerCharacter.vectY += playerCharacter.speed;
            else    if((!movedUp == !movedDown) &&   movedLeft && !movedRight)  playerCharacter.vectX -= playerCharacter.speed;
            else    if((!movedUp == !movedDown) &&  !movedLeft &&  movedRight)  playerCharacter.vectX += playerCharacter.speed;

            else    if( movedUp && !movedDown &&  movedLeft && !movedRight){    playerCharacter.vectY -= playerCharacter.speed * diagonalSpeed; playerCharacter.vectX -= playerCharacter.speed * diagonalSpeed;}
            else    if( movedUp && !movedDown && !movedLeft &&  movedRight){    playerCharacter.vectY -= playerCharacter.speed * diagonalSpeed; playerCharacter.vectX += playerCharacter.speed * diagonalSpeed;}
            else    if(!movedUp &&  movedDown &&  movedLeft && !movedRight){    playerCharacter.vectY += playerCharacter.speed * diagonalSpeed; playerCharacter.vectX -= playerCharacter.speed * diagonalSpeed;}
            else    if(!movedUp &&  movedDown && !movedLeft &&  movedRight){    playerCharacter.vectY += playerCharacter.speed * diagonalSpeed; playerCharacter.vectX += playerCharacter.speed * diagonalSpeed;}


        }


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
        this.tic = tic;
        playerCharacter.move();
    }

    public void runEffects(){
        for(Map.Entry <Integer, GameLogicEffect> entry : playerCharacter.effects.entrySet()){
            entry.getValue().run(tic);
        }
    }
}
