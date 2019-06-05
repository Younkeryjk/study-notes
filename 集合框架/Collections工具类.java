import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Younker
 *
 * 2019年5月22日
 * 
 * Collections工具类
 */
public class Test {
	/**
	 * 首先初始化一个List,长度是10，值是0-9。
	 * 然后不断的shuffle，直到前3位出现
	 * 3 1 4
	 * shuffle 1000,000 次，统计出现的概率
	 */
	public static void statisticsProbability() {
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arr.add(i);
		}
		int count = 0;
		for (int i = 0; i < 1000000; i++) {
			Collections.shuffle(arr);
			if (3 == arr.get(0) && 1 == arr.get(1) && 4 == arr.get(2)) {
				count++;
			}
		}
		float probability = (float)count / 1000000 * 100;
		System.out.printf("前三位314出现了%d次", count);
		System.out.println();
		System.out.printf("前三位314的概率为：%s%%",probability);
	}
    public static void main(String[] args) {
    	statisticsProbability();
    	/*List<Integer> numbers = new ArrayList<>();
    	for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
    	System.out.println("集合中的数据:");
        System.out.println(numbers);*/
        //翻转
//        Collections.reverse(numbers);
//        System.out.println("翻转后集合中的数据:");
//        System.out.println(numbers);
        //混淆
//        Collections.shuffle(numbers);
//        System.out.println("混淆后集合中的数据:");
//        System.out.println(numbers);
        //排序
//        Collections.shuffle(numbers);
//        System.out.println("混淆后集合中的数据:");
//        System.out.println(numbers);
//        Collections.sort(numbers);
//        System.out.println("排序后集合中的数据:");
//        System.out.println(numbers);
        //交换
//        Collections.swap(numbers, 0, 5);
//        System.out.println("交换0和5下标的数据后，集合中的数据:");
//        System.out.println(numbers);
        //滚动
//        Collections.rotate(numbers, 2);
//        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
//        System.out.println(numbers);
        //线程安全化
//        System.out.println("把非线程安全的List转换为线程安全的List");
//        List<Integer> synchronizedNumbers = (List<Integer>)Collections.synchronizedList(numbers);
    }
}