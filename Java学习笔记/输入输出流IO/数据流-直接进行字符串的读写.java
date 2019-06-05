import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Younker
 *
 * 2019年5月20日
 * 
 * 数据流-直接进行字符串的读写
 * 
 */
public class Test {
	public static void write(File f) {
		try (
				FileOutputStream fos = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fos);
			) {
			dos.writeBoolean(true);
			dos.writeInt(300);
			dos.writeUTF("123 this is gareen");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void read(File f) {
		try (
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);
			) {
			boolean b = dis.readBoolean();
			int i = dis.readInt();
            String str = dis.readUTF();
             
            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
    	File f = new File("E:/Java/Test/src/dataOutputStream.txt");
    	write(f);
    	read(f);
    }
}