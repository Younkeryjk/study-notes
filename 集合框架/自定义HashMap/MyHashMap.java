package collection;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Younker
 *
 * 2019年5月22日
 * 
 * 自定义MyHashMap
 * 
 * 	根据前面学习的hashcode的原理和自定义hashcode, 设计一个MyHashMap，实现接口IHashMap

	MyHashMap内部由一个长度是2000的对象数组实现。
	
	设计put(String key,Object value)方法
	首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。 
	如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，把键值对，放进LinkedList中，最后把LinkedList 保存在这个位置。
	如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面。
	
	设计 Object get(String key) 方法
	首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。 
	如果这个位置没有数据，则返回空
	如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
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
