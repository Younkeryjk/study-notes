import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * 	List���ҵĵ�Ч��
 * 
 * 	������List�д�������ظ����ƣ�û��˳���2000000��Hero
	Ҫ�����ֽ�����hero 1000000���Ķ����ҳ���
	List�������Ƕ�ÿһ�����а���������ֱ���ҵ����ֽ�����hero 1000000����Ӣ�ۡ�
	��������£���Ҫ�����ͱȽ�2000000�Σ������ҵ���Ӧ��Ӣ�ۡ�
	�����߼���
	1. ��ʼ��2000000������ArrayList��
	2. ���������е�����˳��
	3. ����10�β�ѯ��ͳ��ÿһ�����ĵ�ʱ��
 */
public class Test {
    public static void main(String[] args) {
    	 List<Hero> heros = new ArrayList<Hero>();
         
         for (int j = 0; j < 2000000; j++) {
             Hero h = new Hero("Hero " + j);
             heros.add(h);
         }
             
         // ����10�β��ң��۲�����ƽ��ֵ
         for (int i = 0; i < 10; i++) {
             // ����heros��Ԫ�ص�˳��
             Collections.shuffle(heros);
              
             long start = System.currentTimeMillis();
      
             String target = "Hero 1000000";
      
             for (Hero hero : heros) {
                 if (hero.name.equals(target)) {
                     System.out.println("�ҵ��� hero!" );
                     break;
                 }
             }
             long end = System.currentTimeMillis();
             long elapsed = end - start;
             System.out.println("һ�����ˣ�" + elapsed + " ����");
         }
    }
}