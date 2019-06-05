import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charactor.Hero;
import lambda.HeroChecker;
/**
 * @author Younker
 *
 * 2019年5月15日
 * 
 * 筛选出满足hp>100 && damage<50条件的数据
 * 方法一：普通方法
 * 方法二：匿名类方式
 * 方法三：lambda方式
 * 方法四：在Lambda表达式中使用静态方法
 * 方法五：直接引用静态方法
 */
public class Test {
	/*
	 * 方法一：普通方法
	 */
	private static void filter(List<Hero> heros) {
		for (Hero hero : heros) {
			if (hero.hp > 100 && hero.damage < 50) {
				System.out.println(hero.toString());
			}
		}
	}
	/*
	 * 方法二：匿名类方式
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
    	System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");
        //filter(heros);//方法一：普通方法
        
        
        /* 方法二：匿名类方式
         * HeroChecker checker = new HeroChecker() {
			@Override
			public boolean test(Hero h) {
				// TODO Auto-generated method stub
				return (h.hp > 100 && h.damage < 50);
			}
		};
		filter(heros, checker);*/
        
        //方法三：Lambda方式
        filter(heros, h -> h.hp > 100 && h.damage < 50);

		//方法四：在Lambda表达式中使用静态方法
        filter(heros, h -> Test.testHero(h) );
		
		//方法五：直接引用静态方法
        filter(heros, Test::testHero);
		
		//方法六：引用对象方法
		TestLambda testLambda = new TestLambda();
		filter(heros, testLambda::testHero);

		//方法七：在Lambda表达式中调用容器中的对象Hero的方法matched
		filter(heros,h-> h.matched() );
		
		//方法八：直接调用容器中的对象Hero的方法matched
		filter(heros, Hero::matched);
    }
}