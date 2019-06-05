import java.lang.reflect.Field;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月31日
 * 
 * 通过反射修改属性的值
 */
public class Test {
	
    public static void main(String[] args) {
    	Hero h = new Hero();
    	//使用传统方式修改name的值为garen
    	h.name ="gareen";
    	try {
    		//获取类Hero的名字叫做name的字段
			Field f1 = h.getClass().getDeclaredField("name");
			//修改这个字段的值
			f1.set(h, "teemo");
			System.out.println(h.name);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}