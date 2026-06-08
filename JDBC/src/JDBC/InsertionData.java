package JDBC;
import java.sql.*;
public class InsertionData {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/pratik";
        String userName="root";
        String passWord="root";
        String query="insert into student(id,name,sub) values(1,'pratik','java');";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,userName,passWord);
            Statement stmt=con.createStatement();
            int rowAffected=stmt.executeUpdate(query);
            if(rowAffected>0){
                System.out.println(rowAffected+"rows affected");
            }else{
                System.out.println("insertion falied");
            }
            stmt.close();
            con.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
