import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * User Interface
 *
 * @author mark.huang@rich-power.com.cn
 */
public class UI extends JFrame implements Runnable {
    private static BackGround nowBG = null;
    //------------
    private List<BackGround> allBG = new ArrayList<BackGround>();
    private Thread t = new Thread(this);

    public static void main(String args[]) {
        UI ui = new UI();
        ui.init();
    }

    public void init() {
        this.setTitle("V");
        this.setSize(800, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        Resource.init();
        /**
         * Oops : setVisible will Frame.paint one time
         * Pleace it after Resource.init()
         */
        this.setVisible(true);
        //this.nowBG = new BackGround();
        this.allBG.add(new BackGround());
        this.nowBG = this.allBG.get(0);
        t.start();
    }


    /**
     * See Runnable
     */
    public void run() {
        this.repaint();

        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }

    /**
     * @1. create image buffer
     * @2. get image object
     * @3. draw
     */
    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(
                800, 480, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g2 = image.getGraphics();
        g2.drawImage(nowBG.getBgImage(), 0, 0, this);

        g.drawImage(image, 0, 0, this);
    }
}
