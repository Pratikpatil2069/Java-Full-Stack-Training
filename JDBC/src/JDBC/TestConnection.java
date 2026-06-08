package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args){
        String url="jdbc:mysql://localhost:3306/pratik";
        String username="root";
        String password="root";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("connected to the database");
        }catch(SQLException e){
            System.out.println("connection failed:"+e.getMessage());
        }

    }
}
