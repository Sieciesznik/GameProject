/**
 * Created by Arkadiusz Nowak on 23.05.2017.
 */
import javax.swing.*;

public class GameFrame extends JFrame{

    GamePanel gamePanel;
    GameKeyboardController gameKeyboardController;
    GameTimeController gameTimeController;

    public GameFrame() {
        super("DS2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setVisible(true);
    }

    public void init(GamePanel newPanel, GameTimeController newGameTimeController, GameKeyboardController newGameKeyboardController){
        gamePanel = newPanel;
        gameKeyboardController = newGameKeyboardController;
        gameTimeController = newGameTimeController;

        add(gamePanel);
        addKeyListener(gameKeyboardController);
        gameTimeController.start();
    }
}
