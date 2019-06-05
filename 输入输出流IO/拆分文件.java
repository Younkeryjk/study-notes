import java.awt.event.FocusAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019��5��17��
 * 
 * ����ļ�
 * �ҵ�һ������100k���ļ�������100kΪ��λ����ֳɶ�����ļ��������Ա����Ϊ�ļ���������
 * �����ļ� eclipse.exe����С��309k��
 * ���֮�󣬳�Ϊ 
 * eclipse.exe-0
 * eclipse.exe-1
 * eclipse.exe-2
 * eclipse.exe-3
 */
public class Test {

    public static void main(String[] args) throws IOException {
    	String filePath = "E:/Java/Test/src/split.txt";
        File f = new File(filePath);
        long fileLength = f.length();
        int aFileLenth = 1024 * 100;
        int fileNum = (int)(fileLength / aFileLenth);
        fileNum = fileLength % aFileLenth == 0 ? fileNum : fileNum + 1;
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = null;
        for (int i = 0; i < fileNum; i++) {
        	if (i == fileNum - 1) {
        		aFileLenth = (int)(fileLength - (aFileLenth * (fileNum - 1)));
        	}
        	byte[] b = new byte[aFileLenth];
            fis.read(b);
            String newFilePath = filePath+"-"+i;
            fos = new FileOutputStream(newFilePath);
            fos.write(b);
		}
        fis.close();
        fos.close();
    }
}