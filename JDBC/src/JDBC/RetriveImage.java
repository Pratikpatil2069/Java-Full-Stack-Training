package JDBC;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetriveImage {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/images";
        String username="root";
        String password="root";
        String query="select img_data from image where img_id=(?);";
        String folder_path="C:\\Users\\USER\\Pictures\\Screenshots\\";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet resultSet=preparedStatement.executeQuery();
           while (resultSet.next()){
               byte[] image_data=resultSet.getBytes("img_data");
               String img_path=folder_path+"gym.jpg";
               FileOutputStream fileOutputStream=new FileOutputStream(img_path);
               fileOutputStream.write(image_data);
           }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
