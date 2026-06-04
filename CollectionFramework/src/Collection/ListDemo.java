package Collection;

import java.util.ArrayList;

public class ListDemo {

	public static void main(String[] args) {
		ArrayList<String>list=new ArrayList<>();
		list.add("Pratik");
		list.add("Aditya");
		list.add("Rohan");
		list.add("Aditya");
		list.add("Apurv");
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

	}

}
