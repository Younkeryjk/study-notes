import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.attribute.HashPrintJobAttributeSet;

import org.omg.Messaging.SyncScopeHelper;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��15��
 * 
 * ��ͳ��ʽ��ۺϲ�����ʽ��������
 */
public class Test {

    public static void main(String args[]) {
    	Random r = new Random();
    	List<Hero> heros = new ArrayList<>();

    	for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
    	System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
        System.out.println("ɸѡ�� hp>100 && damange<50��Ӣ��");
        System.out.println("ͨ����ͳ������ʽ�ҳ��������������ݣ�");
        for (Hero hero : heros) {
			if (hero.hp > 100 && hero.damage < 50) {
				System.out.println(hero.name);
			}
		}
        System.out.println("ͨ���ۺϲ�����ʽ�ҳ��������������ݣ�");
        heros.stream().filter(h -> h.hp > 100 && h.damage < 50).forEach(h -> System.out.println(h.name));
    }
}