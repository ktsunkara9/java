package inc.skt.structural.facade;

public class FacadeDemo2 {

	public static void main(String[] args) {
		BankAccountFacade facade = new BankAccountFacade(123456, 7899);
		facade.withdraw(9000);
		facade.withdraw(500);
		facade.deposite(2000);
	}

}

class BankAccountFacade {
	private int accountNumber;
	private int securityCode;

	private AccountChecker accountChecker;
	private SecurityCodeChecker securityCodeChecker;
	private FundsChecker fundsChecker;

	public BankAccountFacade(int accountNumber, int securityCode) {
		this.accountNumber = accountNumber;
		this.securityCode = securityCode;

		accountChecker = new AccountChecker();
		securityCodeChecker = new SecurityCodeChecker();
		fundsChecker = new FundsChecker();
	}

	public void deposite(double amount) {
		if (accountChecker.isActive(accountNumber) && securityCodeChecker.isCodeValid(securityCode)) {
			fundsChecker.deposite(amount);
			System.out.println("Transaction Completed");
		}
	}

	public void withdraw(double amount) {
		if (accountChecker.isActive(accountNumber) && securityCodeChecker.isCodeValid(securityCode)
				&& fundsChecker.haveEnoughMoney(amount)) {
			fundsChecker.withdraw(amount);
			System.out.println("Transaction Completed");
		}

	}

}

class AccountChecker {

	private int accountNumber = 123456;

	public int getAccountNumber() {
		return accountNumber;
	}

	public boolean isActive(int accountNumber) {
		return accountNumber == getAccountNumber();
	}

}

class SecurityCodeChecker {

	private int securityCode = 7899;

	public boolean isCodeValid(int codeToCheck) {
		return codeToCheck == getSecurityCode();
	}

	public int getSecurityCode() {
		return securityCode;
	}

}

class FundsChecker {
	private double amount = 10000;

	public double getAmount() {
		return amount;
	}

	public void deposite(double amountToDeposite) {
		amount += amountToDeposite;
		System.out.println("Amount Deposited Successfully, balance in your account is : " + amount);
	}

	public boolean haveEnoughMoney(double amountToWithdraw) {
		return amount >= amountToWithdraw;
	}

	public void withdraw(double amountToWithdraw) {
		if (haveEnoughMoney(amountToWithdraw)) {
			amount -= amountToWithdraw;
			System.out.println("Withdrawn Successfully, balance in your account is : " + amount);
		} else {
			System.out.println("You don't have enough Funds");
		}
	}

}