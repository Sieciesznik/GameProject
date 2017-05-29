import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class GameTimeController {

    int breakTime;
    long tic;

    GamePanel gamePanel;
    Timer timer;
    TimerTask timerTask;
    GameTimeLogicController gameTimeLogicController;


    public GameTimeController(GamePanel gamePanel, GameTimeLogicController gameTimeLogicController){
        this.breakTime = 17;
        this.tic = 0;
        this.gamePanel = gamePanel;
        this.gameTimeLogicController = gameTimeLogicController;


        this.timer = new Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                tic++;
                gameTimeLogicController.runLogic(tic);
                gamePanel.repaint();
            }
        };
    }

    public void start(){
        timer.scheduleAtFixedRate(timerTask, 0, breakTime);

    }

}
