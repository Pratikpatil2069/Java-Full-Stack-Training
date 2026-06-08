package JDBC;
import java.sql.*;
public class RetriveDataPrepairedStatement {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/pratik";
        String username="root";
        String password="root";
        String query="Select * from student where name=?;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1,"kartik");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String sub=resultSet.getString("sub");
                int marks=resultSet.getInt("marks");
                String date=resultSet.getString("stud_date");
                String time=resultSet.getString("stud_time");
                System.out.println("id:"+id);
                System.out.println("name:"+name);
                System.out.println("sub:"+sub);
                System.out.println("marks:"+marks);
                System.out.println("Date:"+date);
                System.out.println("Time:"+time);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
