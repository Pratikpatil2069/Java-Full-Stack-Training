package Bank;

public class Bank {

	public static void main(String[] args) {
		BankOfIndia boi=new BankOfIndia();
		BankOfMaharastra bom=new BankOfMaharastra();
		Sbi sbi=new Sbi();
		boi.interest();
		bom.interest();
		sbi.interest();

	}

}
