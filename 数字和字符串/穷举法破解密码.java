import java.util.Random;

/**
 * @author Younker
 *
 * 2019��5��14��
 * 
 * ��ٷ��ƽ�����
 * 
 * 1. ����һ��������3������ַ�����������ַ�����Ϊ��������
 * 2. ʹ����ٷ����ɳ�����3���ַ�����ƥ���������ɵ�����
 * Ҫ�� �ֱ�ʹ�ö��forѭ�� �� �ݹ�����������
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
    	System.out.println("���ص������ǣ�");
    	System.out.println(password);
    	char[] charArr = getCharArr();
    	char[] newChar;
    	System.out.println("���������С�����");

    	/*outer: for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < charArr.length; j++) {
				for (int j2 = 0; j2 < charArr.length; j2++) {
					String gussPwd = Character.toString(charArr[i]) + Character.toString(charArr[j]) + Character.toString(charArr[j2]);					
					if (gussPwd.equals(password)) {
						System.out.println("��ϲ�㣬����ɹ��������ǣ�" + gussPwd);
						break outer;
					}
				}
			}
		}*/
    	String gussPwd;
    	do {
    		System.out.println("��������ing����ȱ����ȵȴ�");
    		 gussPwd = randStr(3);
    	}
    	while (!gussPwd.equals(password));
    	System.out.println("��ϲ�㣬����ɹ��������ǣ�" + gussPwd);
    }
 
}


