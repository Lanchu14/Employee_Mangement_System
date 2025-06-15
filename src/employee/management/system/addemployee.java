package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class addemployee extends JFrame {

    Random ran = new Random();
    int numbers = ran.nextInt(999999);

    JLabel tempId;
    JTextField tname, tfname, taddress, tphone, taadher, temil, tsalary, tdesignation;
    JDateChooser tdob;
    JComboBox<String> educationBox;
    JButton addButton, backButton;

    addemployee() {
        getContentPane().setBackground(new Color(163, 255, 188));
        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(300, 30, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("NAME");
        name.setBounds(50, 70, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 70, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("FATHER NAME");
        fname.setBounds(400, 70, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 70, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("DOB");
        dob.setBounds(50, 120, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 120, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(400, 120, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 120, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel address = new JLabel("ADDRESS");
        address.setBounds(50, 170, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 170, 550, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(50, 220, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(200, 220, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel aadher = new JLabel("AADHAAR");
        aadher.setBounds(400, 220, 150, 30);
        aadher.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadher);

        taadher = new JTextField();
        taadher.setBounds(600, 220, 150, 30);
        taadher.setBackground(new Color(177, 252, 197));
        add(taadher);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(50, 270, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temil = new JTextField();
        temil.setBounds(200, 270, 150, 30);
        temil.setBackground(new Color(177, 252, 197));
        add(temil);

        JLabel education = new JLabel("HIGHEST EDUCATION");
        education.setBounds(400, 270, 200, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(education);

        String[] degrees = {"Select", "High School", "Diploma", "B.E/B.Tech", "M.E/M.Tech", "B.Sc", "M.Sc", "MBA", "PhD"};
        educationBox = new JComboBox<>(degrees);
        educationBox.setBounds(600, 270, 150, 30);
        educationBox.setBackground(new Color(177, 252, 197));
        add(educationBox);

        JLabel empId = new JLabel("EMPLOYEE ID");
        empId.setBounds(50, 320, 150, 30);
        empId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empId);

        tempId = new JLabel("EMP" + numbers);
        tempId.setBounds(200, 320, 150, 30);
        tempId.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        tempId.setOpaque(true);
        tempId.setBackground(new Color(177, 252, 197));
        add(tempId);

        JLabel designation = new JLabel("DESIGNATION");
        designation.setBounds(400, 320, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(600, 320, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        addButton = new JButton("Add Details");
        addButton.setBounds(250, 380, 150, 40);
        add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(450, 380, 150, 40);
        add(backButton);

        // Add Button Action
        addButton.addActionListener(e -> {
            String dname = tname.getText();
            String dfname = tfname.getText();
            String ddob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String dsalary = tsalary.getText();
            String daddress = taddress.getText();
            String dphone = tphone.getText();
            String daadhaar = taadher.getText();
            String demail = temil.getText();
            String deducation = (String) educationBox.getSelectedItem();
            String dempIdStr = tempId.getText();
            String ddesignation = tdesignation.getText();

            try {
                com c = new com();
                String query = "INSERT INTO employee VALUES('" + dempIdStr + "', '" + dname + "', '" + dfname + "', '" + ddob + "', '" + dsalary + "', '" + daddress + "', '" + dphone + "', '" + daadhaar + "', '" + demail + "', '" + deducation + "', '" + ddesignation + "')";
                c.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully!");
                setVisible(false);
                new main_class();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        // Back Button Action
        backButton.addActionListener(e -> {
            setVisible(false);
            new main_class();
        });


        setSize(900, 500);
        setLocation(150, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new addemployee();
    }
}
