package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class removeemployee extends JFrame implements ActionListener {

    Choice cempId;
    JButton deleteButton, backButton;
    JLabel nameLabel, phoneLabel;

    removeemployee() {
        getContentPane().setBackground(new Color(255, 204, 204));
        setLayout(null);

        JLabel heading = new JLabel("Remove Employee");
        heading.setBounds(300, 30, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel empId = new JLabel("Select Employee ID");
        empId.setBounds(50, 100, 150, 30);
        empId.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(empId);

        cempId = new Choice();
        cempId.setBounds(250, 100, 200, 30);
        add(cempId);

        // Fill employee IDs from database
        try {
            com c = new com();
            ResultSet rs = c.stm.executeQuery("SELECT empId FROM employee");
            while (rs.next()) {
                cempId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Name
        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        add(name);

        nameLabel = new JLabel();
        nameLabel.setBounds(160, 150, 300, 30);
        nameLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        add(nameLabel);

        // Phone
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 200, 100, 30);
        phone.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        add(phone);

        phoneLabel = new JLabel();
        phoneLabel.setBounds(160, 200, 300, 30);
        phoneLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        add(phoneLabel);

        // Fetch and show employee info when ID changes
        cempId.addItemListener(e -> loadEmployeeInfo());

        // Load first selected
        loadEmployeeInfo();

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(250, 300, 120, 40);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(this);
        add(deleteButton);

        backButton = new JButton("Back");
        backButton.setBounds(400, 300, 120, 40);
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setSize(700, 450);
        setLocation(200, 100);
        setVisible(true);
    }

    void loadEmployeeInfo() {
        try {
            com c = new com();
            String query = "SELECT name, phone FROM employee WHERE empId = '" + cempId.getSelectedItem() + "'";
            ResultSet rs = c.stm.executeQuery(query);
            if (rs.next()) {
                nameLabel.setText(rs.getString("name"));
                phoneLabel.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteButton) {
            try {
                com c = new com();
                String query = "DELETE FROM employee WHERE empId = '" + cempId.getSelectedItem() + "'";
                c.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Removed Successfully");

                // Refresh UI
                setVisible(false);
                new main_class();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new main_class();
        }
    }

    public static void main(String[] args) {
        new removeemployee();
    }
}
