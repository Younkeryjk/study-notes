import java.util.HashMap;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * HashMap的键值对
 */
public class Test {
    public static void main(String[] args) {
    	HashMap<String, String> dictionary = new HashMap<>();
    	dictionary.put("adc", "物理英雄");
    	dictionary.put("apc", "魔法英雄");
        dictionary.put("t", "坦克");
        System.out.println(dictionary.get("t"));
    }
}