import java.io.File;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * �������Ŀ¼�����е��ļ�(���ñ�����Ŀ¼)
 * �ҳ���Щ�ļ�����ĺ���С(��0)���Ǹ��ļ�����ӡ�����ǵ��ļ���
 */
public class Test {
    public static void main(String args[])  {
    	long max = 0;
    	long min = Long.MAX_VALUE;
    	String maxFileName = "";
    	String minFileName = "";
    	
    	File f = new File("E:/Java/Test/src");
    	File[] files = f.listFiles();
    	
    	for (File file : files) {
    		long fileSize = file.length();
			if (fileSize > max) {
				max = fileSize;
				maxFileName = file.getAbsolutePath();
			}
			if (fileSize > 0 && fileSize < min) {
				min = fileSize;
				minFileName = file.getAbsolutePath();
			}
		}
    	System.out.printf("����ļ��ǣ�%s�����С��%d�ֽ�", maxFileName, max);
    	System.out.println();
    	System.out.printf("��С�ļ��ǣ�%s�����С��%d�ֽ�", minFileName, min);
    }
}