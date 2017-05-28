import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arkadiusz Nowak on 28.05.2017.
 */
public class GameKeyboardController implements KeyListener {

    GameLogicPlayerController gameLogicPlayerController;
    Set <Integer> pressedKeys = new HashSet<>();

    public GameKeyboardController(GameLogicPlayerController glpc){
        this.gameLogicPlayerController = glpc;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        gameLogicPlayerController.keyPressed(pressedKeys);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        gameLogicPlayerController.keyPressed(pressedKeys);
    }
}
