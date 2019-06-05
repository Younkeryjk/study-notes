import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import charactor.Hero;
import charactor.HeroItem;
import property.Item;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * 遍历集合
 */
public class Test {
    public static void main(String[] args) {
    	 List<Hero> heros = new ArrayList<Hero>();
         // 放5个Hero进入容器
         for (int i = 0; i < 5; i++) {
             heros.add(new Hero("hero name " + i));
         }
         //方法一：
         /*for (int i = 0; i < heros.size(); i++) {
			System.out.println(heros.get(i));
         }*/
         //方法二：
         /*Iterator<Hero> it = heros.iterator();
         while(it.hasNext()) {
        	 System.out.println(it.next());
         }*/
         //方法三：
         /*for (Iterator<Hero> it = heros.iterator();it.hasNext();) {
			System.out.println(it.next());
         }*/
         //方法四：
        for (Hero hero : heros) {
        	 System.out.println(hero);
		}
    }
}