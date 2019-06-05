import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Younker
 * 
 * 2019年5月7日
 * 
 * HashMap和Hashtable的区别
 *
 * 区别：
 * 1、HashMap可以存放null，Hashtable不能存放null
 * 2、HashMap不是线程安全，Hashtable是线程安全
 * 
 * 练习：练习-反转key和value
 */
public class Test {
	
	public static void main(String[] args) {
		/*HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put(null, "123");
		hashMap.put("123", null);
		
		Hashtable<String, String> hashtable = new Hashtable<>();
		//错误 hashtable.put(null, "123");
        //错误 hashtable.put("123", null);*/
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("adc", "物理英雄");
		hm.put("apc", "魔法英雄");
		hm.put("t", "坦克");
		System.out.println(hm);
		
		HashMap<String, String> hm2 = new HashMap<>();
		for (String k : hm.keySet()) {
			hm2.put(hm.get(k), k);
		}
		System.out.println(hm2);
	}

}