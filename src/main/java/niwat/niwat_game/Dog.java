package niwat.niwat_game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class Dog {
    public int x, y, dogSize, health, score;
    private int jumpHigh = 120;
    public boolean jmp = false;
    public boolean hit = false;
    public Dog() {
    }
    public String get_score() {
        return "Score : " + this.score;
    }
    public void reset_hit() {
        this.y = this.jumpHigh;
        this.hit = true;
    }
    public Dog(int x, int y, int dogSize, int health) {
        this.x = x;
        this.y = y;
        this.dogSize = dogSize;
        this.health = health;
        this.score = 0;
    }
    public void jump(Game game) {
        this.y -= jumpHigh;
        this.jmp = true;
        game.repaint();
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jmp = false;
                y += jumpHigh;
                game.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
