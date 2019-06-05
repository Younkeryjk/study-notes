import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 使用字符流把字符串写入到文件
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