import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Younker
 *
 * 2019��5��23��
 * 
 * ���̲߳����ļ�����
 * 
 * �� ��ϰ-�����ļ����� ��Ϊ���̲߳����ļ�����
 * ԭ��ϰ��˼·�Ǳ��������ļ������������ļ��� .java��ʱ�򣬲�������ļ������ݣ��������֮���ٱ�����һ���ļ�
 * ����ͨ�����̵߳������˼·��
 * ���������ļ������������ļ���.java��ʱ�򣬴���һ���߳�ȥ��������ļ������ݣ����صȴ�����߳̽���������������һ���ļ�
 * 
 */
public class Test {
	public static void search(File file, String search) {
		if (file.isFile()) {
			if (file.getName().toLowerCase().endsWith(".java")) {
				new Thread() {
					public void run() {
						String fileContent = readFileConent(file);
						if (fileContent.contains(search)) {
							System.out.printf("�ҵ���Ŀ���ַ���%s,���ļ�:%s%n", search, file);
						}
					}
				}.start();
			}
		}
		if (file.isDirectory()) {
			File[] fs = file.listFiles();
			for (File f : fs) {
				search(f, search);
			}
		}
	}

	public static String readFileConent(File file) {
		try (FileReader fr = new FileReader(file)) {
			char[] all = new char[(int) file.length()];
			fr.read(all);
			return new String(all);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		File folder = new File("E:\\Java\\Test\\src");
		search(folder, "Thread");
	}
}
