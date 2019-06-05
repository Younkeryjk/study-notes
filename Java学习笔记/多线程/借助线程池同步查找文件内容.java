import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Younker
 *
 * 2019年5月28日
 * 
 * 练习- 借助线程池同步查找文件内容
 * 
 * 在 练习-同步查找文件内容 ，如果文件特别多，就会创建很多的线程。 改写这个练习，使用线程池的方式来完成。
 * 初始化一个大小是10的线程池
 * 遍历所有文件，当遍历到文件是.java的时候，创建一个查找文件的任务，把这个任务扔进线程池去执行，继续遍历下一个文件
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
							System.out.printf("找到子目标字符串%s,在文件:%s%n", search, file);
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
