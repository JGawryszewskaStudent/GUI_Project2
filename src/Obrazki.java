import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Obrazki {

    BufferedImage chmura;
    List<Obrazek> obrazki1=new ArrayList<Obrazek>();
    Obrazek chmura1=new Obrazek();
    Obrazek chmura2=new Obrazek();
    Obrazek chmura3= new Obrazek();


    public Obrazki() throws IOException {
        chmura=ImageIO.read(new File("Obrazki/dobra chmura.png"));
        obrazki1.add(chmura1);
        chmura1.pozX =100;
        chmura1.pozY =50;
        obrazki1.add(chmura2);
        chmura2.pozX =600;
        chmura2.pozY =40;
        obrazki1.add(chmura3);
        chmura3.pozX =1100;
        chmura3.pozY =30;

    }

    public void update (){

        for (Obrazek obrazek: obrazki1){
            obrazek.pozX =obrazek.pozX -0.1;
        }
        Obrazek chmureczka=obrazki1.get(0);
        if (chmureczka.pozX +chmura.getWidth()<0){
            chmureczka.pozX =1500;
            obrazki1.remove(chmureczka);
            obrazki1.add(chmureczka);
        }
    }
            public void draw (Graphics g){
            for (Obrazek obrazek: obrazki1) {
                g.drawImage(chmura, (int)obrazek.pozX, (int)obrazek.pozY, null);

            }
    }


}
class Obrazek{

    double pozX;
    double pozY;

}
