import java.util.HashMap;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * HashMap�ļ�ֵ��
 */
public class Test {
    public static void main(String[] args) {
    	HashMap<String, String> dictionary = new HashMap<>();
    	dictionary.put("adc", "����Ӣ��");
    	dictionary.put("apc", "ħ��Ӣ��");
        dictionary.put("t", "̹��");
        System.out.println(dictionary.get("t"));
    }
}