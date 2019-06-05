import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Younker
 *
 * 2019��5��24��
 * 
 * ��ϰ-�ƽ�����
 * 
 * 1. ����һ��������3������ַ�����������ַ������� ����
 * 2. ����һ���ƽ��̣߳�ʹ����ٷ���ƥ��������� 
 * 3. ����һ����־�̣߳���ӡ���ù���Щ�ַ���ȥƥ�䣬�����־�߳����Ϊ�ػ��߳�
 * ��ʾ�� �ƽ��̰߳���ٷ����ɵĿ����������һ�������У���־�̲߳��ϵĴ�����������ó��������룬����ӡ������
 * ������������ǿյģ�����Ϣ1�룬������ֲ��ǿյģ��Ͳ�ͣ��ȡ��������ӡ��
 */
public class Test {
	static LinkedList<String> gussedPasswords = new LinkedList<>();
	static String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String randStr(int len) {
    	char[] c = new char[len];
    	int randIndex;
    	for (int i = 0; i < c.length; i++) {
    		randIndex = (int)(Math.random() * 62);
			c[i] = pool.charAt(randIndex);
		}
    	return new String(c);
	}
	
	public static void gussPassword(String realPassWord) {
		for (int i = 0; i < pool.length(); i++) {
			for (int j = 0; j < pool.length(); j++) {
				for (int j2 = 0; j2 < pool.length(); j2++) {
					String gussPwd = Character.toString(pool.charAt(j)) + Character.toString(pool.charAt(i)) + Character.toString(pool.charAt(j2));			
					gussedPasswords.add(gussPwd);
				}
			}
		}
	}
	
	public static void printLogs(String realPassWord) {
		while (true) {
			if (gussedPasswords.isEmpty()) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			String gussPassword = gussedPasswords.removeFirst();
			 System.out.println("�������룺" + gussPassword);
             if(gussPassword.equals(realPassWord)){
                 System.out.println("�ƽ�����ɹ�������Ϊ��" + gussPassword);
                 break;
             }
		}
		
	}
	
	public static void main(String[] args) {
		String realPassWord = randStr(3);
		System.out.println("ʵ�������ǣ�"+realPassWord);
		Thread gussPasswordThread = new Thread() {
			public void run() {
				gussPassword(realPassWord);
			}
		};
		gussPasswordThread.setDaemon(true);
		gussPasswordThread.start();
		
		Thread printLogsThread = new Thread() {
			public void run() {
				printLogs(realPassWord);
			}
		};
		printLogsThread.start();
	}
}
