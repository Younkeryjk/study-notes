import java.io.InputStream;
import java.util.Scanner;

public class Test {
/**
 * @author Younker
 *
 * 2019��5��20��
 * 
 * Scanner��ȡ�ַ���
 * ʹ��System.in.read��Ȼ���Զ�ȡ���ݣ����Ǻܲ�����
 * ʹ��Scanner�Ϳ������ж�ȡ��
 */

    public static void main(String[] args) {
    	/*try (InputStream is = System.in) {
			while (true) {
				int i = is.read();
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	Scanner s = new Scanner(System.in);
    	while (true) {
    		String line = s.nextLine();
    		System.out.println(line);
    	}
    }
}