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

    public GameKeyboardController(GameLogicPlayerController glpc){
        this.gameLogicPlayerController = glpc;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gameLogicPlayerController.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameLogicPlayerController.keyReleased(e.getKeyCode());
    }
}
