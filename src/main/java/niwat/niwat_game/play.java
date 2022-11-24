package niwat.niwat_game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class play extends JFrame implements ActionListener{
    Home h = new Home();
    Game g = new Game();
    public play() {
                this.add(h);
                g.Backtomanu.addActionListener(this);
                g.Starttomanu.addActionListener(this);
                h.BStart.addActionListener(this);
                h.Bexit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == h.BStart){
            this.remove(h);
            this.add(g);
            g.reset_game();
            g.requestFocusInWindow();
            this.revalidate();
            this.repaint();
            System.out.println("game start");
        }
        else if(e.getSource() == h.Bexit){
            System.exit(0);
        }else if(e.getSource() == g.Backtomanu){
            this.remove(g);
            this.add(h);
            g.reset_game();
            h.requestFocusInWindow();
            this.revalidate();
            System.out.println("Backtomanu");
            this.repaint();
        }
    }
	public static void main(String[] args) {
             JFrame wd = new play();
            wd.setSize(1000,600);
            wd.setResizable(false);
            wd.setTitle("Game dog");
            wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            wd.setLocationRelativeTo(null);
            wd.setVisible(true);
    }
}
