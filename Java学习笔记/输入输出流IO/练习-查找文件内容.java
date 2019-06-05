import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*
  * public static void search(File folder, String search);
  * 假设你的项目目录是 e:/project，遍历这个目录下所有的java文件（包括子文件夹），
  * 找出文件内容包括 Magic的那些文件，并打印出来。
*/
public class 查找文件内容 {
	/**
	 * @param file
	 *            查找的目录
	 * @param search
	 *            查找的字符串
	 */
	public static void search(File file, String search) {
		if (file.isFile()) {
			if (file.getName().toLowerCase().endsWith(".java")) {
				String fileContent = readFileConent(file);
				if (fileContent.contains(search)) {
					System.out.printf("找到子目标字符串%s,在文件:%s%n", search, file);
				}
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
		File folder = new File("e:\\project");
		search(folder, "Magic");
	}
}