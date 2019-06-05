import java.util.HashMap;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月22日
 * 
 * 	HashMap的性能表现
 * 
 * 	假设在HashMap中存放着无重复名称，没有顺序的2000000个Hero
	要把名字叫做“hero 1000000”的对象找出来
	测试逻辑：
	1. 初始化2000000个对象到HashMap中。
	2. 进行10次查询
	3. 统计每一次的查询消耗的时间
 */
public class Test {
    public static void main(String[] args) {
    	HashMap<String, Hero> hm = new HashMap<>();
    	for (int i = 0; i < 2000000; i++) {
    		Hero h = new Hero("hero "+i);
			hm.put(h.name, h);
		}
    	for (int i = 0; i < 10; i++) {
    		long start = System.currentTimeMillis();
			if (null != hm.get("hero 1000000")) {
				System.out.println("找到了hero!");
			}
			long end = System.currentTimeMillis();
			System.out.printf("第%d次花了：%d 毫秒", i+1, end-start);
			System.out.println();
		}
    }
}