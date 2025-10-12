package inc.skt.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		
		Account account = new Account("1234", 100000);
		
		account.deposit(400000);
		
		try {
			account.withdraw(300000);
		} catch (InsufficientFundsException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		try {
			account.withdraw(300000);
		} catch (InsufficientFundsException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}

class InsufficientFundsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errMsg;
	
	public InsufficientFundsException(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String toString() {
		return errMsg;
	}
}

class Account {
	String accountNumber;
	int bal;
	
	public Account(String accountNumber, int bal) {
		this.accountNumber = accountNumber;
		this.bal = bal;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}
	
	public void deposit(int amount) {
		if(amount > 0) {
			bal = bal + amount;
			System.out.println("deposited : " +amount + " Balance is: " +bal);
		}
	}
	
	public void withdraw(int amount) throws InsufficientFundsException {
		if(amount > bal) {
			String s = "You have insufficient funds";
			System.out.println(s);
			throw new InsufficientFundsException(s);
		}
		
		bal = bal - amount;
		System.out.println(amount +" is withdrawn");
	}
}
