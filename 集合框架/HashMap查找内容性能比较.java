import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * ׼��һ��ArrayList���д��3000000(�������)Hero�����������������,��ʽ��hero-[4λ�����]
	hero-3229
	hero-6232
	hero-9365
	...
	
	��Ϊ�����ܴ����Լ���ÿ�ֶ����ظ��������ֽ��� hero-5555�����ж����ҳ���
	Ҫ��ʹ�����ְ취��Ѱ��
	1. ��ʹ��HashMap��ֱ��ʹ��forѭ���ҳ�������ͳ�ƻ��ѵ�ʱ��
	2. ����HashMap���ҳ��������ͳ�ƻ��ѵ�ʱ��
 */
public class Test {
    public static void main(String[] args) {
    	List<Hero> heros = new ArrayList<>();
    	for (int i = 0; i < 3000000; i++) {
    		int randNum = (int)(Math.random() * 9000) + 1000;
			heros.add(new Hero("hero-" + randNum));
		}
    	int count=0;
    	long start = System.currentTimeMillis();
    	for (Hero hero : heros) {
			if (hero.toString().equals("hero-5555")) {
				count+=1;   
			}
		}
    	long end = System.currentTimeMillis();
    	System.out.println("һ����"+count+"��hero-5555");
    	System.out.printf("ʹ��forѭ������ʱ�䣺%d", end - start);
    	System.out.println();
    	System.out.println();
    	
    	HashMap<String, List<Hero>> heroMap = new HashMap<String, List<Hero>>();
        for (Hero hero : heros) {
            List<Hero> list = heroMap.get(hero.name);
            if (list==null) {
                list=new ArrayList<Hero>();
                heroMap.put(hero.name, list);
            }
            list.add(hero);
        }
    	start = System.currentTimeMillis();
    	List<Hero> resuList = heroMap.get("hero-5555");
    	end = System.currentTimeMillis();
    	System.out.println("һ����"+resuList.size()+"��hero-5555");
    	System.out.println("ʹ��HashMap����ʱ�䣺"+ (end - start));
    }
}