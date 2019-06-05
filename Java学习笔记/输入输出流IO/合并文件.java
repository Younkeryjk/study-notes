import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * �ϲ��ļ�
 */
public class Test {

    public static void main(String[] args) throws IOException {
    	File f = new File("E:/Java/Test/src/merge");
    	//����Ŀ¼�������ļ�����ȡ�ļ����ݣ�׷�ӵ����ļ�
    	File[] files = f.listFiles();
    	byte[] b;
    	FileInputStream fis;
    	File writeFile = new File("E:/Java/Test/src/merge/merge.txt");
    	FileOutputStream fos = new FileOutputStream(writeFile);
    	for (File file : files) {
    		int fileLen = (int)(file.length());
    		b = new byte[fileLen];
    		fis = new FileInputStream(file);
    		fis.read(b);
    		fos.write(b);
        	fis.close();
		}
    	fos.close();
    }
}