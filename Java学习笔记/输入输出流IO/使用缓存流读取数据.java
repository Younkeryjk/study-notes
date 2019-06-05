import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author Younker
 *
 * 2019��5��20��
 * 
 * ʹ�û�������ȡ����
 */
public class Test {
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/test.txt");
    	try (
    			FileReader fr = new FileReader(f);
    			BufferedReader br = new BufferedReader(fr);
    		) {
			while (true) {
				String line = br.readLine();
				if (null == line)
					break;
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}