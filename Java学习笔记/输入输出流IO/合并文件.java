import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 合并文件
 */
public class Test {

    public static void main(String[] args) throws IOException {
    	File f = new File("E:/Java/Test/src/merge");
    	//遍历目录下所有文件，读取文件内容，追加到新文件
    	File[] files = f.listFiles();
    	byte[] b;
    	FileInputStream fis;
    	File writeFile = new File("E:/Java/Test/src/merge/merge.txt");
    	FileOutputStream fos = new FileOutputStream(writeFile);
    	for (File file : files) {
    		int fileLen = (int)(file.length());
    		b = new byte[fileLen];
    		fis = new FileInputStream(file);
    		fis.read(b);
    		fos.write(b);
        	fis.close();
		}
    	fos.close();
    }
}