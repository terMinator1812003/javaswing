
// Message Dialog Box in Java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JOptionPaneDemo {
    static JTextField jf1;

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(250, 250);
        FlowLayout ob = new FlowLayout();
        jf.setLayout(ob);
        JLabel j1 = new JLabel("Enter Name");
        jf1 = new JTextField(10);
        JButton jb = new JButton("Submit");
        MyListener1 ob1 = new MyListener1();
        jb.addActionListener(ob1);
        jf.add(j1);
        jf.add(jf1);
        jf.add(jb);
        jf.setVisible(true);
    }
}

class MyListener1 implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        String name = JOptionPaneDemo.jf1.getText();
        JOptionPane.showMessageDialog(null, "Welcome," + name);
    }
}