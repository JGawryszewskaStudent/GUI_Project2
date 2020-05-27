import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Omijanie {

    List<OmijanePrzedmioty> omijanie;
    Random random = new Random();
    BufferedImage kaktus1, kaktus2, skala;
    GamePanel gamePanel;
    Minionki minionki;

    public Omijanie(Minionki minionki, GamePanel gamePanel) throws IOException {
        this.minionki = minionki;
        this.gamePanel = gamePanel;
        omijanie = new ArrayList<>();
        kaktus1 = ImageIO.read(new File("Obrazki/cactus10.png"));
        kaktus2 = ImageIO.read(new File("Obrazki/cactus10.png"));
        skala = ImageIO.read(new File("Obrazki/rock10.png"));
        omijanie.add(losowePrzeszkody());

    }


    public void update() {
        for (OmijanePrzedmioty o : omijanie) {
            o.updateo();
            if (o.koniecGry() && !o.toWynik()) {
                gamePanel.setWynik(20);
                o.settowynik(true);
            }
        }
        OmijanePrzedmioty first = omijanie.get(0);
        if (first.isOutofScreen()) {

            omijanie.remove(first);
            omijanie.add(losowePrzeszkody());
        }
    }

    public boolean kolizja() {
        for (OmijanePrzedmioty o : omijanie) {
            if (minionki.getRect().intersects(o.getRect())) {
                minionki.setAlive(false);
                return true;
            }
        }
        return false;
    }


    public void draw(Graphics g) {

        for (OmijanePrzedmioty p : omijanie) {
            p.draw(g);
        }
    }

    public Przeszkody losowePrzeszkody() {

        Przeszkody p = new Przeszkody(minionki);
        p.setDystans(1500);

        if (random.nextBoolean()) {
            p.setPrzeszkoda(kaktus1);
        } else {
            p.setPrzeszkoda(skala);
            p.setWys(550);

        }
        return p;
    }

    public void reset() {
        omijanie.clear();
        omijanie.add(losowePrzeszkody());
    }


}
