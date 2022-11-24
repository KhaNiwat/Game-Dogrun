package niwat.niwat_game;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
class BT {
    public static Image bst;
    public static Image bex;
    public static Image bbtm;
    public static Image[] p_dog = new Image[2];
    public static Image[] bg = new Image[3];
    public BT() {
        try {
            p_dog[0] = ImageIO.read(new File("img\\DD1.png"));
            p_dog[1] = ImageIO.read(new File("img\\DD2.png"));
            bst = ImageIO.read(new File("img\\start.png"));
            bex = ImageIO.read(new File("img\\exit.png"));
            bbtm = ImageIO.read(new File("img\\back.png"));
            bg[0] = ImageIO.read(new File("img\\1.png"));
            bg[1] = ImageIO.read(new File("img\\2.png"));
        } catch (Exception e) {
        }  
}
}