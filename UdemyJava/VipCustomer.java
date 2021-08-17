
public class VipCustomer {
	
	private String name;
	private double creditLimit;
	private String email;
	
	public VipCustomer() {
		this("Default name", 0.0, "Default Address");
	}

	public VipCustomer(String name, double creditLimit, String email) {
		this.name = name;
		this.creditLimit = creditLimit;
		this.email = email;
	}
	
	public VipCustomer(String name, String email) {
		this(name, 0.0, email);
	}
	
	public void getName() {
		System.out.println(this.name);
	}
	
	public void getCreditLimit() {
		System.out.println(this.creditLimit);
	}
	
	public void getEmail() {
		System.out.println(this.email);
	}
}
