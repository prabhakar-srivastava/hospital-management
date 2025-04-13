package hospital;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
public class Patient_discharge extends JFrame{
    

    Patient_discharge(){
        setSize(800,350);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 0.5f));
        p1.setBounds(0, 0, 800, 600);
        add(p1);

        JLabel l1 = new JLabel("Patient Discharge");
        l1.setBounds(300, 20, 200, 30);
        l1.setForeground(Color.white);
        l1.setFont(new java.awt.Font("Arial", 0, 20));
        p1.add(l1);


        JLabel l2 = new JLabel("Patient ID:");
        l2.setBounds(100, 80, 200, 30);
        l2.setForeground(Color.white);
        l2.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(l2);

        Choice c1 = new Choice();
        c1.setBounds(300, 80, 200, 30);
        c1.setBackground(new Color(0, 0, 0, 0.5f));
        c1.setForeground(Color.white);
        c1.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(c1);

        try {
            ConnectionClass con = new ConnectionClass();
            String str = "select * from patient_info";
            ResultSet rs = con.st.executeQuery(str);
            while (rs.next()) {
                c1.add(rs.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       

        JLabel l3 = new JLabel("Room No:");
        l3.setBounds(100, 130, 200, 30);
        l3.setForeground(Color.white);
        l3.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(l3);

        
        JLabel Rn = new JLabel();
        Rn.setBounds(300, 130, 200, 30);
        Rn.setForeground(Color.white);
        Rn.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(Rn);

        JLabel l4 = new JLabel("IN Time: ");
        l4.setBounds(100, 180, 200, 30);
        l4.setForeground(Color.white);
        l4.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(l4);


        JLabel IN = new JLabel();
        IN.setBounds(300, 180, 200, 30);
        IN.setForeground(Color.white);
        IN.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(IN);

        IN.setText("2023-10-10 10:10:10");

        JLabel l5 = new JLabel("OUT Time: ");
        l5.setBounds(100, 230, 200, 30);
        l5.setForeground(Color.white);
        l5.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(l5);

        // Date d = new Date();
        Date d = new Date(System.currentTimeMillis());
        System.out.println(d);
        JLabel OUT = new JLabel(d.toString());
        OUT.setBounds(300, 230, 200, 30);
        OUT.setForeground(Color.white);
        OUT.setFont(new java.awt.Font("Arial", 0, 16));
        p1.add(OUT);

        JButton b2 = new JButton("Discharge Patient");
        b2.setBounds(100, 300, 200, 30);
        b2.setBackground(new Color(0, 0, 0, 0.5f));
        b2.setForeground(Color.white);
        b2.setFont(new java.awt.Font("Arial", 0, 16));
        b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        b2.setFocusable(false);
        b2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    ConnectionClass con = new ConnectionClass();
                    String str = "delete from patient_info where Number = '" + c1.getSelectedItem() + "'";
                    String str1 = "update Room set Availability= 'Available' where room_no = '" + Rn.getText() + "'";
                    con.st.executeUpdate(str);
                    con.st.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Patient Discharged Successfully");
                    setVisible(false);
                } catch (Exception error) {
                    error.printStackTrace();
                }
                
            }
        });
        p1.add(b2);

        JButton b = new JButton("Check");
        b.setBounds(350, 300, 100, 30);
        b.setBackground(new Color(0, 0, 0, 0.5f));
        b.setForeground(Color.white);
        b.setFont(new java.awt.Font("Arial", 0, 16));
        b.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        b.setFocusable(false);
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    ConnectionClass con = new ConnectionClass();
                    String str = "select * from patient_info where Number = '" + c1.getSelectedItem() + "'";
                    ResultSet rs = con.st.executeQuery(str);
                    while (rs.next()) {
                        Rn.setText(rs.getString("Room_Number"));
                        IN.setText(rs.getString("Time"));
                    }
                    
                } catch (Exception error) {
                    error.printStackTrace();
                    // TODO: handle exception
                }
               
            }
        });
        p1.add(b);



        JButton b1 = new JButton("Back");
        b1.setBounds(500, 300, 200, 30);
        b1.setBackground(new Color(0, 0, 0, 0.5f));
        b1.setForeground(Color.white);
        b1.setFont(new java.awt.Font("Arial", 0, 16));
        b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        b1.setFocusable(false);
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });
        p1.add(b1);

        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(rootPaneCheckingEnabled);

    }

    public static void main(String[] args) {
        new Patient_discharge();
    }

}
