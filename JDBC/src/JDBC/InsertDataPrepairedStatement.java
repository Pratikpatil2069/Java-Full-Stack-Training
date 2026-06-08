package JDBC;

import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDataPrepairedStatement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/pratik";
        String username="root";
        String password="root";
        String query="insert into student(id,name,sub,marks)Values(?,?,?,?);";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=con.prepareStatement(query);
            System.out.println("enter the id:");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("enter the name:");
            String name=sc.nextLine();
            System.out.println("enter the subject:");
            String sub=sc.nextLine();
            System.out.println("enter the marks:");
            int marks=sc.nextInt();
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,sub);
            preparedStatement.setInt(4,marks);

            int rowsAffected=preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("your data inserted successfully inserted!!");
            }else{
                System.out.println("Data insertion Failed!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
