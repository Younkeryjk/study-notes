import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * 准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
	hero-3229
	hero-6232
	hero-9365
	...
	
	因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
	要求使用两种办法来寻找
	1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
	2. 借助HashMap，找出结果，并统计花费的时间
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
    	System.out.println("一共有"+count+"个hero-5555");
    	System.out.printf("使用for循环花费时间：%d", end - start);
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
    	System.out.println("一共有"+resuList.size()+"个hero-5555");
    	System.out.println("使用HashMap花费时间："+ (end - start));
    }
}