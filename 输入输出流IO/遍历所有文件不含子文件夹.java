import java.io.File;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 遍历这个目录下所有的文件(不用遍历子目录)
 * 找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
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
    	System.out.printf("最大文件是：%s，其大小是%d字节", maxFileName, max);
    	System.out.println();
    	System.out.printf("最小文件是：%s，其大小是%d字节", minFileName, min);
    }
}