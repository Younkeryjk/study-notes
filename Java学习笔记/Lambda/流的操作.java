import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月15日
 * 
 * 流的操作
 */
public class Test {

    public static void main(String args[]) {
    	Random r = new Random();
    	List<Hero> heros = new ArrayList<>();

    	for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
    	heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);
/*        System.out.println("满足条件hp>100&&damage<50的数据");
        heros
        .stream()
        .filter(h->h.hp>100&&h.damage<50)
        .forEach(h->System.out.print(h));*/

//			中间操作
//        System.out.println("去除重复的数据，去除标准是看equals");
//        heros.stream().distinct().forEach(h->System.out.println(h));
//        System.out.println("按照血量排序");
//        heros.stream().sorted((h1, h2) -> h1.hp > h2.hp ? 1 : -1).forEach(h->System.out.println(h));
//        System.out.println("保留3个");
//        heros.stream().limit(3).forEach(h->System.out.println(h));
//        System.out.println("忽略前3个"); 	
//        heros.stream().skip(3).forEach(h -> System.out.println(h));
//        System.out.println("转换为double的Stream");
//        heros.stream().mapToDouble(Hero::getHp).forEach(h->System.out.println(h));
//        System.out.println("转换任意类型的Stream");
//        heros.stream().map(h -> h.name + " - " + h.hp + " - " + h.damage).forEach(h -> System.out.println(h));


//			结束操作
//        System.out.println("返回一个数组");
//        Object[] hs = heros.stream().toArray();
//        System.out.println(Arrays.toString(hs));
//        System.out.println("返回伤害最低的那个英雄");
//        Hero minDamageHero = heros.stream().min((h1, h2) -> h1.damage - h2.damage).get();
//        System.out.print(minDamageHero);
//        System.out.println("返回伤害最高的那个英雄");
//        Hero maxDamageHero = heros.stream().max((h1, h2) -> h1.damage - h2.damage).get();
//        System.out.print(maxDamageHero);
//        System.out.println("流中数据的总数");
//        long count = heros.stream().count();
//        System.out.println(count);
        System.out.println("第一个英雄");
        Hero firstHero = heros.stream().findFirst().get();
        System.out.println(firstHero);
    }
}