import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import property.Item;

/**
 * @author Younker
 *
 * 2019��5��23��
 * 
 * ��ϰ-Comparable
 * 
 * ����Comparable�ӿڣ�ʹItem�߱����ռ۸�Ӹߵ�������
 * ��ʼ��10��Item,������Collections.sort�������򣬲鿴������
 */
public class Test {
	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			items.add(new Item("item " + i, r.nextInt(100)));
		}
		System.out.println("��ʼ����Item��Ʒ��");
		System.out.println(items);
		Collections.sort(items);
		System.out.println("�ź����Items����Ϊ��");
		System.out.println(items);
	}
}
