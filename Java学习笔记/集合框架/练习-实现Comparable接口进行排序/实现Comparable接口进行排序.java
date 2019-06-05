import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import property.Item;

/**
 * @author Younker
 *
 * 2019年5月23日
 * 
 * 练习-Comparable
 * 
 * 借助Comparable接口，使Item具备按照价格从高到低排序。
 * 初始化10个Item,并且用Collections.sort进行排序，查看排序结果
 */
public class Test {
	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			items.add(new Item("item " + i, r.nextInt(100)));
		}
		System.out.println("初始化的Item物品：");
		System.out.println(items);
		Collections.sort(items);
		System.out.println("排好序的Items集合为：");
		System.out.println(items);
	}
}
