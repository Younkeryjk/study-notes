import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * ��תHashMap��key��value
 */
public class Test {
	
    public static void main(String[] args) {
    	HashMap<String, String> hm = new HashMap<>();
    	hm.put("adc", "����Ӣ��");
    	hm.put("apc", "ħ��Ӣ��");
    	hm.put("t", "̹��");
    	
    	HashMap<String, String> newHm = new HashMap<>();
    	for (String key : hm.keySet()) {
			newHm.put(hm.get(key), key);
		}
    	System.out.println(newHm);
    }
}