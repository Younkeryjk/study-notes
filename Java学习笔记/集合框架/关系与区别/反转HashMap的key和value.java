import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Younker
 *
 * 2019年5月22日
 * 
 * 反转HashMap的key和value
 */
public class Test {
	
    public static void main(String[] args) {
    	HashMap<String, String> hm = new HashMap<>();
    	hm.put("adc", "物理英雄");
    	hm.put("apc", "魔法英雄");
    	hm.put("t", "坦克");
    	
    	HashMap<String, String> newHm = new HashMap<>();
    	for (String key : hm.keySet()) {
			newHm.put(hm.get(key), key);
		}
    	System.out.println(newHm);
    }
}