package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField tusername;
    JTextField tpassword;
    JButton login,back;


    login(){
        JLabel  username = new JLabel("Username ");
        username.setBounds(40,20,100,30);
        add(username);

        tusername=new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel  password = new JLabel("Password ");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword=new JTextField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login =new JButton("LOGIN");
        login.setBounds(50,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back =new JButton("BACK");
        back.setBounds(235,140,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22=i11.getImage().getScaledInstance(500,270,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel imgg=new JLabel(i33);
        imgg.setBounds(350,10,550,250);
        add(imgg);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,270,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,560,270);
        add(img);

        setSize(560,270);
        setLocation(250,70);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try{
                String username=tusername.getText();
                String password=tpassword.getText();



                com con=new com();
                String query="select *from login where username='"+username+"' and password='"+password+"'";
                ResultSet res=con.stm.executeQuery(query);
                if(res.next()){
                    setVisible(false);
                    new main_class();
                }else{
                    JOptionPane.showMessageDialog(null,"Invaild");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else if(e.getSource()==back){
            System.exit(90);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
