import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BackGround {
	private BufferedImage bgImage = null;// 当前的背景
	private List<Obstruction> allObstruction = new ArrayList<Obstruction>();// 全部的障碍物队列

	public BackGround(int index, boolean flag) {
        bgImage = StaticValue.startImage;// 游戏场景

        Obstruction ob = new Obstruction(60, 540, 9);
        ob.setInAir(true);
        this.allObstruction.add(ob);
    }

	public List<Obstruction> getAllObstruction() {
		return allObstruction;
	}

	public BufferedImage getBgImage() {
		return bgImage;
	}
}
