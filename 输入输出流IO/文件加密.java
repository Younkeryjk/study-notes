import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * �ļ�����
 * ����������а�encodingFile�����ݽ��м��ܣ�Ȼ�󱣴浽encodedFile�ļ��С�
 * �����㷨�� 
 * 	���֣�
 * 		�������9�����֣���ԭ���Ļ����ϼ�1������5���6, 3���4
 * 		�����9�����֣����0
 * 	��ĸ�ַ���
 * 		����Ƿ�z�ַ��������ƶ�һ��������d���e, G���H
 * 		�����z��z->a, Z-A��
 * 		�ַ���Ҫ������Сд
 * 	����ĸ�ַ�
 * 		����',&^ �������䣬����Ҳ��������
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