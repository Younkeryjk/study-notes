import java.lang.reflect.Field;
import java.lang.reflect.Method;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��31��
 * 
 * ͨ��������Ƶ���Hero��setName
 */
public class Test {
	
    public static void main(String[] args) {
    	Hero h = new Hero();
    	try {
    		//��ȡ������ֽ�setName������������String�ķ���
			Method m = h.getClass().getMethod("setName", String.class);
			//��h���󣬵����������
			m.invoke(h, "����");
			//ʹ�ô�ͳ�ķ�ʽ������getName����
			System.out.println(h.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}