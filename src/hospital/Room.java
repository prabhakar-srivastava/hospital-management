package hospital;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Room extends JFrame {

    Room() {

        setSize(800, 600);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 0.5f));
        p1.setBounds(0, 0, 800, 600);
        add(p1);

        JLabel  l1 = new JLabel("Room Details");
        l1.setBounds(300, 10, 200, 30);
        l1.setForeground(Color.white);
        l1.setFont(new java.awt.Font("Arial", 0, 24));
        p1.add(l1);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Room No");
        model.addColumn("Availability");
        model.addColumn("Room Price");
        model.addColumn("Room Type");

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
        sp.setBounds(80, 100, 600, 400);
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
            String query = "select * from Room";
            ResultSet rs = con.st.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[] { rs.getString("room_no"), rs.getString("Availability"),rs.getString("Price"), rs.getString("Room_Type") });
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
        new Room();
    }
}
