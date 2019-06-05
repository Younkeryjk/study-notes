package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 临时暂停当前线程
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
        			Thread.yield();
        			gareen.attackHero(teemo);
        		}
        	}
        };
        
        Thread t2 = new Thread() {
        	public void run() {
        		while (!leesin.isDead()) {
        			bh.attackHero(leesin);
        		}
        	}
        };
        
        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();
	}

}
