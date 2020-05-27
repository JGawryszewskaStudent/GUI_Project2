import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;


public class GamePanel extends JPanel{

    static double gravity=0.9;
    static double powierzchnia=600;
    Minionki minion;
    Obrazki chmurka;
    Przeszkody kaktus;
    Omijanie omijanie;
    int wynik;
    int najlepszyWynik;
    BufferedImage textgameover;
    BufferedImage tlo;



    static final int gameFirstState=0;
   static final int gamePlay=1;
   static final int gameOver=2;
   static int gameState=gameFirstState;



public void czyDziala(){
    switch (GamePanel.gameState) {
        case GamePanel.gamePlay:
            break;
    }
}


    public GamePanel() throws IOException {
   tlo= ImageIO.read(new File("Obrazki/tlo10.jpg"));
   minion=new Minionki();
    minion.setX(400);
    minion.setY(60);
    textgameover=ImageIO.read(new File ("Obrazki/gameover.jpg"));
    chmurka= new Obrazki();
    kaktus= new Przeszkody(minion);
    omijanie =new Omijanie(minion,this);

}

public void start1(){
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tlo,0,0,null);

        switch (gameState){
            case gameFirstState:
                minion.draw(g);
                break;
            case gamePlay:
                chmurka.draw(g);
                minion.draw(g);
                omijanie.draw(g);
                g.setColor(Color.BLACK);
                g.drawString("Wynik : "+String.valueOf(wynik),1250,200);
                g.drawString("Nalepszy wynik : "+String.valueOf(najlepszyWynik),1250,250);
                break;
            case gameOver:
                chmurka.draw(g);
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
                chmurka.update();
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

