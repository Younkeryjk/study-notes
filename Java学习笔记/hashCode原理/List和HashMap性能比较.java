import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 * 
 * 2019��5��7��
 * 
 * List���ҵĵ�Ч��
 * HashMap�����ܱ���
 */
public class Test {
	
	public static void main(String[] args) {
		/*List���ҵĵ�Ч��
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
					System.out.println("�ҵ��� hero!" );
                    break;
				}
			}
			long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("һ�����ˣ�" + elapsed + " ����");
		}*/
		
		/*HashMap�����ܱ���
		 * HashMap<String, Hero> heros = new HashMap<>();
		for (int i = 0; i < 2000000; i++) {
			Hero h = new Hero("Hero " + i);
			heros.put(h.name, h);
		}
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			Hero target = heros.get("Hero 1000000");
			System.out.println("�ҵ��� hero!" + target.name);
			long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("һ�����ˣ�" + elapsed + " ����");
		}*/
		
	}

}