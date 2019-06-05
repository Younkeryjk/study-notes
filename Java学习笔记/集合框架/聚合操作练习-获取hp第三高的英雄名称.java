import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��23��
 * 
 * �ۺϲ�����ϰ-��ȡhp�����ߵ�Ӣ������
 */
public class Test {
	public static void main(String[] args) {
		Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
 
        System.out.println("��ʼ�����Ϻ������ (���һ�������ظ�)��");
        System.out.println(heros);
		Collections.sort(heros, new Comparator<Hero>() {
        	public int compare(Hero h1, Hero h2) {
        		if (h1.hp < h2.hp)
        			return 1;
        		else
        			return -1;
        	}
		});
		Hero hero = heros.get(2);
        System.out.println("ͨ����ͳ��ʽ�ҳ�����hp�����ߵ�Ӣ��������:" + hero.name);
        
        String name = heros.stream().sorted((h1, h2)-> h1.hp < h2.hp ? 1 : -1).skip(2).map(h->h.name).findFirst().get();
        System.out.println("ͨ���ۺϲ����ҳ�����hp�����ߵ�Ӣ��������:" + name);
	}
}
