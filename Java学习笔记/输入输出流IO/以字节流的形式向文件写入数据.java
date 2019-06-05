import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 以字节流的形式向文件写入数据
 */
public class Test {

    public static void main(String[] args) {
        File f = new File("E:/Java/Test/src/fileOutputStream.txt");
        try {
        	FileOutputStream fos = new FileOutputStream(f);
        	byte[] b = {'C', 'D'};
        	fos.write(b);
        	fos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
    }
}