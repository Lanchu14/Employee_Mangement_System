package employee.management.system;
import java.sql.*;

public class com {

    Connection con;
    Statement stm;
    public com(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employementmanagment","root","root");
            stm=con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
