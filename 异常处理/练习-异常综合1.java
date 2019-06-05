 
/**
 * @author Younker
 *
 * 2019��5��16��
 * 
 * ��ϰ-�쳣�ۺ�1
 */
public class Account {
	private float balance;//���
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
	public float getBalance() {//��ȡ���
		return balance;
	}
	
	public void deposit(float amount) {//��Ǯ
		balance += amount;
	}
	public void withdraw(float amount) throws OverdraftException {//ȡǮ
		if (balance < amount ) {
			throw new OverdraftException("͸֧�쳣");
		}
		balance -= amount;
	}
	
	public static void main(String[] args) throws OverdraftException {
		Account a = new Account(0);
        System.out.println("�����...");
        a.deposit(15000);
        System.out.println("ȡ����...");
        try {
            a.withdraw(20000);

		} catch (OverdraftException e) {
			System.out.println("ȡ���ûǮඣ�");
		}

	}

}
