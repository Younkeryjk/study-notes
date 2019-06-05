package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 加入到主线程中
 */
public class TestThread {

	public static void main(String[] args) {
		final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;
  
        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;
          
        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
          
        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
        Thread t1 = new Thread() {
        	public void run() {
        		while(!teemo.isDead()) {
        			gareen.attackHero(teemo);
        		}
        	}
        };
        t1.start();
        try {
			t1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
        Thread t2 = new Thread() {
        	public void run() {
        		while (!leesin.isDead()) {
        			bh.attackHero(leesin);
        		}
        	}
        };
        t2.start();
	}

}
