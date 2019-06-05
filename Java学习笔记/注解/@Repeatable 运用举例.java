import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Younker
 *
 * 2019��6��3��
 * 
 * @Repeatable ���þ���
 * 
 * ��������ϰ��ϰ-�����ļ����� ����һ��Ҫ�󣬼������ļ���׺����.java���ļ������ǰѲ��ִ����޸�Ϊע�⣬
 * ����ʹ��@Repeatable ���Ԫע������ʾ���ļ���׺���ķ�Χ������java, html, css, js �ȵȡ�
 * Ϊ�˽����������ע����Ϊ�ڲ������ʽ����һ���ļ��
 * 1. ע��FileTypes����value()����һ��FileType����
 * 2. ע��FileType����@Repeatable��ֵ����FileTypes
 * 3. ����ע�⣺��work�������ظ�ʹ�ö��@FileTypeע��
 * 4. ����ע�⣺ ��work�����ڣ�ͨ�������ȡ���������ϵ�FileType���͵�ע�����飬Ȼ�����������
 */
public class FindFiles {
	@Target(METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface FileTypes {
		FileType[] value();
	}
	
	@Target(METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(FileTypes.class)
	public @interface FileType {
		String value();
	}
	
	@FileType(".java")
	@FileType(".html")
	@FileType(".css")
	@FileType(".js")
	public void work() {
		try {
			FileType[] fileTypes = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
			System.out.println("�������º�׺�����ļ��в����ļ�����");
			for (FileType fileType : fileTypes) {
				System.out.println(fileType.value());
			}
			System.out.println("���ҹ����ԡ�����");

		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FindFiles().work();
	}

}
