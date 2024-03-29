import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel{

    static double gravity=0.9;
    static double powierzchnia=600;
    Minionki minion;
    Obrazki cloud;
    Przeszkody kaktus;
    Omijanie omijanie;
    int wynik,najlepszyWynik;
    BufferedImage textgameover,mainBackground;




    static final int gameFirstState=0;
    static final int gameOver=2;
    static final int gamePlay=1;
    static int gameState=gameFirstState;



// sprawdzic
public void czyDziala(){
    switch (GamePanel.gameState) {
        case GamePanel.gamePlay:
            break;
    }
}


    public GamePanel() throws IOException {
   mainBackground = ImageIO.read(new File("Obrazki/tlo10.jpg"));
   minion=new Minionki();
    minion.setX(400);
    minion.setY(60);
    textgameover=ImageIO.read(new File ("Obrazki/gameover.jpg"));
    cloud = new Obrazki();
    kaktus= new Przeszkody(minion);
    omijanie =new Omijanie(minion,this);

}

public void start1(){
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mainBackground,0,0,null);

        switch (gameState){
            case gameFirstState:
                minion.draw(g);
                break;
            case gamePlay:
                cloud.draw(g);
                minion.draw(g);
                omijanie.draw(g);
                g.setColor(Color.BLACK);
                g.drawString("Wynik : "+String.valueOf(wynik),1250,200);
                g.drawString("Nalepszy wynik : "+String.valueOf(najlepszyWynik),1250,250);
                break;
            case gameOver:
                cloud.draw(g);
                minion.draw(g);
                omijanie.draw(g);
                g.drawImage(textgameover,600,70,null);
                g.drawString("Nalepszy wynik : "+String.valueOf(najlepszyWynik),600,500);

        }
}


    public void update() {

        switch (GamePanel.gameState){
            case GamePanel.gamePlay:
                minion.update();
                cloud.update();
                kaktus.updateo();
                omijanie.update();
                if (omijanie.kolizja()){
                    gameState=gameOver;
                    if ( wynik>najlepszyWynik){
                        najlepszyWynik=wynik;
                    }
                }
                break;
        }
}

    public void resetGry() {
        minion.setAlive(true);
        minion.resetMinionka();
        omijanie.reset();
        wynik=0;
    }

    public void setWynik(int wynik){
    this.wynik+=wynik;
        }

    public  double getGravity() {
        return gravity;
    }

    public  void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public  void setPowierzchnia(double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }
    public double getPowierzchnia() {
        return powierzchnia;
    }

}

