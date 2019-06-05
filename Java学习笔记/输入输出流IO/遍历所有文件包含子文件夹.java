import java.io.File;
import java.util.Iterator;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 遍历子文件夹
 */
public class Test {
	static long max = 0;
	static long min = Long.MAX_VALUE;
	static File maxFile = null;
	static File minFile = null;
	
	public static void iteratorChildDir(File file) {
		if (file.isFile()) {
			long fileSize = file.length();
			if (fileSize > max) {
				max = fileSize;
				maxFile = file;
			}
			if (fileSize > 0 && fileSize < min) {
				min = fileSize;
				minFile = file;
			}
		}
		if (file.isDirectory()) {
			File[] allFiles = file.listFiles();
			for (File f : allFiles) {
				iteratorChildDir(f);
			}
		}
	}
	
    public static void main(String[] args) {
        File f = new File("E:/Java/Test/src");
    	iteratorChildDir(f);
    	System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());
    }
 
}