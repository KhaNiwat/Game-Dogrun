package niwat.niwat_game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener {

    ImageIcon img_back_to_menu = new ImageIcon(BT.bbtm);
    ImageIcon img_Start_to_menu = new ImageIcon(BT.bst);
    JButton Backtomanu = new JButton(img_back_to_menu);
    JButton Starttomanu = new JButton(img_Start_to_menu);
    int stage;
    int score = 0;
    int GameSpeed = 30;
    long LastPress = 0;
    Dog dog = new Dog(50, 370, 80, 100);

    private Wave[] waveSet = makeWaveSet(2);
    private BoneItem1[] BoneItem1Set = makeBone1Set(2);
    private BoneItem2[] BoneItem2Set = makeBone2Set(1);

    public Game() {
        this.setBounds(0, 0, 1000, 600);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
        this.stage = 0;
    }

    public void reset_game() {
        dog.score = 0;
        this.LastPress = 0;
        this.dog.health = 5;
        this.stage = 0;
        remove(Backtomanu);
    }

    public void paint(Graphics g) {
        try {
            super.paint(g);
            Graphics2D k2 = (Graphics2D) g;
            k2.setColor(Color.BLUE);
            if (dog.score >= 50) {
                for (Wave wave : waveSet) {
                    wave.speed = 30;
                }
                this.stage = 0;
            }
            if (dog.score >= 100) {
                for (Wave wave : waveSet) {
                    wave.speed = 40;
                }
                this.stage = 1;
            }
            if (dog.score >= 150) {
                for (Wave wave : waveSet) {
                    wave.speed = 50;
                }
                this.stage = 0;
            }
            if (dog.score >= 200) {
                for (Wave wave : waveSet) {
                    wave.speed = 60;
                }
                this.stage = 0;
            }
            if (dog.health > 0) {
                try {
                    k2.drawImage(BT.bg[this.stage], 0, 0, 1000, 600, null, null);
                    k2.drawImage(ImageIO.read(new File("img\\dir.png")), 0, 450, 1000, 600, null, null);
                    if (dog.jmp) {
                        k2.drawImage(BT.p_dog[1], dog.x, dog.y, dog.dogSize, dog.dogSize, null, null);
                    } else {
                        k2.drawImage(BT.p_dog[0], dog.x, dog.y, dog.dogSize, dog.dogSize, null, null);
                    }
                } catch (Exception e) {
                }
                // Show HP && Score
                k2.setColor(Color.red);
                k2.setFont(new Font("", Font.BOLD, 20));
                k2.drawString("HP >>>>" + dog.health + "%", 10, 20);
                k2.setColor(Color.GREEN);
                k2.drawString("score :      " + dog.score, 800, 20);
                //---Wave---
                for (Wave wave : waveSet) {
                    //k2.drawRect(wave.x, wave.y, wave.width, wave.height);
                    k2.drawImage(ImageIO.read(new File("img\\funnel.png")), wave.x, wave.y, wave.width, 60, null, null);
                    if (event.checkHit(dog, wave) && !wave.hit) {
                        k2.setStroke(new BasicStroke(10.0f));
                        k2.setColor(Color.RED);
                        k2.drawRect(0, 0, 1000, 900);
                        dog.health -= 5;
                        wave.hit = true;
                        wave.reset_hit();
                    }
                }
                //---BoneItem1---
                for (BoneItem1 boneItem1 : BoneItem1Set) {
                    //k2.drawRect(boneItem1.x, boneItem1.y, boneItem1.width, boneItem1.height);
                    k2.drawImage(ImageIO.read(new File("img\\item1.png")), boneItem1.x, boneItem1.y, boneItem1.width, 60, null, null);
                    if (event.checkHit1(dog, boneItem1) && !boneItem1.hit) {
                        k2.setStroke(new BasicStroke(10.0f));
                        k2.setColor(Color.BLUE);
                        k2.drawRect(0, 0, 1000, 900);
                        dog.score += 5;
                        boneItem1.hit = true;
                        boneItem1.reset_hit();
                    }
                }
                //---BoneItem2---
                for (BoneItem2 boneItem2 : BoneItem2Set) {
                    //k2.drawRect(boneItem1.xd, boneItem1.y, boneItem1.width, boneItem1.height);
                    k2.drawImage(ImageIO.read(new File("img\\item2.png")), boneItem2.x, boneItem2.y, boneItem2.width, 60, null, null);
                    if (event.checkHit2(dog, boneItem2) && !boneItem2.hit) {
                        k2.setStroke(new BasicStroke(10.0f));
                        k2.setColor(Color.BLUE);
                        k2.drawRect(0, 0, 1000, 900);
                        dog.score += 10;
                        boneItem2.hit = true;
                        boneItem2.reset_hit();
                    }
                }
                this.score += 1;
            } else {
                setLayout(null);
                Backtomanu.setBounds(0, 490, 300, 80);
                k2.setColor(Color.BLACK);
                k2.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
                k2.drawImage(ImageIO.read(new File("img\\bover.png")), 0, 0, 1000, 600, null, null);
                k2.drawString(dog.get_score(), 300, 300);
                k2.drawImage(ImageIO.read(new File("img\\back.png")), 0, 490, 300, 80, null, null);
                add(Backtomanu);
            }
        } catch (Exception e) {
        }
    }

    private Wave[] makeWaveSet(int waveNumber) {
        Wave[] waveSet = new Wave[waveNumber];
        for (int i = 0; i < waveNumber; i++) {
            double waveLocation = 1000 + Math.floor(Math.random() * 1000);
            waveSet[i] = new Wave((int) waveLocation, 400, 40, 50, 20, this);
        }
        return waveSet;
    }

    private BoneItem1[] makeBone1Set(int boneitem1Number) {
        BoneItem1[] BoneItem1Set = new BoneItem1[boneitem1Number];
        for (int i = 0; i < boneitem1Number; i++) {
            double BoneItem1Location = 1000 + Math.floor(Math.random() * 1000);
            BoneItem1Set[i] = new BoneItem1((int) BoneItem1Location, 380, 45, 40, 30, this);
        }
        return BoneItem1Set;
    }

    private BoneItem2[] makeBone2Set(int boneitem2Number) {
        BoneItem2[] BoneItem2Set = new BoneItem2[boneitem2Number];
        for (int i = 0; i < boneitem2Number; i++) {
            double BoneItem2Location = 1000 + Math.floor(Math.random() * 1000);
            BoneItem2Set[i] = new BoneItem2((int) BoneItem2Location, 380, 45, 40, 30, this);
        }
        return BoneItem2Set;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (System.currentTimeMillis() - LastPress > 600) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE /*||e.getKeyCode()==32*/) {
                System.out.println("jump");
                dog.jump(this);
                this.repaint();
            }

            LastPress = System.currentTimeMillis();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
