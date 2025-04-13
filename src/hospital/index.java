package hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class index extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton button1, button4;
    private JLabel label1;

    public index() {
        frame = new JFrame("Hospital Management System");
        frame.setSize(800, 600);
        frame.setLayout(null);

        label1 = new JLabel();
        label1.setLayout(null);
        label1.setBounds(0, 0, 800, 600);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("hospital/images/landingImg.png"));
        Image img = icon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        label1.setIcon(icon);
        frame.add(label1);

        button1 = new JButton("Receptionist");
        button1.setBounds(220, 470, 150, 30);
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBackground(Color.black);
        button1.setForeground(Color.white);
        button1.setFocusable(false);
        button1.addActionListener(this);
        label1.add(button1);

        button4 = new JButton("Admin");
        button4.setBounds(50, 470, 150, 30);
        button4.setFont(new Font("Arial", Font.BOLD, 14));
        button4.setBackground(Color.black);
        button4.setForeground(Color.white);
        button4.setFocusable(false);
        button4.addActionListener(this);
        label1.add(button4);

        frame.setResizable(false);
        frame.setVisible(rootPaneCheckingEnabled);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            new Login();
            frame.setVisible(false);
        } else if (e.getSource() == button4) {
            new Login();
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            index frame = new index();
            frame.setVisible(true);
        });

    }

}
