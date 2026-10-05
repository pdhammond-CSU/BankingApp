public class BankAccountTest {
	public static void main(String[] args) {
		
		// creating a CheckingAccount instance name wellsFargo
		CheckingAccount wellsFargo = new CheckingAccount(1.25);
		
		// set first, last name and account ID
		wellsFargo.setFirstName("Pierce");
		wellsFargo.setLastName("Dae");
		wellsFargo.setAccountID(100245);

		// Testing deposit
        System.out.println("Test Case 1: Deposit Money");
        wellsFargo.deposit(220.00);
        wellsFargo.displayAccount();

        // Testing withdrawal
        System.out.println("\nTest Case 2: Regular Withdrawal");
        wellsFargo.processWithdrawal(60.00);
        wellsFargo.displayAccount();

        // Testing overdraft
        System.out.println("\nTest Case 3: Overdraft Withdrawal");
        wellsFargo.processWithdrawal(350.00);
        wellsFargo.displayAccount();
        
        
    }
}
