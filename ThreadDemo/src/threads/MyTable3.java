package threads;

public class MyTable3  extends Thread{
	Table t;
	 MyTable3(Table t) {
		this.t=t;
	}
	
	 public void run() {
		 t.printTable(5);
	 }
}
