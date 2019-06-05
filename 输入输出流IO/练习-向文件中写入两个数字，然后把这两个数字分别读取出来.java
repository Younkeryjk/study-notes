import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Younker
 *
 * 2019��5��20��
 * 
 * ��ϰ-���ļ���д���������֣�Ȼ������������ֱַ��ȡ����
 * 
 */
public class Test {
	public static void dataPutStream(File f) {
		try (
				FileOutputStream fos = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fos);
			) {
			dos.writeInt(31);
			dos.writeInt(15);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);
			) {
			int first = dis.readInt();
			int second = dis.readInt();
			System.out.println("��һ����"+first);
			System.out.println("�ڶ�����"+second);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void buffer(File f) {
		try (
				FileWriter fw = new	FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
			) {
			pw.print("31");
			pw.print("@");
			pw.print("15");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (
				FileReader fr = new	FileReader(f);
				BufferedReader br = new BufferedReader(fr);
			) {
			String str = br.readLine();
			if (null == str)
				return;
			String[] strArr = str.split("@");
			for(int i=0; i<strArr.length; i++) {
				int num = Integer.parseInt(strArr[i]);
                System.out.println("the number is: "+num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/dataOutputStream.txt");
    	//dataPutStream(f);
    	buffer(f);
    }
}