package Section8;

import java.util.ArrayList;

public class Branch {
	private String name;
	private ArrayList<Customer> customers;

	public Branch(String name) {
		this.name = name;
		customers = new ArrayList<Customer>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public boolean newCustomer(String customerName, double initTrans) {
		Customer customer = findCustomer(customerName);
		if (customer != null) {
			return false;
		}
		customer = new Customer(customerName, initTrans);
		customers.add(customer);
		return true;
	}

	public boolean addCustomerTransaction(String customerName, double Trans) {
		Customer customer = findCustomer(customerName);
		if (customer == null) {
			return false;
		}

		customer.addTransaction(Trans);
		return true;

	}

	private Customer findCustomer(String customerName) {
		for (Customer customer : customers) {
			if (customer.getName().equals(customerName)) {
				return customer;
			}
		}
		return null;
	}

}
