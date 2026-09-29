public class CheckingAccount extends BankAccount {
	
	private double interestRate;

	public CheckingAccount(double interestRate) {
		super();
		this.interestRate = interestRate;
	}
	
	// will withdraw amount given and display a negative balance (if needed) that includes a $30 overdraft fee and denotes that a fee has been assessed
	public void processWithdrawal(double amount) {
		withdrawal(amount);
		
		if (getBalance() < 0) {
			withdrawal(30.00);
			System.out.println("Overdraft fee of $30.00 has been assessed.");
		}
	}
	
	// should display all superclass attributes and provide an additional interest rate
	public void displayAccount() {
    	accountSummary();
    	System.out.printf("Interest Rate: %.2f%%%n", interestRate);
	}
}