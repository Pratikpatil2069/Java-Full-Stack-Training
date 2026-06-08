package JDBC;

import java.sql.*;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/sitj2";
		String userName="root";
		String password="root";
		
		try {
			Connection con= DriverManager.getConnection(url,userName,password);
			
			System.out.println("enter the id:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("enter the Name:");
			String name=sc.nextLine();
			System.out.println("enter the salary:");
			double salary=sc.nextDouble();
			
			String query="insert into emp(id,name,salary) values(?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			
			int rows=ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("successful!");
			}else {
				System.out.println("failed!");
			}
			
			ps.close();
			con.close();
			sc.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		

	}

}
