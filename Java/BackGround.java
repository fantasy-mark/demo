import java.awt.image.BufferedImage;

public class BackGround {
    private BufferedImage bgImage = null;

    public BackGround() {
        bgImage = Resource.bgImage;
    }

    public BufferedImage getBgImage() {
        return bgImage;
    }
}
