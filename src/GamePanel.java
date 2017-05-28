/**
 * Created by Arkadiusz Nowak on 23.05.2017.
 */
import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    public GamePanelScreenBuilder screenBuilder;

    public GamePanel() {
        setBackground(new Color(0xffffff));
    }

    @Override
    protected void paintComponent(Graphics scene) {
        super.paintComponent(scene);
        Graphics2D screen = (Graphics2D) scene;
        screenBuilder.setScreen(screen);

        screenBuilder.getScreen();
    }
}
