import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author Younker
 * 
 * 2019��5��7��
 * 
 * ���Ͽ�ܼ���Set��HashSet LinkedHashSet TreeSet
 * ˳��
 * HashSet ����
 * LinkedHashSet ���ղ���˳��
 * TreeSet ��С��������
 */
public class Test {
	
	public static void main(String[] args) {
		/*HashSet<Integer> numberSet1 = new HashSet<>();
		numberSet1.add(88);
		numberSet1.add(8);
		numberSet1.add(888);
		System.out.println(numberSet1);
		
		LinkedHashSet<Integer> numberSet2 = new LinkedHashSet<>();
		numberSet2.add(88);
		numberSet2.add(8);
		numberSet2.add(888);
		System.out.println(numberSet2);
		
		TreeSet<Integer> numberSet3 = new TreeSet<>();
		numberSet3.add(88);
		numberSet3.add(8);
		numberSet3.add(888);
		System.out.println(numberSet3);*/
		
		double pi = Math.PI;
		String strPi = Double.toString(pi);
		LinkedHashSet<Character> lhs = new LinkedHashSet<>();
		for (int i = 0; i < strPi.length(); i++) {
			if (1 == i) continue;
			lhs.add(strPi.charAt(i));
		}
		System.out.println(lhs);
	}

}