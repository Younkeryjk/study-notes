import java.util.Random;

/**
 * @author Younker
 *
 * 2019年5月14日
 * 
 * 穷举法破解密码
 * 
 * 1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码
 * 2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码
 * 要求： 分别使用多层for循环 和 递归解决上述问题
 */
public class Test {
	public static String randStr(int length) {
		String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	char[] c = new char[length];
    	int randIndex;
    	for (int i = 0; i < c.length; i++) {
    		randIndex = (int)(Math.random() * 62);
			c[i] = pool.charAt(randIndex);
		}
    	return new String(c);
	}
	
	public static char[] getCharArr() {
		String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		char[] c = new char[pool.length()];
    	for (int i = 0; i < pool.length(); i++) {
    		c[i] = pool.charAt(i);
    	}
    	return c;
	}
	
    public static void main(String[] args) {
    	String password = randStr(3);
    	System.out.println("隐藏的密码是：");
    	System.out.println(password);
    	char[] charArr = getCharArr();
    	char[] newChar;
    	System.out.println("破译密码中。。。");

    	/*outer: for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < charArr.length; j++) {
				for (int j2 = 0; j2 < charArr.length; j2++) {
					String gussPwd = Character.toString(charArr[i]) + Character.toString(charArr[j]) + Character.toString(charArr[j2]);					
					if (gussPwd.equals(password)) {
						System.out.println("恭喜你，破译成功，密码是：" + gussPwd);
						break outer;
					}
				}
			}
		}*/
    	String gussPwd;
    	do {
    		System.out.println("正在破译ing，请喝杯咖啡等待");
    		 gussPwd = randStr(3);
    	}
    	while (!gussPwd.equals(password));
    	System.out.println("恭喜你，破译成功，密码是：" + gussPwd);
    }
 
}


