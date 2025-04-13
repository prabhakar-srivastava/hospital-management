package hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;



public class AdminHomePage extends JFrame {
    private JLabel label1;
    private JPanel panel1, panel2;
    private JButton addDoctorButton, addPatientButton, room,  viewDoctorsButton, logoutButton, patientInfo, patientDischarge, viewRoomButton, updatePatientButton, seachRoom;
    AdminHomePage() {   
        setTitle("Admin Home Page");
        setSize(1500, 1000);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 1500, 40);
        panel1.setBackground(new Color(0, 0, 0, 0.3f));
        add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 40, 1500, 900);
        panel2.setBackground(new Color(0, 0, 0, 0));
        add(panel2);

        addPatientButton = new JButton("Add Patient");
        addPatientButton.setBounds(10, 10, 100, 20);
        addPatientButton.setFont(new Font("Arial", Font.BOLD, 12));
        addPatientButton.setBackground(Color.black);
        addPatientButton.setForeground(Color.white);
        addPatientButton.setFocusable(false);
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }
        });
        panel1.add(addPatientButton);

        addDoctorButton = new JButton("Departments");
        addDoctorButton.setBounds(122, 10, 100, 20);
        addDoctorButton.setFont(new Font("Arial", Font.BOLD, 12));
        addDoctorButton.setBackground(Color.black);
        addDoctorButton.setForeground(Color.white);
        addDoctorButton.setFocusable(false);
        addDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Departments();
            }
        });
        panel1.add(addDoctorButton);

        room = new JButton("Room");
        room.setBounds(234, 10, 100, 20);
        room.setFont(new Font("Arial", Font.BOLD, 12));
        room.setBackground(Color.black);
        room.setForeground(Color.white);
        room.setFocusable(false);
        room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Room();
            }
        });
        panel1.add(room);

        viewDoctorsButton = new JButton("View Docs");
        viewDoctorsButton.setBounds(346, 10, 100, 20);
        viewDoctorsButton.setFont(new Font("Arial", Font.BOLD, 12));
        viewDoctorsButton.setBackground(Color.black);
        viewDoctorsButton.setForeground(Color.white);
        viewDoctorsButton.setFocusable(false);
        viewDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });
        panel1.add(viewDoctorsButton);

        patientInfo = new JButton("Patient Info");
        patientInfo.setBounds(458, 10, 100, 20);
        patientInfo.setFont(new Font("Arial", Font.BOLD, 12));
        patientInfo.setBackground(Color.black);
        patientInfo.setForeground(Color.white);
        patientInfo.setFocusable(false);
        patientInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_info();
            }
        });
        panel1.add(patientInfo);

        patientDischarge = new JButton("Patient Discharge");
        patientDischarge.setBounds(570, 10, 150, 20);
        patientDischarge.setFont(new Font("Arial", Font.BOLD, 12));
        patientDischarge.setBackground(Color.black);
        patientDischarge.setForeground(Color.white);
        patientDischarge.setFocusable(false);
        patientDischarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_discharge();
            }
        });
        panel1.add(patientDischarge);

        updatePatientButton = new JButton("Update Patient");
        updatePatientButton.setBounds(742, 10, 140, 20);
        updatePatientButton.setFont(new Font("Arial", Font.BOLD, 12));
        updatePatientButton.setBackground(Color.black);
        updatePatientButton.setForeground(Color.white);
        updatePatientButton.setFocusable(false);
        updatePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_patient();
            }
        });
        panel1.add(updatePatientButton);

        

        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1400, 10, 80, 20);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 12));
        logoutButton.setBackground(Color.black);
        logoutButton.setForeground(Color.white);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                setVisible(false);
            }
        });
        panel1.add(logoutButton);

        label1 = new JLabel();
        label1.setLayout(null);
        label1.setBounds(0, 0, 1500, 1000);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("hospital/images/homepage.png"));
        Image img = icon.getImage().getScaledInstance(1500, 1000, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        label1.setIcon(icon);
        add(label1);



        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(rootPaneCheckingEnabled);
    }
   
    public static void main(String[] args) {

        new AdminHomePage();
        // Add your admin functionalities here
    }
}
