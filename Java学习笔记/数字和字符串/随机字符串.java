import java.util.Random;

/**
 * @author Younker
 *
 * 2019年5月14日
 * 
 * 练习-随机字符串
 * 创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
 */
public class Test {
    public static void main(String[] args) {
    /*	方法一：
     * char[] c = new char[5];
    	Random r = new Random();
    	for (int i = 0; i < c.length; i++) {
    		switch (r.nextInt(3)) {//三种情况，0：数字，1：大写字母，2：小写字母
			case 0:
				c[i] = (char)(r.nextInt(10) + 48);
				break;
			case 1:
				c[i] = (char)(r.nextInt(26) + 65);
				break;
			case 2:
				c[i] = (char)(r.nextInt(26) + 97);
				break;
			}
		}
    	String res = new String(c);
    	System.out.println(res);*/
    	/*
    	 * 方法二：
    	 * String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	char[] c = new char[5];
    	int randIndex;
    	for (int i = 0; i < c.length; i++) {
    		randIndex = (int)(Math.random() * 62);
			c[i] = pool.charAt(randIndex);
		}
    	String res = new String(c);
    	System.out.println(res);*/
    }
 
}


