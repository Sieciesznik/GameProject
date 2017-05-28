import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

    public GameLogicPlayerController(ArrayList<DataPanelScreenElement> dpse){
        super(dpse);
        playerCharacter = new DataCharacterObject(  0, "player", new DataPanelScreenElement(0, "hero", startingX, startingY),
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
        boolean movedUp     = false;
        boolean movedDown   = false;
        boolean movedLeft   = false;
        boolean movedRight  = false;
        double diagonalSpeed = 0.707;

        if(playerCharacter.isControllable){
            for(Integer i : keysSet){
                    if(i==87) movedUp    = true;
               else if(i==83) movedDown  = true;
               else if(i==65) movedLeft  = true;
               else if(i==68) movedRight = true;

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

    }

    public void move(){

        playerCharacter.move();
    }
}
