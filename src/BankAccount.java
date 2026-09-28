public class BankAccount {
	private String firstName;
	private String lastName;
	private int accountID;
	private double balance;

    public BankAccount() {
    	balance = 0.0;
    }

    public void deposit(double amount) {
    	balance = balance + amount;
    }

    public void withdrawal(double amount) {
    	balance = balance - amount;
    }

    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    public String getFirstName() {
    	return firstName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public String getLastName() {
    	return lastName;
    }

    public void setAccountID(int accountID) {
    	this.accountID = accountID;
    }

    public int getAccountID() {
    	return accountID;
    }

    public double getBalance() {
    	return balance;
    }

    public void accountSummary() {
    	System.out.println("Account Holder: " + firstName + " " + lastName);
    	System.out.println("Account ID: " + accountID);
    	System.out.printf("Balance: $%.2f%n", balance);
    }
}