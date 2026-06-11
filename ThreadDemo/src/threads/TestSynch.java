package threads;

public class TestSynch {

	public static void main(String[] args) {
		Table t=new Table();
		MyTable mt=new MyTable(t);
		MyTable1 mt1=new MyTable1(t);
		MyTable2 mt2=new MyTable2(t);
		MyTable3 mt3=new MyTable3(t);
		mt.start();
		mt1.start();
		mt2.start();
		mt3.start();
	}

}
