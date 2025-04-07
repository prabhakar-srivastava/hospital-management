package hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class index extends JFrame implements ActionListener {
    private JButton loginButton, registerButton;
    private JLabel titleLabel, welcomeLabel;
    private JPanel panel;

    public index() {
        // Set up the frame
        // super("Hospital Management System");
        setLayout(new BorderLayout());
        setResizable(false);
        setTitle("Hospital Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setBackground(Color.LIGHT_GRAY);

        titleLabel = new JLabel("Welcome to the Hospital Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.BLUE);

        welcomeLabel = new JLabel("Please choose an option:", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        panel.add(titleLabel);
        panel.add(welcomeLabel);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Open login window
            // new LoginWindow().setVisible(true);
            this.dispose();
        } else if (e.getSource() == registerButton) {
            // Open registration window
            // new RegisterWindow().setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            index frame = new index();
            frame.setVisible(true);
        });
        
    }

}
