import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 用FileReader 字符流正确读取中文
 */
public class Test {
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/test.txt");
    	System.out.println("默认编码方式:"+Charset.defaultCharset());
    	try (FileReader fr = new FileReader(f)) {
    		char[] cs = new char[(int) f.length()];
    		fr.read(cs);
    		System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
    		System.out.println(new String(cs));
    	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	//FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
    	try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))) {
    		char[] cs = new char[(int) f.length()];
    		isr.read(cs);
    		System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
    		System.out.println(new String(cs));
    	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}