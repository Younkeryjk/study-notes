import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 练习-破解密码
 * 
 * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
 * 2. 创建一个破解线程，使用穷举法，匹配这个密码 
 * 3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
 * 提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。
 * 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。
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
			 System.out.println("尝试密码：" + gussPassword);
             if(gussPassword.equals(realPassWord)){
                 System.out.println("破解密码成功，密码为：" + gussPassword);
                 break;
             }
		}
		
	}
	
	public static void main(String[] args) {
		String realPassWord = randStr(3);
		System.out.println("实际密码是："+realPassWord);
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
