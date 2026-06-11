package threads;

public class MyTable2  extends Thread{
	Table t;
	 MyTable2(Table t) {
		this.t=t;
	}
	
	 public void run() {
		 t.printTable(5);
	 }
}
