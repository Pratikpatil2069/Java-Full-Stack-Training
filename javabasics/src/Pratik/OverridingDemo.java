package Pratik;

//parent class
class Car{
	void ApplyBrake(){
		
		System.out.println("Apply brake");
	}
}

//child class
class Tata extends Car{
	
	void ApplyBrake(){
		
		System.out.println("Tata Apply brake");
	}
	
}
public class OverridingDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Tata();
		car.ApplyBrake();
		
		Tata tata= new Tata();
		tata.ApplyBrake();
		
		Car car1 = new Car();
		car1.ApplyBrake();

	}

}

