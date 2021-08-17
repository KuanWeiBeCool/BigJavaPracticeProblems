
public class MainTester {
	public static void main(String[] args) {
//		// Test bank
//		Bank bank = new Bank(); // Use default constructor
//		Bank bank2 = new Bank("Tom", "b@gmail.com", "555"); // Use partial constructor
//		Bank bank3 = new Bank("3", 0.0, "Jack", "j@gmail.com", "666"); // Use full constructor
//		bank.setAccNumber("1");
//		bank.setBalance(0);
//		bank.setEmail("a@gmail.com");
//		bank.setName("Yo");
//		bank.setPhoneNumber("111");
//		
//		double depAmount = 100;
//		bank.deposit(depAmount);
//		bank.deposit(depAmount);
//		double balance = bank.getBalance();
//		System.out.println(balance);
//		double witAmount1 = 250;
//		bank.withdraw(witAmount1);
//		balance = bank.getBalance();
//		System.out.println(balance);
//		bank.withdraw(witAmount1-50.0);
//		balance = bank.getBalance();
//		System.out.println(balance);
		
		// Test VipCustomer
		VipCustomer vip1 = new VipCustomer();
		VipCustomer vip2 = new VipCustomer("Sam", "s@gmail.com");
		VipCustomer vip3 = new VipCustomer("Judy", 5000, "j@gmail.com");
		
		vip1.getName();
		vip1.getCreditLimit();
		vip1.getEmail();
		
		
		vip2.getName();
		vip2.getCreditLimit();
		vip2.getEmail();
		
		vip3.getName();
		vip3.getCreditLimit();
		vip3.getEmail();
	}

}
