import java.lang.reflect.Field;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��31��
 * 
 * ͨ�������޸����Ե�ֵ
 */
public class Test {
	
    public static void main(String[] args) {
    	Hero h = new Hero();
    	//ʹ�ô�ͳ��ʽ�޸�name��ֵΪgaren
    	h.name ="gareen";
    	try {
    		//��ȡ��Hero�����ֽ���name���ֶ�
			Field f1 = h.getClass().getDeclaredField("name");
			//�޸�����ֶε�ֵ
			f1.set(h, "teemo");
			System.out.println(h.name);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}