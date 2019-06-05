package collection;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * �Զ���MyHashMap
 * 
 * 	����ǰ��ѧϰ��hashcode��ԭ����Զ���hashcode, ���һ��MyHashMap��ʵ�ֽӿ�IHashMap

	MyHashMap�ڲ���һ��������2000�Ķ�������ʵ�֡�
	
	���put(String key,Object value)����
	����ͨ����һ���Զ����ַ�����hashcode��ϰ��ȡ�����ַ�����hashcode,Ȼ������hashcode��Ϊ�±꣬��λ�������ָ��λ�á� 
	�����λ��û�����ݣ�����ַ����Ͷ�����ϳɼ�ֵ��Entry���ٴ���һ��LinkedList���Ѽ�ֵ�ԣ��Ž�LinkedList�У�����LinkedList ���������λ�á�
	�����λ�������ݣ�һ����һ��LinkedList,����ַ����Ͷ�����ϳɼ�ֵ��Entry�����뵽LinkedList���档
	
	��� Object get(String key) ����
	����ͨ����һ���Զ����ַ�����hashcode��ϰ��ȡ�����ַ�����hashcode,Ȼ������hashcode��Ϊ�±꣬��λ�������ָ��λ�á� 
	������λ��û�����ݣ��򷵻ؿ�
	������λ�������ݣ��򰤸��Ƚ����м�ֵ�Եļ�-�ַ������Ƿ�equals���ҵ�ƥ��ģ��Ѽ�ֵ�Ե�ֵ�����س�ȥ���Ҳ���ƥ��ģ��ͷ��ؿ�
 */
public class MyHashMap implements IHashMap {
	Object[] objArr = new Object[2000];
	@Override
	public void put(String key, Object object) {
		int hCode = hashCode(key);
		if (null == objArr[hCode]) {
			Entry e = new Entry(key, object);
			LinkedList<Entry> ll = new LinkedList<>();
			ll.add(e);
			objArr[hCode] = ll;
		} else {
			LinkedList<Entry> ll = (LinkedList<Entry>)objArr[hCode];
			Entry e = new Entry(key, object);
			ll.add(e);
		}
	}

	@Override
	public Object get(String key) {
		int hCode = hashCode(key);
		if (null == objArr[hCode])
			return null;
		LinkedList<Entry> ll = (LinkedList<Entry>)objArr[hCode];
		for (int i = 0; i < ll.size(); i++) {
			Entry e = ll.get(i);
			if (key.equals(e.key)) {
				return e.value;
			}
		}
		return null;
	}
	
	public static int hashCode(String str) {
		if (0 == str.length()) {
			return 0;
		}
		int sum = 0;
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i);
		}
		res = sum * 23;
		if (res > 0) {
			res = res % 2000;
		} else {
			res = Math.abs(res);
        }
		return res;
	}
	
	public static void main(String[] args) {
		MyHashMap mhm = new MyHashMap();
        mhm.put("a", "A");
        mhm.put("b", "B");
        mhm.put("c", "C");
        mhm.put("d", "D1");
        mhm.put("d", "D2");
        System.out.println("--------------------------");
        System.out.println(mhm.get("a"));
        System.out.println(mhm.get("b"));
        System.out.println(mhm.get("c"));
        System.out.println(mhm.get("d"));
        System.out.println(mhm.get("e"));
	}
	
}
