package Section8;

import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<Branch> branches;
	
	public Bank(String name) {
		this.name = name;
		branches = new ArrayList<Branch>();
	}
	
	public boolean addBranch(String branchName) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			return false;
		}
		branch = new Branch(branchName);
		branches.add(branch);
		return true;
	}
	
	public boolean addCustomer(String branchName, String customerName, double initTrans) {
		Branch branch = findBranch(branchName);
		if (branch == null) {
			return false;
		}
		return branch.newCustomer(customerName, initTrans);
	}
	
	public boolean addCustomerTransaction(String branchName, String customerName, double trans) {
		Branch branch = findBranch(branchName);
		if (branch == null) {
			return false;
		}
		
		return branch.addCustomerTransaction(customerName, trans);
	}
	
	public boolean listCustomers(String branchName, boolean printTrans) {
		Branch branch = findBranch(branchName);
		if (branch == null) {
			return false;
		}
		int i = 1;
		System.out.println("Customer details for branch " + branchName);
		for (Customer customer : branch.getCustomers()) {
			System.out.println("Customer: " + customer.getName() + "[" + i + "]");
			if (printTrans) {
				int j = 1;
				for (double trans: customer.getTransactions()) {
					System.out.println("[" + j + "]" + " Amount " + trans);
					j++;
				}	
			}
			i++;
		}
		return true;
	}
	
	private Branch findBranch(String branchName) {
		for (Branch branch : branches) {
			if (branch.getName().equals(branchName)) {
				return branch;
			}
		}
		return null;
	}


}
