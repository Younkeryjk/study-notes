import java.util.ArrayList;
import java.util.List;

import charactor.ADHero;
import charactor.APHero;
import charactor.Hero;
import property.Item;

/**
 * @author Younker
 *
 * 2019年5月23日
 * 
 * 练习- ? extends
 * 如代码所示，为了遍历不同泛型的3种集合，需要设计3个方法
 * 借助? extends， 把代码减肥到只是用一种方法
 */
public class Test {
	public static void iterate(ArrayList<? extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }
	public static void main(String[] args) {
		ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();
        hs.add(new Hero("hero1"));
        hs.add(new Hero("hero2"));
        aphs.add(new APHero("aphero 1"));
        aphs.add(new APHero("aphero 2"));
        adhs.add(new ADHero("adhero 1"));
        adhs.add(new ADHero("adhero 2"));
        iterate(hs);
        iterate(aphs);
        iterate(adhs);
	}
}
