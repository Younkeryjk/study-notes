import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * ʹ���ַ������ַ���д�뵽�ļ�
 */
public class Test {

    public static void main(String[] args) throws IOException {
    	File f = new File("E:/Java/Test/src/char.txt");
    	try (FileWriter fw = new FileWriter(f)) {
    		String data="abcdefg1234567890";
    		char[] cs = data.toCharArray();
    		fw.write(cs);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}