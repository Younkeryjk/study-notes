/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * 	�Զ����ַ�����hashcode
 * 	������Java API�ṩ��String��hashcode���ɰ취��
 
	s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
	s[0] ��ʾ��һλ�ַ�
	n��ʾ�ַ����ĳ���
	����ϰ������Ҫ��ȥ�������㷨�������Զ���һ���򵥵�hashcode�㷨�����������ַ�����hashcode
	��ΪString�಻�ܱ���д����������ͨ��һ����̬����������һ��String��hashcode
	public static int hashcode(String)
	����ַ���������0���򷵻�0��
	���� ��ȡÿһλ�ַ���ת�������ֺ���ӣ�������23
	(s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
	���ֵ������1999����ȡ2000����������֤����0-1999֮�䡣
	����Ǹ�������ȡ����ֵ��
	������ɳ�����2-10�Ĳ��ȵ�100���ַ�������ӡ�ñ�hashcode��ȡ��ֵ�ֱ��Ƕ���
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
			System.out.printf("%s���Զ���hashcode���ǣ�%d", str, hashCode);
			System.out.println();
		}
    }
}