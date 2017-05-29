import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public final class GameStaticMaps {

    private GameStaticMaps(){}

    static Map<String, String> graphicTagsToPath = new HashMap<>();
    static {
        graphicTagsToPath.put("hero", "C:\\Users\\Arkadiusz Nowak\\IdeaProjects\\DarkSouls2D\\assets\\actors\\hero.bmp");
        graphicTagsToPath.put("druid", "C:\\Users\\Arkadiusz Nowak\\IdeaProjects\\DarkSouls2D\\assets\\actors\\druid.bmp");
        graphicTagsToPath.put("player0", "C:\\Users\\Arkadiusz Nowak\\IdeaProjects\\DarkSouls2D\\assets\\actors\\player0.bmp");
        graphicTagsToPath.put("player1", "C:\\Users\\Arkadiusz Nowak\\IdeaProjects\\DarkSouls2D\\assets\\actors\\player1.bmp");
        graphicTagsToPath.put("player2", "C:\\Users\\Arkadiusz Nowak\\IdeaProjects\\DarkSouls2D\\assets\\actors\\player2.bmp");
    }

}
