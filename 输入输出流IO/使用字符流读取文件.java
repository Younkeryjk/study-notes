import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 使用字符流读取文件
 */
public class Test {

    public static void main(String[] args) throws IOException {
    	File f = new File("E:/Java/Test/src/test.txt");
    	try (FileReader fr = new FileReader(f)) {
			char[] all = new char[(int)f.length()];
			fr.read(all);
			for (char c : all) {
				System.out.println(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}