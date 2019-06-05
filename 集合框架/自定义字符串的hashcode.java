/**
 * @author Younker
 *
 * 2019年5月22日
 * 
 * 	自定义字符串的hashcode
 * 	如下是Java API提供的String的hashcode生成办法；
 
	s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
	s[0] 表示第一位字符
	n表示字符串的长度
	本练习并不是要求去理解这个算法，而是自定义一个简单的hashcode算法，计算任意字符串的hashcode
	因为String类不能被重写，所以我们通过一个静态方法来返回一个String的hashcode
	public static int hashcode(String)
	如果字符串长度是0，则返回0。
	否则： 获取每一位字符，转换成数字后，相加，最后乘以23
	(s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
	如果值超过了1999，则取2000的余数，保证落在0-1999之间。
	如果是负数，则取绝对值。
	随机生成长度是2-10的不等的100个字符串，打印用本hashcode获取的值分别是多少
 */
public class Test {
	public static String randStr() {
		String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	int randomStrLen = (int)(Math.random() * 9) + 2;
		char[] c = new char[randomStrLen];
    	int randIndex;
    	for (int i = 0; i < c.length; i++) {
    		randIndex = (int)(Math.random() * 62);
			c[i] = pool.charAt(randIndex);
		}
    	return new String(c);
	}
	public static int hashcode(String str) {
		if (0 == str.length()) {
			return 0;
		}
		int sum = 0;
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i);
		}
		res = sum * 23;
		if (res > 0) {
			res = res % 2000;
		} else {
			res = Math.abs(res);
        }
		return res;
	}
    public static void main(String[] args) {
    	for (int i = 0; i < 100; i++) {
			String str = randStr();
			int hashCode = hashcode(str);
			System.out.printf("%s的自定义hashcode码是：%d", str, hashCode);
			System.out.println();
		}
    }
}