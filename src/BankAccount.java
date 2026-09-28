public class BankAccount {
	
	private String firstName;
	private String lastName;
	private int accountID;
	private double balance;

	// constructor() - initialize balance to zero
    public BankAccount() {
    	balance = 0.0;
    }
    
    // deposit() - will accept a single value double parameter; the parameter 'amount' is added to the existing balance
    public void deposit(double amount) {
    	balance = balance + amount;
    }
    
    // withdrawal() - accepts a single value double dollar amount; the parameter 'amount' is subtracted from the existing balance
    public void withdrawal(double amount) {
    	balance = balance - amount;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    // Getter for firstName
    public String getFirstName() {
    	return firstName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    // Getter for lastName
    public String getLastName() {
    	return lastName;
    }

    // Setter for account ID 
    public void setAccountID(int accountID) {
    	this.accountID = accountID;
    }

    // Getter for account ID
    public int getAccountID() {
    	return accountID;
    }

    // Getter to return the balance
    public double getBalance() {
    	return balance;
    }

    // prints all account information
    public void accountSummary() {
    	System.out.println("Account Holder: " + firstName + " " + lastName);
    	System.out.println("Account ID: " + accountID);
    	System.out.printf("Balance: $%.2f%n", balance);
    }
}