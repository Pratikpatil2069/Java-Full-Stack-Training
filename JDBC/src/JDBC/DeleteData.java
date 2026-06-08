package JDBC;
import java.sql.*;
public class DeleteData {
    public static void main(String[] args){
        String userName="root";
        String passWord="root";
        String url="jdbc:mysql://localhost:3306/pratik";
        String query="delete from student where id=3;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,userName,passWord);
            Statement stmt=con.createStatement();
            int rowCount=stmt.executeUpdate(query);
            if(rowCount>0){
                System.out.println(rowCount+"rows affected");
            }else{
                System.out.println("deletion failed");
            }
            con.close();
            stmt.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
