import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc extends JFrame implements ActionListener {
    JButton[] bb = new JButton[10];
    JButton plus, eq;
    JTextField t1;
    String op = "";
    String ope = "";
    int x = 0;

    public Calc() {
        t1 = new JTextField(10);
        add(t1, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));
        for (int i = 0; i < 10; i++) {
            bb[i] = new JButton("" + i);
            panel.add(bb[i]);
            bb[i].addActionListener(this);
        }
        plus = new JButton("+");
        eq = new JButton("=");
        panel.add(plus);
        panel.add(eq);
        add(panel, BorderLayout.CENTER);
        plus.addActionListener(this);
        eq.addActionListener(this);

        setSize(300, 400);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == bb[i]) {
                op = op + bb[i].getText();
                t1.setText(op);
            }
        }

        if (e.getSource() == plus) {
            ope = plus.getText();
            x = Integer.parseInt(t1.getText());
            op = "";
            t1.setText("");
        }

        if (e.getSource() == eq) {
            if (ope.equals("+")) {
                x = x + Integer.parseInt(t1.getText());
                op = Integer.toString(x);
                t1.setText(op);
            }
        }
    }

    public static void main(String[] args) {
        new Calc();
    }
}
