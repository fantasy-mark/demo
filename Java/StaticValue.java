import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StaticValue {
    public static BufferedImage startImage = null;

	public static BufferedImage bgImage = null;// 场景的图片
	public static List<BufferedImage> allObstructionImage = new ArrayList<BufferedImage>();// 所有障碍物的图片,12

    public static List<BufferedImage> allMarioImage = new ArrayList<BufferedImage>();// 马里奥的图片，10

    // use '/' in linux
	public static String imagePath = System.getProperty("user.dir") + "/image/";

    public static void init() {
        System.out.print("==> " + imagePath + " <==\n");

        // 初始化所有Mario的图片
        //allMarioImage.add(ImageIO.read(new File(imagePath + i + ".png")));

        try {
            startImage = ImageIO.read(new File(imagePath + "start.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //初始化所有的障碍物图片
        for(int i=0;i<=11;i++)
        {
            try{
                allObstructionImage.add(ImageIO.read(new File(imagePath+"ob" + i + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
