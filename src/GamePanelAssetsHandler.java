import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arkadiusz Nowak on 24.05.2017.
 */
public class GamePanelAssetsHandler {

    public Map<String, BufferedImage> imageDataBase = new HashMap<>();


    //simply make map with graphic based on GameStaticMaps.graphicTagsToPath map
    public GamePanelAssetsHandler(){

        for (Map.Entry<String, String> entry : GameStaticMaps.graphicTagsToPath.entrySet()){

            try {
                imageDataBase.put(entry.getKey(), ImageIO.read(new java.io.File(entry.getValue())));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(entry.getKey() + " not found in " + entry.getValue());
            }
        }
    }

}
