import java.awt.image.BufferedImage;

/*
 *障碍物类
 */
public class Obstruction implements Runnable {
    private int x = 0, y = 0;
    private int type;

    private boolean inAir = true;

    private Thread t = new Thread(this);
	private BufferedImage showImage = null;     //显示的图片，方法中再进行初始化

	public  Obstruction(int x,int y,int type){
		this.x=x;
		this.y=y;
		this.type=type;
		setImage();
		t.start();//在创建时启动线程
	}

	public void setImage(){
		showImage = StaticValue.allObstructionImage.get(type);
	}

    public void setInAir(boolean inAir) {
        this.inAir = inAir;
    }

	public BufferedImage getShowImage() {
		return showImage;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void run() {
		//写成线程方便操作
		//设置陷阱时需要用到run方法
		//System.out.println("陷阱运动了");
		//y+=yv;
	}
}

