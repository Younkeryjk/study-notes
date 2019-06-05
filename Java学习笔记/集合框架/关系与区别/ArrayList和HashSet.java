import java.util.HashSet;

/**
 * @author Younker
 * 
 * 2019年5月7日
 * 
 * ArrayList和HashSet的区别
 * 
 * 区别：
 * 1、是否有顺序：ArrayList有顺序、HashSet无顺序
 * 2、是否能重复：ArrayList可重复、HashSet不可重复
 * 
 * 练习：生成50个 0-9999之间的随机数，要求不能有重复的
 */
public class Test {

    public static void main(String[] args) {
    	HashSet<Integer> hs = new HashSet<>();
    	//方法一：
    	while (hs.size() < 50) {
    		hs.add((int)(Math.random() * 10000));
		}
    	//方法二：
    	/*for (int i = 0; i < 50; i++) {
        	if (!hs.add((int)(Math.random() * 100))) {
        		i--;
        	}
		}*/
    	int count = 0;
    	for (Integer integer : hs) {
    		count++;
			System.out.println(count + "---" + integer);
		}
       
    }
}