package Pratik;

class Cricket{
	Cricket(){}
	int totalTrophy=19;
	int totalTeams=10;
	
	public String GOAT() {
		return "CSK";
	}
	public String lolipop() {
		return "RCB1";
	}
	
}

class CSK extends Cricket{
	CSK(){}
	int totalTrophy=5;
	
	public String thala() {
		return "ms dhoni";
	}
	public String lolipop() {
		
		return "RCB2";
	}
}
public class Inheritance {

	public static void main(String[] args) {
		
		CSK csk=new CSK();
		System.out.println("GOAT:"+csk.GOAT());
		System.out.println("lolipop:"+csk.lolipop());
		System.out.println("MI che pappa:"+csk.thala());
		System.out.println("csk trophy:"+csk.totalTrophy);
	}

}
