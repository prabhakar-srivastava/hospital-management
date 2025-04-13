package hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel label1,label2, label3, messageLabel;

    public Login() {
        frame = new JFrame("Login");
        frame.setSize(500, 500);
        frame.setLayout(null);

        label1 = new JLabel();
        label1.setLayout(null);
        label1.setBounds(0, 0, 800, 600);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("hospital/images/login.png"));
        Image img = icon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        label1.setIcon(icon);
        frame.add(label1);

        messageLabel = new JLabel("Login to your account");
        messageLabel.setBounds(100, 50, 300, 30);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 25));
        messageLabel.setForeground(Color.WHITE);
        label1.add(messageLabel);

        label2 = new JLabel("username");
        label2.setBounds(50, 200, 300, 30);
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        label2.setForeground(Color.black);
        label1.add(label2);

        label3 = new JLabel("password");
        label3.setBounds(50, 270, 300, 30);
        label3.setFont(new Font("Arial", Font.BOLD, 14));
        label3.setForeground(Color.black);
        label1.add(label3);

        usernameField = new JTextField(15);
        usernameField.setBounds(50, 230, 300, 30); 
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField.setBackground(Color.white);
        usernameField.setForeground(Color.black);
        label1.add(usernameField);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(50, 300, 300, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBackground(Color.white);
        passwordField.setForeground(Color.black);
        label1.add(passwordField);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 370, 130, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(Color.white);
        loginButton.setForeground(Color.black);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        label1.add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220, 370, 130, 30);  
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBackground(Color.white);
        cancelButton.setForeground(Color.black);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        label1.add(cancelButton);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setResizable(false);
        frame.setVisible(rootPaneCheckingEnabled);
    }
     @Override  
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                ConnectionClass con = new ConnectionClass();
                String query = "SELECT * FROM admin WHERE username = '"+username+"' AND password = '"+password+"'";
                ResultSet rs = con.st.executeQuery(query);
                if (rs.next()) {
                    messageLabel.setText("Login successful!");
                    new AdminHomePage();
                    frame.setVisible(false);
                    // Proceed to the next screen or functionality
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                   
                }
                
            } catch (Exception err) {
                // TODO: handle exception
                err.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            new index();
            frame.setVisible(false);
        }
    }
}
