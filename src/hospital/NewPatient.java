package hospital;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox id;
    JTextField f1, f2, f3, f4, f5;
    JRadioButton r1, r2;
    Choice c1,c2;
    JButton b1, b2;

    NewPatient() {
        setSize(800, 600);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 0.5f));
        p1.setBounds(0, 0, 800, 600);
        add(p1);

        JLabel l1 = new JLabel("New Patient Form");
        l1.setBounds(250, 20, 300, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setForeground(Color.white);
        p1.add(l1);

        JLabel l2 = new JLabel("ID : ");
        l2.setBounds(50, 80, 150, 30);
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        l2.setForeground(Color.white);
        p1.add(l2);

        id = new JComboBox<String>(new String[] { "Select ID", "Aadhar Card", "Voter ID", "Driving Linces", "PAN Card", "Passport" });
        id.setBounds(300, 80, 300, 30);
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setBackground(Color.white);
        p1.add(id);

        JLabel l3 = new JLabel("Number : ");
        l3.setBounds(50, 130, 150, 30);
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setForeground(Color.white);
        p1.add(l3);

        f1 = new JTextField();
        f1.setBounds(300, 130, 300, 30);
        f1.setFont(new Font("Arial", Font.PLAIN, 20));
        f1.setBackground(Color.white);
        p1.add(f1);

        JLabel l4 = new JLabel("Name : ");
        l4.setBounds(50, 180, 150, 30);
        l4.setFont(new Font("Arial", Font.PLAIN, 20));
        l4.setForeground(Color.white);
        p1.add(l4);

        f2 = new JTextField();
        f2.setBounds(300, 180, 300, 30);
        f2.setFont(new Font("Arial", Font.PLAIN, 20));
        f2.setBackground(Color.white);
        p1.add(f2);

        JLabel l5 = new JLabel("Gender : ");
        l5.setBounds(50, 230, 150, 30);
        l5.setFont(new Font("Arial", Font.PLAIN, 20));
        l5.setForeground(Color.white);
        p1.add(l5);

        r1 = new JRadioButton("Male");
        r1.setBounds(300, 230, 100, 30);
        r1.setFont(new Font("Arial", Font.PLAIN, 20));
        r1.setBackground(Color.white);
        r1.setForeground(Color.black);
        p1.add(r1);

        r2 = new JRadioButton("FEMALE");
        r2.setBounds(420, 230, 140, 30);
        r2.setFont(new Font("Arial", Font.PLAIN, 20));
        r2.setBackground(Color.white);
        r2.setForeground(Color.black);
        p1.add(r2);

        JLabel l6 = new JLabel("DISEASE : ");
        l6.setBounds(50, 330, 150, 30);
        l6.setFont(new Font("Arial", Font.PLAIN, 20));
        l6.setForeground(Color.white);
        p1.add(l6);

        String disease[] = { "Select Disease", "Fever", "Cold", "Cough", "Headache", "Stomach Pain", "Body Pain",
                "Other" };
        c1 = new Choice();
        for (int i = 0; i < disease.length; i++) {
            c1.add(disease[i]);
        }
        c1.setBounds(300, 330, 300, 30);
        c1.setFont(new Font("Arial", Font.PLAIN, 20));
        c1.setBackground(Color.white);
        p1.add(c1);

        // JLabel l7 = new JLabel("Age : ");
        // l7.setBounds(50, 280, 150, 30);
        // l7.setFont(new Font("Arial", Font.PLAIN, 20));
        // l7.setForeground(Color.white);
        // p1.add(l7);

        // f3 = new JTextField();
        // f3.setBounds(300, 280, 300, 30);
        // f3.setFont(new Font("Arial", Font.PLAIN, 20));
        // f3.setBackground(Color.white);
        // p1.add(f3);

        JLabel l8 = new JLabel("ROOM : ");
        l8.setBounds(50, 380, 150, 30);
        l8.setFont(new Font("Arial", Font.PLAIN, 20));
        l8.setForeground(Color.white);
        p1.add(l8);

        c2 = new Choice();
        try {
            ConnectionClass c = new ConnectionClass();
            ResultSet resultSet = c.st.executeQuery( "select * from Room");
            while (resultSet.next()) {
            c2.add(resultSet.getString( "room_no"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        c2.setBounds(300, 380, 300, 30);
        c2.setFont(new Font("Arial", Font.PLAIN, 20));
        c2.setBackground(Color.white);
        p1.add(c2);

        JLabel l9 = new JLabel("DATE : ");
        l9.setBounds(50, 430, 150, 30);
        l9.setFont(new Font("Arial", Font.PLAIN, 20));
        l9.setForeground(Color.white);
        p1.add(l9);

        Date d = new Date(System.currentTimeMillis());
        f4 = new JTextField(d.toString());
        f4.setBounds(300, 430, 300, 30);
        f4.setFont(new Font("Arial", Font.PLAIN, 20));
        f4.setBackground(Color.white);
        p1.add(f4);

        JLabel l10 = new JLabel("DEPOSITE : ");
        l10.setBounds(50, 480, 150, 30);
        l10.setFont(new Font("Arial", Font.PLAIN, 20));
        l10.setForeground(Color.white);
        p1.add(l10);

        f5 = new JTextField();
        f5.setBounds(300, 480, 300, 30);
        f5.setFont(new Font("Arial", Font.PLAIN, 20));
        f5.setBackground(Color.white);
        p1.add(f5);

        b1 = new JButton("Submit");
        b1.setBounds(50, 540, 150, 30);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(300, 540, 150, 30);
        b2.setFont(new Font("Arial", Font.PLAIN, 20));
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        p1.add(b2);

        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(rootPaneCheckingEnabled);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            ConnectionClass con = new ConnectionClass();
            String id1 = (String) id.getSelectedItem();
            String number = f1.getText();
            String name = f2.getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "MALE";
            } else {
                gender = "FEMALE";
            }
            String disease = c1.getSelectedItem();
            String room = c2.getSelectedItem();
            String date = f4.getText();
            String deposit = f5.getText();

            try {
                String query = "insert into patient_info values ('"+id1+"','"+number+"','"+name+"','"+gender+"','"+disease+"','"+room+"','"+date+"','"+deposit+"');";
                String query1 = "update room set Availability = 'Occupied' where room_no = '"+room+"';";
                con.st.executeUpdate(query);
                con.st.executeUpdate(query1);
                JOptionPane.showMessageDialog(this, "Patient Added Successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);

            } catch (Exception Error) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(this, "Error in Adding Patient", "Error",JOptionPane.ERROR_MESSAGE);
                Error.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            this.setVisible(false);
            int a = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit",
                    JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                this.dispose();
            } else {
                this.setVisible(true);
            }

        }
    }

    public static void main(String[] args) {
        new NewPatient();
    }

}
