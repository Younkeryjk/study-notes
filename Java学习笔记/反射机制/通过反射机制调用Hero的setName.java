import java.lang.reflect.Field;
import java.lang.reflect.Method;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月31日
 * 
 * 通过反射机制调用Hero的setName
 */
public class Test {
	
    public static void main(String[] args) {
    	Hero h = new Hero();
    	try {
    		//获取这个名字叫setName，参数类型是String的方法
			Method m = h.getClass().getMethod("setName", String.class);
			//对h对象，调用这个方法
			m.invoke(h, "盖伦");
			//使用传统的方式，调用getName方法
			System.out.println(h.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}