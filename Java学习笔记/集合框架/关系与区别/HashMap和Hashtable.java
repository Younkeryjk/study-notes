import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Younker
 * 
 * 2019��5��7��
 * 
 * HashMap��Hashtable������
 *
 * ����
 * 1��HashMap���Դ��null��Hashtable���ܴ��null
 * 2��HashMap�����̰߳�ȫ��Hashtable���̰߳�ȫ
 * 
 * ��ϰ����ϰ-��תkey��value
 */
public class Test {
	
	public static void main(String[] args) {
		/*HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put(null, "123");
		hashMap.put("123", null);
		
		Hashtable<String, String> hashtable = new Hashtable<>();
		//���� hashtable.put(null, "123");
        //���� hashtable.put("123", null);*/
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("adc", "����Ӣ��");
		hm.put("apc", "ħ��Ӣ��");
		hm.put("t", "̹��");
		System.out.println(hm);
		
		HashMap<String, String> hm2 = new HashMap<>();
		for (String k : hm.keySet()) {
			hm2.put(hm.get(k), k);
		}
		System.out.println(hm2);
	}

}