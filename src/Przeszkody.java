import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Przeszkody extends OmijanePrzedmioty{

    BufferedImage kaktus;
    int dystans;
    int wys;
    Rectangle rect;
    Minionki minionki;
    boolean toWynik=false;


    public Przeszkody( Minionki minionki) {
        this.minionki = minionki;
        dystans = 600;
        wys = 500;
        rect = new Rectangle();
        try {
            kaktus = ImageIO.read(new File("Obrazki/cactus10.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

   @Override
   public void draw(Graphics g) {
        g.drawImage(kaktus, dystans, wys, null);
    }

    @Override
    public void updateo() {
        dystans -= 1.3;
        rect.x = dystans;
        rect.y = wys;
        rect.width = kaktus.getWidth();
        rect.height = kaktus.getHeight();
    }

    @Override
    public boolean isOutofScreen() {
      return ( dystans +kaktus.getWidth()<0);


    }

    @Override
    public boolean koniecGry() {
return  (minionki.getX()> dystans);

    }

    @Override
    public boolean toWynik() {
        return toWynik;
    }

    @Override
    public void settowynik(boolean toWynik) {
        this.toWynik=toWynik;

    }

    public void setDystans(int x) {
        this.dystans = x;
    }
    public void setWys(int y) {
        this.wys =y;
    }

    public void setPrzeszkoda(BufferedImage kaktus){
this.kaktus=kaktus;

    }


}
