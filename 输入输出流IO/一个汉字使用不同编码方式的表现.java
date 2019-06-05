/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 一个汉字使用不同编码方式的表现
 */
public class Test {
	private static void showCode(String str) {
		String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
		for (String encode : encodes) {
			showCode(str, encode);
		}
	}
	private static void showCode(String str, String encode) {
		System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
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
    	String str = "中";
    	showCode(str);
    }
}