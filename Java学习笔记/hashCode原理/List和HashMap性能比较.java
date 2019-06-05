import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 * 
 * 2019年5月7日
 * 
 * List查找的低效率
 * HashMap的性能表现
 */
public class Test {
	
	public static void main(String[] args) {
		/*List查找的低效率
		 * List<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 2000000; i++) {
			Hero h = new Hero("Hero " + i);
			heros.add(h);
		}
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(heros);
			long start = System.currentTimeMillis();
			String target = "Hero 1000000";
			
			for (Hero hero : heros) {
				if (hero.name.equals(target)) {
					System.out.println("找到了 hero!" );
                    break;
				}
			}
			long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("一共花了：" + elapsed + " 毫秒");
		}*/
		
		/*HashMap的性能表现
		 * HashMap<String, Hero> heros = new HashMap<>();
		for (int i = 0; i < 2000000; i++) {
			Hero h = new Hero("Hero " + i);
			heros.put(h.name, h);
		}
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			Hero target = heros.get("Hero 1000000");
			System.out.println("找到了 hero!" + target.name);
			long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("一共花了：" + elapsed + " 毫秒");
		}*/
		
	}

}