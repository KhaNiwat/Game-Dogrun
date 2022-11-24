package niwat.niwat_game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Home extends JPanel {
    private BT A = new BT(); 
    private ImageIcon btst = new ImageIcon(BT.bst);
    private ImageIcon btex = new ImageIcon(BT.bex);
    public JButton BStart= new JButton(btst);
    public JButton Bexit= new JButton(btex);
    public Home(){
        setLayout(null);
        BStart.setBounds(380, 200, 200, 60);
        add(BStart);
        Bexit.setBounds(380, 300, 200, 60);
        add(Bexit);      
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 =(Graphics2D)g;
            try {
                g2.drawImage(ImageIO.read(new File("img\\B1.png")), 0,0,1000,600,null,null);
                g2.drawImage(ImageIO.read(new File("img\\DD1.png")), 100,250,200,200,null,null);
                g2.drawImage(ImageIO.read(new File("img\\PDOG.png")), 330,50,300,90,null,null);

            } catch (IOException ex) {
                System.out.println("not found;");
            }
        g2.drawImage(BT.bst, 380, 200, 200, 60,null,null);
        g2.drawImage(BT.bex, 380, 300, 200, 60,null,null);
    }    
}
