import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class GameTimeController {

    int breakTime;

    GamePanel gamePanel;
    Timer timer;
    TimerTask timerTask;
    GameTimeLogicController gameTimeLogicController;

    public GameTimeController(GamePanel gamePanel, GameTimeLogicController gameTimeLogicController){
        this.breakTime = 17;
        this.gamePanel = gamePanel;
        this.gameTimeLogicController = gameTimeLogicController;

        this.timer = new Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {

                gameTimeLogicController.runLogic();
                gamePanel.repaint();
            }
        };
    }

    public void start(){
        timer.scheduleAtFixedRate(timerTask, 0, breakTime);

    }

}
