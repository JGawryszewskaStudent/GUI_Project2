import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class MyGame extends JFrame {

    GamePanel gamePanel;


    public MyGame() throws IOException {
        super("Minions game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.setSize(1500,768);
        this.setVisible(true);


        (new Timer(0, (ActionEvent a) -> {
            gamePanel.update();
            this.gamePanel.repaint();
        })).start();

    }
    public void start(){

        gamePanel.start1();

    }

    private void initComponents() throws IOException {

        this.addKeyListener(new KeyListener() {


                                @Override
                                public void keyTyped(KeyEvent e) {

                                }

                                @Override
                                public void keyPressed(KeyEvent e) {

                                }

                                @Override
                                public void keyReleased(KeyEvent keyEvent) {
                                    switch (keyEvent.getKeyCode()){
                                        case KeyEvent.VK_SPACE:
                                            if(GamePanel.gameState==GamePanel.gameFirstState){
                                                GamePanel.gameState=GamePanel.gamePlay;
                                                gamePanel.minion.spadnij();
                                            }
                                            else if (GamePanel.gameState==GamePanel.gamePlay){
                                                gamePanel.minion.skocz();


                                            }
                                            else if (GamePanel.gameState==GamePanel.gameOver){
                                                gamePanel.resetGry();
                                                GamePanel.gameState=GamePanel.gameFirstState;
                                                PrintWriter najlepszyWynik = null;
                                                try {
                                                    najlepszyWynik = new PrintWriter("Najlepszy wynik");
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                }
                                                najlepszyWynik.println("Najlepszy wynik gracza to "+gamePanel.najlepszyWynik );
                                                najlepszyWynik.close();

                                            }
                                            break;
                                    }

                                }

                            });
            gamePanel = new GamePanel();
        this.add(gamePanel, BorderLayout.CENTER);
    }




}
