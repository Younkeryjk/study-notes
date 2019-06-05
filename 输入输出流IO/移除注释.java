import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Younker
 *
 * 2019年5月20日
 * 
 * 练习-移除注释
 * 设计一个方法，用于移除Java文件中的注释，比如，移出以//开头的注释行
 * public void removeComments(File javaFile)
 * 
 */
//注： 如果注释在后面，或者是/**/风格的注释，暂不用处理
public class Test {
	public static void removeComments(File javaFile) {
		try (
				FileReader fr = new FileReader(javaFile);
				BufferedReader br = new BufferedReader(fr);
				
				FileWriter fw = new FileWriter("E:/Java/Test/src/annotation.txt");
				PrintWriter pw = new PrintWriter(fw);
			) {
				while(true) {
					String line = br.readLine();
					if (null == line)
						break;
					if (line.startsWith("//"))
						continue;
					pw.println(line);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/test.txt");
    	removeComments(f);
    }
}