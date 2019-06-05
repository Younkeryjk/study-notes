import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * ��FileInputStream �ֽ�����ȷ��ȡ����
 */
public class Test {
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/test.txt");
    	try (FileInputStream fis = new FileInputStream(f);) {
    		byte[] all = new byte[(int) f.length()];
    		fis.read(all);
    		System.out.println("�ļ��ж������������ǣ�");
    		for (byte b : all) {
    			int i = b&0x000000ff;
    			System.out.println(Integer.toHexString(i));
    		}
    		System.out.println("��������֣�����GBK��������ȥ��");
    		String str = new String(all, "GBK");
    		System.out.println(str);
    	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}