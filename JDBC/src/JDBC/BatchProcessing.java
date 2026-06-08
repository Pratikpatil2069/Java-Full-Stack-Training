package JDBC;
import java.awt.datatransfer.SystemFlavorMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Locale;
import java.util.Scanner;
public class BatchProcessing {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/tranjection_management";
        String username="root";
        String password="root";
        String query="insert into tranjection(account_no,balence) values(?,?);";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            con.setAutoCommit(false);
            Scanner sc=new Scanner(System.in);
            try {
                PreparedStatement preparedStatement= con.prepareStatement(query);
                while(true){
                    System.out.print("enter account_no:");
                    String no=sc.nextLine();
                    System.out.print("enter balence:");
                    double balence=sc.nextDouble();
                    preparedStatement.setString(1,no);
                    preparedStatement.setDouble(2,balence);
                    preparedStatement.addBatch();
                    System.out.println("if you are insert more details then true otherwise false");
                    boolean flag=sc.nextBoolean();
                    sc.nextLine();
                    if(!flag){
                        break;
                    }
                }
                int []batch_data=preparedStatement.executeBatch();
                con.commit();
                System.out.println("data insertion  successful!! ");
            } catch (Exception e) {
                con.rollback();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
