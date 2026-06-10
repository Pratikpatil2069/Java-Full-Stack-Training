package BankApplication;

class Login{
	String un="abc";
	String pass="1234";
	
	void check(String u,String p) {
		if(un.equals(u) && pass.equals(p)) {
			System.out.println("login successful!!");
		}else {
			System.out.println("login Failed!!");
		}
	}
}

class User extends Login{
	String user="pratik";
	void login() {
		System.out.println("login successful!!");
	}
	
	void logout() {
		System.out.println("logout successful!!");
	}
}

 


public class BankApplication {

	public static void main(String[] args) {
		User u1=new User();
		u1.login();
		u1.check("abc", "1234");
		u1.logout();
		

	}

}
