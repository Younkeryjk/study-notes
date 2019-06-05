import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Younker
 *
 * 2019��5��28��
 * 
 * ��ϰ- �����̳߳�ͬ�������ļ�����
 * 
 * �� ��ϰ-ͬ�������ļ����� ������ļ��ر�࣬�ͻᴴ���ܶ���̡߳� ��д�����ϰ��ʹ���̳߳صķ�ʽ����ɡ�
 * ��ʼ��һ����С��10���̳߳�
 * ���������ļ������������ļ���.java��ʱ�򣬴���һ�������ļ������񣬰���������ӽ��̳߳�ȥִ�У�����������һ���ļ�
 */
public class Test {
	public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

	public static void search(File file, String search) {
		if (file.isFile()) {
			if (file.getName().toLowerCase().endsWith(".java")) {
				
				threadPool.execute(new Runnable() {
					
					@Override
					public void run() {
						String fileContent = readFileConent(file);
						if (fileContent.contains(search)) {
							System.out.printf("�ҵ���Ŀ���ַ���%s,���ļ�:%s%n", search, file);
						}
						
					}
				});
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
