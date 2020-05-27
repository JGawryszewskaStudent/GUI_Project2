import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        MyGame myGame = new MyGame();
        myGame.start();

        PrintWriter najlepszyWynik = new PrintWriter("Najlepszy wynik");
        najlepszyWynik.println("Najlepszy wynik gracza to " + myGame.gamePanel.najlepszyWynik);
        najlepszyWynik.close();

        File file = new File("Minionki - Banana Song2.wav");
        graj(file);


    }

    public static void graj(File file) {

        try {
            Clip najnowszyklip = AudioSystem.getClip();
            najnowszyklip.open(AudioSystem.getAudioInputStream(file));
            najnowszyklip.start();
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("cos nie dziala ");
        }


    }
}
