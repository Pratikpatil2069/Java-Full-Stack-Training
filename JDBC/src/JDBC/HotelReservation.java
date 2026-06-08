package JDBC;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class HotelReservation {

    private static final String url="jdbc:mysql://localhost:3306/hotel_minigoa";
    private static final String username="root";
    private static final String passWord="root";

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, passWord);
            Scanner sc = new Scanner(System.in);

            for (;;) {
                System.out.println("WELCOME TO HOTEL_MiniGoa MANAGEMENT SYSTEM!!!");
                System.out.println("1. Reserve a Room\n 2. View Reservations\n 3. Get Room Number\n 4. Update Reservation\n 5. Delete Reservation\n 6.Exit");
                System.out.println("Choose An Option:");
                char choice = sc.next().charAt(0);
                switch (choice) {
                    case '1':
                        HotelReservation.reserveRoom(con,sc);
                        break;
                    case '2':
                        HotelReservation.viewReservations(con,sc);
                        break;
                    case '3':
                        HotelReservation.getRoomNumber(con,sc);
                        break;
                    case '4':
                        HotelReservation.updateReservation(con,sc);
                        break;
                    case '5':
                        HotelReservation.deleteReservation(con,sc);
                        break;
                    case '6':
                        System.out.println("Thank You For Visiting....");
                        HotelReservation.Exit();
                    default:
                        System.out.println("Please Insert Correct Data!");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void reserveRoom(Connection con,Scanner sc){
        System.out.println("Enter a Guest Name:");
        String GuestName=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter The Room Number:");
        int roomNumber=sc.nextInt();
        System.out.println("Enter The Contact Number:");
        String ContactNumber=sc.nextLine();
        sc.nextLine();
        String query="insert into reservation(guest_name,room_no,contact_no)" +
                "values('"+GuestName+"',"+roomNumber+",'"+ContactNumber+"');";
        try{
            Statement stmt=con.createStatement();
            int affectedRow=stmt.executeUpdate(query);
            if(affectedRow>0){
                System.out.println("Your Reservation Is Successfully Completed!!");
            }else{
                System.out.println("Reservation Failed!!!");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public static void viewReservations(Connection con,Scanner sc){
        String query="select * from reservation;";
        try{
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            while(resultSet.next()){
                int id=resultSet.getInt("Reservation_id");
                String name=resultSet.getString("guest_name");
                sc.nextLine();
                int roomNo=resultSet.getInt("room_no");
                String mobileNo=resultSet.getString("contact_no");
                sc.nextLine();
                String date=resultSet.getString("reservation_date").toString();
                System.out.println("Reservation_id:"+id);
                System.out.println("Guest Name:"+name);
                System.out.println("Room Number:"+roomNo);
                System.out.println("Mobile number:"+mobileNo);
                System.out.println("Date Of Reservation:"+date);
                System.out.println("___________________________________________________________________");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public static void getRoomNumber(Connection con,Scanner sc){
        System.out.println("Enter your Reservation id:");
        int id=sc.nextInt();
        System.out.println("Enter Guest Name:");
        String name=sc.nextLine();
        sc.nextLine();

        String query="select room_no from Reservation where reservation_id="+id+" AND Guest_name='"+name+"';";

        try{
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            if(resultSet.next()){
                int room_no=resultSet.getInt("room_no");
                System.out.println("your room number is:"+room_no);
            }else{
                System.out.println("Reservation con not found for given id and guest name!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void updateReservation(Connection con,Scanner sc){
        System.out.println("Enter the Reservation Id:");
        int id=sc.nextInt();
        if(!reservationExist(con,id)){
            System.out.println("Reservation Not Found For The Given Id:"+id);
            return;
        }
        System.out.println("Enter New Guest Name:");
        String GuestName=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter The New Room Number:");
        int roomNumber=sc.nextInt();
        System.out.println("Enter The New Contact Number:");
        String ContactNumber=sc.nextLine();
        sc.nextLine();
        String query="update reservation set guest_name='"+GuestName+"'room_no="+roomNumber+" '"+ContactNumber+"' where reservation_id="+id+";";
        try{
            Statement stmt=con.createStatement();
            int affectedRow=stmt.executeUpdate(query);
            if(affectedRow>0){
                System.out.println("row affected:"+affectedRow);
            }else{
                System.out.println("Reservation Update Failed!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteReservation(Connection con,Scanner sc){
        System.out.println("Enter The Reservation id For Deleting Reservation:");
        int id=sc.nextInt();
        if(!reservationExist(con,id)){
            System.out.println("Your Reservation Is Not Found!!");
            return;
        }
        String query="delete from reservation where reservation_id="+id+";";
        try{
            Statement stmt=con.createStatement();
            int affectedRow= stmt.executeUpdate(query);
            if(affectedRow>0){
                System.out.println("Your Reservation is Deleted Successfully!!");
            }else{
                System.out.println("Deletion is Failed!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public  static boolean reservationExist(Connection con ,int id) {
        String query = "select reservation_id from reservation where reservation_id=" + id + ";";
        try {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            return resultSet.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static void Exit(){
        System.out.println("Exiting System");
        for(int i=0;i<5;i++){
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
                break;
            }
        }
        System.out.println();
        System.out.println("Thank You For Using Hotel_MiniGoa reservation System!!!");



    }

}
