import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * Comparator
 * 
 * 	����Hero���������� name,hp,damage
	һ�������зŴ��10��Hero,ͨ��Collections.sort����10����������
	��ô������hpС�ķ�ǰ�棿����damageС�ķ�ǰ�棿Collections.sortҲ�޷�ȷ��
	����Ҫָ�����װ����������Խ�������
	�������Ҫ�ṩһ��Comparator������ν�����������֮��Ĵ�С�Ƚ�
 */
public class Test {
    public static void main(String[] args) {
    	Random r =new Random();
        List<Hero> heros = new ArrayList<Hero>();
            
        for (int i = 0; i < 10; i++) {
            //ͨ�����ֵʵ����hero��hp��damage
            heros.add(new Hero("hero "+ i, r.nextInt(100), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ��ϣ�");
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
		System.out.println("����Ѫ�������ļ��ϣ�");
        System.out.println(heros);
    }
}
