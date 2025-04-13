package hospital;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
public class Update_patient extends JFrame{

    Update_patient(){
        setSize(800, 400);
        setTitle("Update Patient Details");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 800, 600);
        add(panel);


        JLabel label = new JLabel("Update Patient Details");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(250, 20, 300, 30);
        panel.add(label);

        JLabel idLabel = new JLabel("Name:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idLabel.setBounds(50, 80, 100, 30);
        panel.add(idLabel);

        Choice idChoice = new Choice();
        idChoice.setBounds(150, 80, 200, 30);
        panel.add(idChoice);

        try {
            ConnectionClass c = new ConnectionClass();
            String query = "SELECT Name FROM patient_info";
            ResultSet rs = c.st.executeQuery(query);
            while (rs.next()) {
                idChoice.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel nameLabel = new JLabel("Room No:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setBounds(50, 130, 100, 30);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 130, 200, 30);
        panel.add(nameField);

        JLabel IN = new JLabel("IN Time:");
        IN.setFont(new Font("Arial", Font.PLAIN, 16));
        IN.setBounds(50, 180, 100, 30);
        panel.add(IN);
        JTextField INField = new JTextField();
        INField.setBounds(150, 180, 200, 30);
        panel.add(INField);

        JLabel paid = new JLabel("Paid:");
        paid.setFont(new Font("Arial", Font.PLAIN, 16));
        paid.setBounds(50, 230, 100, 30);
        panel.add(paid);

        JTextField paidField = new JTextField();
        paidField.setBounds(150, 230, 200, 30);
        panel.add(paidField);

        JLabel updateButton = new JLabel("Remaining:");
        updateButton.setFont(new Font("Arial", Font.PLAIN, 16));
        updateButton.setBounds(50, 280, 150, 30);
        panel.add(updateButton);

        JTextField updateField = new JTextField();
        updateField.setBounds(150, 280, 200, 30);
        panel.add(updateField);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(150, 330, 100, 30);
        updateBtn.setBackground(Color.LIGHT_GRAY);
        updateBtn.setForeground(Color.black);
        updateBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        updateBtn.setFocusable(false);
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                String name = idChoice.getSelectedItem();
                String roomNo = nameField.getText();
                String inTime = INField.getText();
                String paidAmount = paidField.getText();
                String remaining = updateField.getText();

                try {
                    ConnectionClass c = new ConnectionClass();
                    String query = "UPDATE patient_info SET Room_Number='" + roomNo + "', Time='" + inTime + "', Deposite='" + (paidAmount+ remaining) + "' WHERE Name='" + name + "'";
                    c.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(updateBtn);

        JButton checkBtn = new JButton("Check");
        checkBtn.setBounds(300, 330, 100, 30);
        checkBtn.setBackground(Color.LIGHT_GRAY);
        checkBtn.setForeground(Color.black);
        checkBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        checkBtn.setFocusable(false);
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                String name = idChoice.getSelectedItem();
                try {
                    ConnectionClass c = new ConnectionClass();
                    String query = "SELECT * FROM patient_info WHERE Name = '" + name + "'";
                    ResultSet rs = c.st.executeQuery(query);
                    if (rs.next()) {
                        nameField.setText(rs.getString("Room_Number"));
                        INField.setText(rs.getString("Time"));
                        paidField.setText(rs.getString("Deposite"));
                    }

                    ResultSet rs1 = c.st.executeQuery("SELECT * FROM Room WHERE room_no = '" + nameField.getText() + "'");
                    while (rs1.next()) {
                        String price = rs1.getString("Price");
                        int paid =Integer.parseInt(price)-Integer.parseInt(paidField.getText()) ;

                        updateField.setText(""+paid);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        panel.add(checkBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(450, 330, 100, 30);
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.setForeground(Color.black);
        backBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        backBtn.setFocusable(false);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        panel.add(backBtn);




        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);    
        setVisible(rootPaneCheckingEnabled);
    }

    public static void main(String[] args) {
        new Update_patient();
    }
}
