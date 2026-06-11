package Collection;

import java.util.ArrayList;
import java.util.Scanner;

class emp{
	int id;
	String name;
	double salary;
	emp(int id,String name,double salary){
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
}


public class EmpProject {
	static int ind=0;
	static public void addEmp(ArrayList<emp>list,Scanner sc) {
		sc.nextLine();
		System.out.println("Enter the name of Emp:");
		String name=sc.nextLine();
		
		System.out.println("Enter the salary:");
		double salary=sc.nextDouble();
		list.add(new emp(ind++,name,salary));
	}
	static public void getEmp(ArrayList<emp>list,Scanner sc) {
		
		System.out.println("Enter the id of Emp:");
		int id=sc.nextInt();
		if(id>list.size()) {
			System.out.println("invalid id");
		}else {
			emp e=list.get(id-1);
			System.out.println("name:"+e.name.toString());
			System.out.println("salary:"+e.salary);
		}
		
	}
	static public void deleteEmp(ArrayList<emp>list,Scanner sc) {
	
		System.out.println("Enter the id of Emp to delete:");
		int id=sc.nextInt();
		if(id>list.size()) {
			System.out.println("invalid id");
		}else {
			emp e=list.remove(id-1);
			System.out.println("delete successful!!");
		}
		
	}
	static public void getAllEmp(ArrayList<emp>list,Scanner sc) {
		
		if(list.size()==0) {
			System.out.println("no emp in list!");
		}else {
			for(int i=0;i<list.size();i++) {
				emp e=list.get(i);
				System.out.println("id:" +(i+1));
				System.out.println("name:" +e.name.toString());
				System.out.println("id:" +e.salary);
				System.out.println("--------------------------------------------------------------------------------");
				
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<emp>list=new ArrayList<>();
		System.out.println("welcome to emp System");
		for (;;) {
            System.out.println("1.add\n2.View\n3.delete\n4.getAllemp\n5.exit");
            System.out.println("Choose An Option:");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                		EmpProject.addEmp(list,sc);
                    break;
                case '2':
                 	EmpProject.getEmp(list,sc);
                    break;
                case '3':
                 	EmpProject.deleteEmp(list,sc);
                    break;
                case '4':
                 	EmpProject.getAllEmp(list,sc);
                    break;
                case '5':
                    System.exit(0);
                    break;
               
                default:
                    System.out.println("Please Insert Correct Data!");
            }

	}

}
}
