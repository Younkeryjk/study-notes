import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * ���ֽ�������ʽ��ȡ�ļ�����
 */
public class Test {

    public static void main(String[] args) {
        File f = new File("E:/Java/Test/src/test.txt");
        try {
            FileInputStream fis = new FileInputStream(f);
            byte[] all = new byte[(int)f.length()];
            fis.read(all);
            for (byte b : all) {
            	System.out.println(b);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
    }
}