package JDBC;
import com.mysql.jdbc.Driver;

import java.sql.*;
public class UpdateData {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/pratik";
        String userName="root";
        String passWord="root";
        String query="update student set id=3,name='pratik',sub='java' where id=1;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,userName,passWord);
            Statement stmt=con.createStatement();
            int rowAffected=stmt.executeUpdate(query);
            if(rowAffected>0){
                System.out.println(rowAffected+"rows affected");
            }else{
                System.out.println("updation failed");
            }
            con.close();
            stmt.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
