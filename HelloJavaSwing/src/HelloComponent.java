import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;

public class HelloComponent extends JComponent
    implements MouseMotionListener {

    String message;
    int mx = 125;
    int my = 95;

    public HelloComponent(String message) {
        this.message = message;
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        g.drawString(message, mx, my);
    }

    public void mouseDragged(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e) {}
}
