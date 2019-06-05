import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.attribute.HashPrintJobAttributeSet;

import org.omg.Messaging.SyncScopeHelper;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月15日
 * 
 * 传统方式与聚合操作方式遍历数据
 */
public class Test {

    public static void main(String args[]) {
    	Random r = new Random();
    	List<Hero> heros = new ArrayList<>();

    	for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
    	System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");
        System.out.println("通过传统操作方式找出满足条件的数据：");
        for (Hero hero : heros) {
			if (hero.hp > 100 && hero.damage < 50) {
				System.out.println(hero.name);
			}
		}
        System.out.println("通过聚合操作方式找出满足条件的数据：");
        heros.stream().filter(h -> h.hp > 100 && h.damage < 50).forEach(h -> System.out.println(h.name));
    }
}