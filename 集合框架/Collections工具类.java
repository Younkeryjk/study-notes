import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * Collections������
 */
public class Test {
	/**
	 * ���ȳ�ʼ��һ��List,������10��ֵ��0-9��
	 * Ȼ�󲻶ϵ�shuffle��ֱ��ǰ3λ����
	 * 3 1 4
	 * shuffle 1000,000 �Σ�ͳ�Ƴ��ֵĸ���
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
		System.out.printf("ǰ��λ314������%d��", count);
		System.out.println();
		System.out.printf("ǰ��λ314�ĸ���Ϊ��%s%%",probability);
	}
    public static void main(String[] args) {
    	statisticsProbability();
    	/*List<Integer> numbers = new ArrayList<>();
    	for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
    	System.out.println("�����е�����:");
        System.out.println(numbers);*/
        //��ת
//        Collections.reverse(numbers);
//        System.out.println("��ת�󼯺��е�����:");
//        System.out.println(numbers);
        //����
//        Collections.shuffle(numbers);
//        System.out.println("�����󼯺��е�����:");
//        System.out.println(numbers);
        //����
//        Collections.shuffle(numbers);
//        System.out.println("�����󼯺��е�����:");
//        System.out.println(numbers);
//        Collections.sort(numbers);
//        System.out.println("����󼯺��е�����:");
//        System.out.println(numbers);
        //����
//        Collections.swap(numbers, 0, 5);
//        System.out.println("����0��5�±�����ݺ󣬼����е�����:");
//        System.out.println(numbers);
        //����
//        Collections.rotate(numbers, 2);
//        System.out.println("�Ѽ������ҹ���2����λ��������ݺ󣬼����е�����:");
//        System.out.println(numbers);
        //�̰߳�ȫ��
//        System.out.println("�ѷ��̰߳�ȫ��Listת��Ϊ�̰߳�ȫ��List");
//        List<Integer> synchronizedNumbers = (List<Integer>)Collections.synchronizedList(numbers);
    }
}