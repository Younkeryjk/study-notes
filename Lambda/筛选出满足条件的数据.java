import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charactor.Hero;
import lambda.HeroChecker;
/**
 * @author Younker
 *
 * 2019��5��15��
 * 
 * ɸѡ������hp>100 && damage<50����������
 * ����һ����ͨ����
 * �������������෽ʽ
 * ��������lambda��ʽ
 * �����ģ���Lambda���ʽ��ʹ�þ�̬����
 * �����壺ֱ�����þ�̬����
 */
public class Test {
	/*
	 * ����һ����ͨ����
	 */
	private static void filter(List<Hero> heros) {
		for (Hero hero : heros) {
			if (hero.hp > 100 && hero.damage < 50) {
				System.out.println(hero.toString());
			}
		}
	}
	/*
	 * �������������෽ʽ
	 * */
	
	private static void filter(List<Hero> heros, HeroChecker checker) {
		for (Hero hero : heros) {
			if (checker.test(hero)) {
				System.out.println(hero);
			}
		}
	}
	
    public static void main(String args[]) {
    	Random r = new Random();
    	List<Hero> heros = new ArrayList<>();
    	for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
    	System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
        System.out.println("ɸѡ�� hp>100 && damange<50��Ӣ��");
        //filter(heros);//����һ����ͨ����
        
        
        /* �������������෽ʽ
         * HeroChecker checker = new HeroChecker() {
			@Override
			public boolean test(Hero h) {
				// TODO Auto-generated method stub
				return (h.hp > 100 && h.damage < 50);
			}
		};
		filter(heros, checker);*/
        
        //��������Lambda��ʽ
        filter(heros, h -> h.hp > 100 && h.damage < 50);

		//�����ģ���Lambda���ʽ��ʹ�þ�̬����
        filter(heros, h -> Test.testHero(h) );
		
		//�����壺ֱ�����þ�̬����
        filter(heros, Test::testHero);
		
		//�����������ö��󷽷�
		TestLambda testLambda = new TestLambda();
		filter(heros, testLambda::testHero);

		//�����ߣ���Lambda���ʽ�е��������еĶ���Hero�ķ���matched
		filter(heros,h-> h.matched() );
		
		//�����ˣ�ֱ�ӵ��������еĶ���Hero�ķ���matched
		filter(heros, Hero::matched);
    }
}