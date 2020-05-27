import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Minionki {

   int x=100;
   int y =100;
   double predkoscPionowa =1;
   BufferedImage minionki = null;
   Rectangle rect=new Rectangle();
   boolean isAlive=true;
   int czasWPowietrzu;
   boolean czyJestemPowietrzu = false;

   public Minionki()  {
       try {
           minionki=ImageIO.read(new File("Obrazki/Ostateczne_Minionki.png"));
           czasWPowietrzu = 0;
           czyJestemPowietrzu = false;
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

public void update(){

    if(czyJestemPowietrzu)
    {
        czasWPowietrzu++;
        if(czasWPowietrzu > 180)
        {
            spadnij();
        }
    }
    rect.x=x;
    rect.y=y;
    rect.width=minionki.getWidth()-50;
    rect.height=minionki.getHeight();
}

public void draw (Graphics g) {

    g.drawImage(minionki,(int)x-50,(int)y-50,null);
}
public Rectangle getRect(){
       return rect;
}

public  void skocz(){

       y = 300;
       czyJestemPowietrzu = true;
       czasWPowietrzu=0;
}

public void spadnij()
{
    y = 500;
    czyJestemPowietrzu = false;
}

public void resetMinionka()
{
    czyJestemPowietrzu = false;
    czasWPowietrzu = 0;
    y = 100;
}


    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }



    public double getPredkoscPionowa() {
        return predkoscPionowa;
    }

    public void setPredkoscPionowa(double predkoscPionowa) {
        this.predkoscPionowa = predkoscPionowa;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
