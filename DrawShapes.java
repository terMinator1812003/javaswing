import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawShapes extends JFrame {
    private JPanel canvas;
    private JButton enableBtn, disableBtn;
    private boolean isEnabled = true;

    public DrawShapes() {
        super("Draw Shapes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel for drawing shapes
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (isEnabled) {
                    // Draw a circle
                    g.setColor(Color.RED);
                    g.fillOval(70, 70, 110, 110);

                    // Draw a waveform
                    g.setColor(Color.RED);
                    for (int x = 0; x < 100; x++) {
                        int y = (int) (50 + 25 * Math.sin(x / 10.0));
                        g.drawLine(x + 200, y + 70, x + 200, y + 70);
                    }
                } else {
                    // Draw a disabled message
                    g.setColor(Color.BLACK);
                    g.drawString("Drawing is disabled, Click Enable Drawing to view", 50, 100);
                }
            }
        };

        // Create buttons for enabling and disabling drawing
        enableBtn = new JButton("Enable Drawing");
        enableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isEnabled = true;
                canvas.repaint();
            }
        });

        disableBtn = new JButton("Disable Drawing");
        disableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isEnabled = false;
                canvas.repaint();
            }
        });

        // Add components to the JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(enableBtn);
        buttonPanel.add(disableBtn);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Set the size and make the JFrame visible
        setSize(500, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawShapes();
    }
}