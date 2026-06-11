package threads;

public class MyTable1  extends Thread{
	Table t;
	 MyTable1(Table t) {
		this.t=t;
	}
	
	 public void run() {
		 t.printTable(5);
	 }
}
