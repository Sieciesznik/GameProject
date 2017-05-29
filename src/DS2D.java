/**
 * Created by Arkadiusz Nowak on 19.05.2017.
 */

import java.awt.*;

public class DS2D {

    public static void main(String [ ] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                GameCentralUnit GCU = new GameCentralUnit();
                GCU.init();
                GameFrame GF = new GameFrame();
                GF.init(GCU.gamePanel, GCU.gameTimeController, GCU.gameKeyboardController);
            }
        });
    }
}
