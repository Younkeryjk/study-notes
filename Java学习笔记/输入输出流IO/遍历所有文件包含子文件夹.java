import java.io.File;
import java.util.Iterator;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * �������ļ���
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
    	System.out.printf("�����ļ���%s�����С��%,d�ֽ�%n",maxFile.getAbsoluteFile(),maxFile.length());
        System.out.printf("��С���ļ���%s�����С��%,d�ֽ�%n",minFile.getAbsoluteFile(),minFile.length());
    }
 
}