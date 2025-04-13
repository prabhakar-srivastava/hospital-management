package hospital;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
public class Patient_info extends JFrame{

    Patient_info(){
        setSize(800, 600);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 0.5f));
        p1.setBounds(0, 0, 800, 600);
        add(p1);

        JLabel  l1 = new JLabel("PATIENT INFO");
        l1.setBounds(300, 10, 200, 30);
        l1.setForeground(Color.white);
        l1.setFont(new java.awt.Font("Arial", 0, 24));
        p1.add(l1);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Number");;
        model.addColumn("Name");;
        model.addColumn("Gender");;
        model.addColumn("Disease");;
        model.addColumn("Room_NO");;
        model.addColumn("Time");;
        model.addColumn("Deposite");;

        JTable table = new JTable(model);
        table.setBackground(Color.white);
        table.setForeground(new Color(0, 0, 0, 0.5f));
        table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        table.setFont(new java.awt.Font("Arial", 0, 16));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(0, 0, 0));
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(40, 100, 700, 400);
        p1.add(sp);

        JButton b1 = new JButton("Back");
        b1.setBounds(300, 520, 200, 30);
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

        try {

            ConnectionClass con = new ConnectionClass();
            String query = "select * from patient_info";
            ResultSet rs = con.st.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[] { rs.getString("ID"), rs.getString("Number"), rs.getString("Name"), rs.getString("Gender"), rs.getString("Patient_Disease"), rs.getString("Room_Number"), rs.getString("Time"), rs.getString("Deposite") });
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(rootPaneCheckingEnabled);

    }

    public static void main(String[] args) {
        new Patient_info();
    }
}
