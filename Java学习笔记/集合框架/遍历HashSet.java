import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * ����HashSet
 */
public class Test {
    public static void main(String[] args) {
    	HashSet<Integer> numbers = new HashSet<>();
    	for (int i = 0; i < 20; i++) {
			numbers.add(i);
		}
    	/*����һ��
    	 * for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
            Integer i = (Integer) iterator.next();
            System.out.println(i);
        }*/
    	//��������
    	for (Integer num : numbers) {
			System.out.println(num);
		}
    }
}