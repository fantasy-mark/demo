import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * Project Resouce
 *
 * @author mark.huang@rich-power.com.cn
 */
public class Resource {
    public static BufferedImage bgImage = null;
    public static String imagePath = System.
        getProperty("user.dir") + "/image/";

    public static void init() {
        try {
            bgImage = ImageIO.read(new File(imagePath + "bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Put file bg.png into image/!");
        }
    }
}
