package bank.management.system;

import java.sql.*;

public class Con {
    Connection conection;
    Statement statement;
    public Con(){
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Mallu@123");
            statement = conection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
