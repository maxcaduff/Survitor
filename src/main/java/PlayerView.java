import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;

public class PlayerView {
    private int dx;
    private int dy;
    private int x = 100;
    private int y = 40;
    private int w;
    private int h;
    private Image image;
    private GamePanel gp;
    private int pointsDeVie = 100;

    public PlayerView(GamePanel gp) {
        this.gp = gp;
        loadImage();
    }

    private void loadImage() {

        final URL url = Thread.currentThread().getContextClassLoader().getResource("wizard.png");
        Image i =  Toolkit.getDefaultToolkit().getImage(url);

        ImageIcon ii = new ImageIcon(i);
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {

        if(x + dx > 0 && x + dx < gp.getWidth() - w) {
            x += dx;
        }

        if(y + dy > 0 && y + dy < gp.getHeight() - h) {
            y += dy;
        }
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }

    public Image getImage() {

        return image;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int vie) {
        pointsDeVie = vie;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
