package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
public class RetriveData {
    public static void main(String[] args){
        String url="jdbc:mysql://localhost:3306/pratik";
        String username="root";
        String password="root";
        String s="Select * from student;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("connected to the database");
            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery(s);
            while(res.next()){
                int id=res.getInt("id");
                String name=res.getString("name");
                String sub=res.getString("sub");
                System.out.println("---------------");
                System.out.println("id:"+id);
                System.out.println("name:"+name);
                System.out.println("sub:"+sub);
            }
            con.close();
            res.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println("connection failed:"+e.getMessage());
        }

    }
}