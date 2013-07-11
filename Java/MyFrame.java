//package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements KeyListener, Runnable {

	//private
	private Thread t = new Thread(this);
	private List<BackGround> allBG = new ArrayList<BackGround>();// 存放背景图片的队列

    //public
    public static BackGround nowBG = null;
    public static Mario mario = null;

	public static void main(String args[]) {
		System.out.print("MyFrame\n");
		MyFrame ui = new MyFrame();
		ui.initUI();
	}

	public void initUI() {
		System.out.print("initUI\n");
		this.setTitle("Mario");
		this.setSize(800, 480);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.start();

        // init all picture
        StaticValue.init();

        // show screen
        this.setVisible(true);
//		int width = Toolkit.getDefaultkit().getScreenSize().width;

        // public BackGround(int index, boolean flag) { 
        this.allBG.add(new BackGround(1, true));

        // add object to screen -> List index is 0
        this.nowBG = this.allBG.get(0);
        this.mario = new Mario(40, 400);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 39) {// 马里奥向右
			System.out.println("right");
			//mario.rightMove();
		}
		if (e.getKeyCode() == 37) {// 马里奥向左
		}
		if (e.getKeyCode() == 38) {// 马里奥跳跃
		}
		if (e.getKeyCode() == 32) {// 马里奥发射子弹
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(800, 480,
              BufferedImage.TYPE_3BYTE_BGR);// 创建缓冲图片
    
        // Use FIFO, very useful!!!
        Graphics g2 = image.getGraphics();
        //picture -> g2.Buff/image.Buff
        //
        g2.drawImage(this.nowBG.getBgImage(), 0, 0, this);
        //
        System.out.print("<===\n");
        // 绘制障碍物
        Iterator<Obstruction> iter = this.nowBG.getAllObstruction().iterator();// 使用迭代器进行遍历
        while (iter.hasNext()) {
            Obstruction ob = iter.next();
            g2.drawImage(ob.getShowImage(), 0, 440, this);

            System.out.println(ob.getX() + "--------------" + ob.getY());
        }

        //g.drawImage(this.nowBG.getBgImage(), 0, 0, this);
        g.drawImage(image, 0, 0, this);
    }

    // implements the Thread
	public void run() {
		while (true) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            System.out.print("sleep\n");
			this.repaint();
		}
	}
}
