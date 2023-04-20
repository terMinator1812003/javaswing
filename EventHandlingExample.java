import java.awt.*;
import java.awt.event.*;

public class EventHandlingExample extends Frame implements ActionListener, MouseListener, MouseMotionListener {
    private Label statusLabel;
    private TextField textField;

    public EventHandlingExample() {
        super("Event Handling Example");

        // Create a Label and a TextField
        statusLabel = new Label("No event yet");
        textField = new TextField("Enter text here");

        // Add the components to the Frame
        add(statusLabel, BorderLayout.NORTH);
        add(textField, BorderLayout.SOUTH);

        // Register the listeners
        textField.addActionListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        // Set the size of the Frame and make it visible
        setSize(300, 200);
        setVisible(true);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        statusLabel.setText("You entered: " + text);
    }

    // MouseListener implementation
    public void mouseClicked(MouseEvent e) {
        statusLabel.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    // MouseMotionListener implementation
    public void mouseDragged(MouseEvent e) {
        statusLabel.setText("Mouse dragged at (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseMoved(MouseEvent e) {
        statusLabel.setText("Mouse moved at (" + e.getX() + ", " + e.getY() + ")");
    }

    public static void main(String[] args) {
        new EventHandlingExample();
    }
}
