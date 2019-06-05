import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019年5月17日
 * 
 * 文件加密
 * 在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
 * 加密算法： 
 * 	数字：
 * 		如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
 * 		如果是9的数字，变成0
 * 	字母字符：
 * 		如果是非z字符，向右移动一个，比如d变成e, G变成H
 * 		如果是z，z->a, Z-A。
 * 		字符需要保留大小写
 * 	非字母字符
 * 		比如',&^ 保留不变，中文也保留不变
 */
public class Test {
	public static void encodeFile(File encodingFile, File encodedFile) {
		try (
				FileReader fr = new FileReader(encodingFile);
				FileWriter fw = new FileWriter(encodedFile)
		) {
			char[] cs = new char[(int)encodingFile.length()];
			fr.read(cs);
			for (int i = 0; i < cs.length; i++) {
				if (cs[i] >= 48 && cs[i] <= 57) {
					if (cs[i] < 57) {
						cs[i] += 1;
					} else {
						cs[i] = 48;
					}
				}
				if (cs[i] >= 65 && cs[i] <= 90) {
					if (cs[i] < 90) {
						cs[i] += 1;
					} else {
						cs[i] = 65;
					}
				}
				if (cs[i] >= 97 && cs[i] <= 122) {
					if (cs[i] < 122) {
						cs[i] += 1;
					} else {
						cs[i] = 97;
					}
				}
			}
			fw.write(cs);
		} catch (Exception e) {
		}
		
	}
	
    public static void main(String[] args) throws IOException {
    	File f = new File("E:/Java/Test/src/encodingFile.txt");
    	File f2 = new File("E:/Java/Test/src/encodedFile.txt");
    	encodeFile(f, f2);
    }
}