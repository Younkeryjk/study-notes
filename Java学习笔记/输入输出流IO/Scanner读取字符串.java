import java.io.InputStream;
import java.util.Scanner;

public class Test {
/**
 * @author Younker
 *
 * 2019年5月20日
 * 
 * Scanner读取字符串
 * 使用System.in.read虽然可以读取数据，但是很不方便
 * 使用Scanner就可以逐行读取了
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