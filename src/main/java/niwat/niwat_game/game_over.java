package niwat.niwat_game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class game_over extends JPanel {
    private String score;
	public game_over(){     
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 =(Graphics2D)g;
            try {
                g2.drawImage(ImageIO.read(new File("img\\bover.png")), 0,0,1000,600,null,null);
            } catch (IOException ex) {
                System.out.println("not found;");
            }   
    }
    public String get_score() {
        return "Score : " + this.score;
    }
}
