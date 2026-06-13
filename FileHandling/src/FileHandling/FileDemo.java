package FileHandling;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		try {
		      File f1 = new File("Student.txt"); 
		      
		      if (f1.createNewFile()) {       
		        System.out.println("File created: " + f1.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace(); 
		    }

	}

}
