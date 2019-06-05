 
/**
 * @author Younker
 *
 * 2019年5月16日
 * 
 * 练习-异常综合1
 */
public class Account {
	private float balance;//余额
	class OverdraftException extends Exception {
		public OverdraftException() {
			
		}
		public OverdraftException(String msg) {
			super(msg);
		}
	}
	public Account(float balance) throws OverdraftException {
		if (balance < 0) {
			throw new OverdraftException();
		}
		this.balance = balance;
	}
	public float getBalance() {//获取余额
		return balance;
	}
	
	public void deposit(float amount) {//存钱
		balance += amount;
	}
	public void withdraw(float amount) throws OverdraftException {//取钱
		if (balance < amount ) {
			throw new OverdraftException("透支异常");
		}
		balance -= amount;
	}
	
	public static void main(String[] args) throws OverdraftException {
		Account a = new Account(0);
        System.out.println("存款中...");
        a.deposit(15000);
        System.out.println("取款中...");
        try {
            a.withdraw(20000);

		} catch (OverdraftException e) {
			System.out.println("取款机没钱喽！");
		}

	}

}
