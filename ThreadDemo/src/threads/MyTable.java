package threads;

public class MyTable  extends Thread{
	Table t;
	 MyTable(Table t) {
		this.t=t;
	}
	
	 public void run() {
		 t.printTable(5);
	 }
}
