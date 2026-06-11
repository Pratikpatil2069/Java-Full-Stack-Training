package threads;

public class TestSynch2 {

	public static void main(String[] args) {
		final Table t=new Table();
		
		Thread t1=new Thread() {
			public void run() {
				t.printTable(10);
			}
		};
		
		Thread t2=new Thread() {
			public void run() {
				t.printTable(10);
			}
		};
		t1.start();
		t2.start();
		

	}

}
