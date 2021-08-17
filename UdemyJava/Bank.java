
public class Bank {

	private String accNumber;
	private double balance;
	private String name;
	private String email;
	private String phoneNumber;
	
	public Bank() {
		// Empty constructor. This line of code will generate a default setting based on the 
		// constructor below.
		this("1", 0.0, "Default name", "Default address", "Default phone");
	}
	
	public Bank(String name, String email, String phoneNumber) {
		// Partial constructor. we have two default values and other values are specified
		// by the user.
		this("1", 0.0, name, email, phoneNumber);
	}	
	
	public Bank(String accNumber, double balance, String name, String email, String phoneNumber) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAccNumber() {
		return this.accNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}	
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void deposit(double depAmount) {
		this.balance += depAmount;
	}
	
	public void withdraw(double witAmount) {
		if (witAmount <= this.balance) {
			this.balance -= witAmount;
		}
		else {
			System.out.println("You don't have sufficient fund.");
		}
	}
	
}
