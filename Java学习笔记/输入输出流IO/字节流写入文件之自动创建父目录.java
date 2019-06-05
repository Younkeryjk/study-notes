import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 字节流写入文件之自动创建父目录
 */
public class Test {

    public static void main(String[] args) {
    	String filePath = "E:/Java/Test/src/new/child/fileOutputStream.txt";
    	String newDirName = filePath.substring(0, filePath.lastIndexOf("/"));
    	File newDir = new File(newDirName);
		if (!newDir.exists()) {
			newDir.mkdirs();
		}
		
        File f = new File(filePath);
        try {
        	FileOutputStream fos = new FileOutputStream(f);
        	byte[] b = {'Y', 'j', 'k'};
        	fos.write(b);
        	fos.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}