package com.Training.SpringBootDemo_1;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.Training.SpringBootDemo_1.UserModel.UserModel;

import java.util.Iterator;

import java.util.Optional;
import java.util.Scanner;
import  com.Training.SpringBootDemo_1.Repository.UserRepository;

@SpringBootApplication
public class SpringBootDemo1Application {
	public static void add(Scanner sc, UserRepository userRepository) {
		sc.nextLine();
	    System.out.println("Enter the user name:");
	    String name = sc.nextLine();
	    
	    System.out.println("Enter the user city:");
	    String city = sc.nextLine();

	    System.out.println("Enter the user status:");
	    String status = sc.nextLine();

	    UserModel user = new UserModel();
	    user.setName(name);
	    user.setCity(city);
	    user.setStatus(status);

	    UserModel savedUser = userRepository.save(user);

	    System.out.println("User Saved Successfully");
	    System.out.println(savedUser);
	}
	public static void update(Scanner sc, UserRepository userRepository) {

	    System.out.println("Enter the user id:");
	    int id = sc.nextInt();
	    sc.nextLine(); 

	    System.out.println("Enter the user name:");
	    String name = sc.nextLine();

	    Optional<UserModel> optional = userRepository.findById(id);

	    if(optional.isPresent()) {

	        UserModel user = optional.get();
	        System.out.println(user);

	        user.setName(name);

	        UserModel updatedUser = userRepository.save(user);

	        System.out.println(updatedUser);
	        System.out.println("Updated Successfully!!");

	    } else {
	        System.out.println("User not found with id: " + id);
	    }
	}
	 public static void delete(Scanner sc,UserRepository userRepository){
		 System.out.println("enter the user id:");
			int id=sc.nextInt();
		 userRepository.deleteById(id);
			System.out.println("Delete Successfully!!");
	    }
	 public static void getAll(Scanner sc,UserRepository userRepository){
		 Iterable<UserModel>itr=userRepository.findAll();
			Iterator<UserModel> iterator=itr.iterator();
			while(iterator.hasNext()) {
				UserModel value=iterator.next();
				System.out.println(value);
			}
	    }
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootDemo1Application.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		
		Scanner sc=new Scanner(System.in);
	
        for (;;) {
            
            System.out.println("1. Add\n 2. Update\n 3. Delete\n 4. GetAll\n 5. Exit");
            System.out.println("Choose An Option:");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                	add(sc,userRepository);
                    break;
                case '2':
                	update(sc,userRepository);
                    break;
                case '3':
                	delete(sc,userRepository);
                    break;
                case '4':
                	getAll(sc,userRepository);
                    break;
                case '5':
                    System.exit(0);
                  
                default:
                    System.out.println("Please Insert Correct Data!");
            }
        }
		        
		
		
	}

}
