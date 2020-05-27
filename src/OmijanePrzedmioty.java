import java.awt.*;

public abstract class OmijanePrzedmioty {
    public abstract Rectangle getRect();
    public abstract void draw(Graphics g);
    public abstract void updateo();
    public abstract boolean isOutofScreen();
    public abstract boolean koniecGry();
    public abstract boolean toWynik();
    public abstract void settowynik(boolean toWynik);
}
