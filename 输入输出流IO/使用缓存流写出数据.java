import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Younker
 *
 * 2019年5月20日
 * 
 * 使用缓存流写出数据
 */
public class Test {
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/buffer.txt");
    	try (
    			FileWriter fw = new FileWriter(f);
    			PrintWriter pw = new PrintWriter(fw);
    		) {
    		pw.println("garen kill teemo");
    		pw.flush();
    		pw.println("teemo revive after 1 minutes");
            pw.println("teemo try to garen, but killed again");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}