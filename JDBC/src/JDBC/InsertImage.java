package JDBC;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertImage {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/images";
        String username="root";
        String password="root";
        String img_path = "C:\\Users\\USER\\Pictures\\Screenshots\\wallpaper.jpg";

        String query="insert into image(img_data)values(?);";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            FileInputStream fileInputStream=new FileInputStream(img_path);
            byte[]image_data=new byte[fileInputStream.available()];
            fileInputStream.read(image_data);
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setBytes(1,image_data);
            int rowsAffected=preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("image inserted into database!!");
            }else {
                System.out.println("insertion failed!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
