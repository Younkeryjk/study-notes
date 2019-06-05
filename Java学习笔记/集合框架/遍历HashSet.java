import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * 遍历HashSet
 */
public class Test {
    public static void main(String[] args) {
    	HashSet<Integer> numbers = new HashSet<>();
    	for (int i = 0; i < 20; i++) {
			numbers.add(i);
		}
    	/*方法一：
    	 * for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
            Integer i = (Integer) iterator.next();
            System.out.println(i);
        }*/
    	//方法二：
    	for (Integer num : numbers) {
			System.out.println(num);
		}
    }
}