import java.awt.*;
import javax.swing.*;

public class Ball extends JApplet implements Runnable {
    private int x;             // x-coordinate of the ball
    private int y;             // y-coordinate of the ball
    private int radius = 50;   // radius of the ball
    private int dx = 5;        // change in x-coordinate
    private int dy = 5;        // change in y-coordinate

    public void init() {
        x = getWidth() / 2;    // initialize x-coordinate at the center of the applet
        y = getHeight() / 2;   // initialize y-coordinate at the center of the applet
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            // Update the ball coordinates
            x += dx;
            y += dy;

            // Check for collision with applet boundaries
            if (x + radius >= getWidth() || x - radius <= 0) {
                dx = -dx;  // reverse the direction
            }
            if (y + radius >= getHeight() || y - radius <= 0) {
                dy = -dy;  // reverse the direction
            }

            // Repaint the applet
            repaint();

            try {
                Thread.sleep(20);  // delay for smoother animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}
