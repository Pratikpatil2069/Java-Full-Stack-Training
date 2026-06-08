package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TranjectionManagement {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/tranjection_management";
        String username="root";
        String password="root";
        String debit="update tranjection set balence=balence-? where account_no=?;";
        String credit="update tranjection set balence=balence+? where account_no=?;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            con.setAutoCommit(false);
            try {
                PreparedStatement preparedStatement = con.prepareStatement(debit);
                PreparedStatement preparedStatement1 = con.prepareStatement(credit);
                preparedStatement.setDouble(1, 500);
                preparedStatement.setString(2, "123");
                preparedStatement1.setDouble(1, 500);
                preparedStatement1.setString(2, "456");
                preparedStatement.executeUpdate();
                preparedStatement1.executeUpdate();
                con.commit();
                System.out.println("transection successfull!! ");
            } catch (Exception e) {
                con.rollback();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
