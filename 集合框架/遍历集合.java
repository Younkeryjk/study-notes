import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import charactor.Hero;
import charactor.HeroItem;
import property.Item;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * ��������
 */
public class Test {
    public static void main(String[] args) {
    	 List<Hero> heros = new ArrayList<Hero>();
         // ��5��Hero��������
         for (int i = 0; i < 5; i++) {
             heros.add(new Hero("hero name " + i));
         }
         //����һ��
         /*for (int i = 0; i < heros.size(); i++) {
			System.out.println(heros.get(i));
         }*/
         //��������
         /*Iterator<Hero> it = heros.iterator();
         while(it.hasNext()) {
        	 System.out.println(it.next());
         }*/
         //��������
         /*for (Iterator<Hero> it = heros.iterator();it.hasNext();) {
			System.out.println(it.next());
         }*/
         //�����ģ�
        for (Hero hero : heros) {
        	 System.out.println(hero);
		}
    }
}