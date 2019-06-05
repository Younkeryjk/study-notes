import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 用FileInputStream 字节流正确读取中文
 */
public class Test {
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/test.txt");
    	try (FileInputStream fis = new FileInputStream(f);) {
    		byte[] all = new byte[(int) f.length()];
    		fis.read(all);
    		System.out.println("文件中读出来的数据是：");
    		for (byte b : all) {
    			int i = b&0x000000ff;
    			System.out.println(Integer.toHexString(i));
    		}
    		System.out.println("把这个数字，放在GBK的棋盘上去：");
    		String str = new String(all, "GBK");
    		System.out.println(str);
    	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}