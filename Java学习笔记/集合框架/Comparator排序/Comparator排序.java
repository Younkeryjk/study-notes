import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月22日
 * 
 * Comparator
 * 
 * 	假设Hero有三个属性 name,hp,damage
	一个集合中放存放10个Hero,通过Collections.sort对这10个进行排序
	那么到底是hp小的放前面？还是damage小的放前面？Collections.sort也无法确定
	所以要指定到底按照哪种属性进行排序
	这里就需要提供一个Comparator给定如何进行两个对象之间的大小比较
 */
public class Test {
    public static void main(String[] args) {
    	Random r =new Random();
        List<Hero> heros = new ArrayList<Hero>();
            
        for (int i = 0; i < 10; i++) {
            //通过随机值实例化hero的hp和damage
            heros.add(new Hero("hero "+ i, r.nextInt(100), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        //Collections.sort(heros);
        Comparator<Hero> c = new Comparator<Hero>() {
        	public int compare(Hero h1, Hero h2) {
        		if (h1.hp > h2.hp)
        			return 1;
        		else
        			return -1;
        	}
		};
		Collections.sort(heros, c);
		System.out.println("按照血量排序后的集合：");
        System.out.println(heros);
    }
}
