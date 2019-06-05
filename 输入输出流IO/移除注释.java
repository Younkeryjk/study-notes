import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Younker
 *
 * 2019��5��20��
 * 
 * ��ϰ-�Ƴ�ע��
 * ���һ�������������Ƴ�Java�ļ��е�ע�ͣ����磬�Ƴ���//��ͷ��ע����
 * public void removeComments(File javaFile)
 * 
 */
//ע�� ���ע���ں��棬������/**/����ע�ͣ��ݲ��ô���
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