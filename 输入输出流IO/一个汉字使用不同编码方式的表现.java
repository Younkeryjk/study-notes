/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * һ������ʹ�ò�ͬ���뷽ʽ�ı���
 */
public class Test {
	private static void showCode(String str) {
		String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
		for (String encode : encodes) {
			showCode(str, encode);
		}
	}
	private static void showCode(String str, String encode) {
		System.out.printf("�ַ�: \"%s\" ���ڱ��뷽ʽ%s�µ�ʮ������ֵ��%n", str, encode);
		try {
			byte[] bs = str.getBytes(encode);
			for (byte b : bs) {
				int i = b&0xff;
				System.out.print(Integer.toHexString(i)+"\t");
			}
			System.out.println();
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
    public static void main(String[] args) {
    	String str = "��";
    	showCode(str);
    }
}