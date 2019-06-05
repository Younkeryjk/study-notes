import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * ��FileReader �ַ�����ȷ��ȡ����
 */
public class Test {
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/test.txt");
    	System.out.println("Ĭ�ϱ��뷽ʽ:"+Charset.defaultCharset());
    	try (FileReader fr = new FileReader(f)) {
    		char[] cs = new char[(int) f.length()];
    		fr.read(cs);
    		System.out.printf("FileReader��ʹ��Ĭ�ϵı��뷽ʽ%s,ʶ��������ַ��ǣ�%n",Charset.defaultCharset());
    		System.out.println(new String(cs));
    	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	//FileReader�ǲ����ֶ����ñ��뷽ʽ�ģ�Ϊ��ʹ�������ı��뷽ʽ��ֻ��ʹ��InputStreamReader������
    	try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))) {
    		char[] cs = new char[(int) f.length()];
    		isr.read(cs);
    		System.out.printf("FileReader��ʹ��Ĭ�ϵı��뷽ʽ%s,ʶ��������ַ��ǣ�%n",Charset.defaultCharset());
    		System.out.println(new String(cs));
    	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}