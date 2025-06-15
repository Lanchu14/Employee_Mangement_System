package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class viewemployee extends JFrame {

    JTextField tempId;
    JTextArea resultArea;
    JButton searchButton, backButton;

    viewemployee() {
        setTitle("View Employee");
        setSize(600, 400);
        setLocation(250, 150);
        setLayout(null);
        getContentPane().setBackground(new Color(204, 255, 229));

        JLabel heading = new JLabel("View Employee Details");
        heading.setBounds(180, 20, 300, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 22));
        add(heading);

        JLabel empLabel = new JLabel("Enter Employee ID:");
        empLabel.setBounds(50, 80, 200, 30);
        empLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(empLabel);

        tempId = new JTextField();
        tempId.setBounds(220, 80, 200, 30);
        add(tempId);

        searchButton = new JButton("Search");
        searchButton.setBounds(440, 80, 100, 30);
        add(searchButton);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 130, 480, 170);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        resultArea.setBackground(Color.white);
        add(resultArea);

        backButton = new JButton("Back");
        backButton.setBounds(240, 320, 100, 30);
        add(backButton);

        // Search Action
        searchButton.addActionListener(e -> {
            String empId = tempId.getText();
            try {
                com c = new com();
                String query = "SELECT * FROM employee WHERE empid = '" + empId + "'";
                ResultSet rs = c.stm.executeQuery(query);

                if (rs.next()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Employee ID   : ").append(rs.getString("empid")).append("\n");
                    sb.append("Name          : ").append(rs.getString("name")).append("\n");
                    sb.append("Father Name   : ").append(rs.getString("fname")).append("\n");
                    sb.append("DOB           : ").append(rs.getString("dob")).append("\n");
                    sb.append("Salary        : ").append(rs.getString("salary")).append("\n");
                    sb.append("Address       : ").append(rs.getString("address")).append("\n");
                    sb.append("Phone         : ").append(rs.getString("phone")).append("\n");
                    sb.append("Aadhaar       : ").append(rs.getString("aadhaar")).append("\n");
                    sb.append("Email         : ").append(rs.getString("email")).append("\n");
                    sb.append("Education     : ").append(rs.getString("education")).append("\n");
                    sb.append("Designation   : ").append(rs.getString("designation")).append("\n");
                    resultArea.setText(sb.toString());
                } else {
                    resultArea.setText("No employee found with ID: " + empId);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                resultArea.setText("Error retrieving data.");
            }
        });

        // Back Action
        backButton.addActionListener(e -> {
            setVisible(false);
            new main_class();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new viewemployee();
    }
}

