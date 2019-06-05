package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 不使用多线程
 */
public class TestThread0 {
	public static void main(String[] args) {
		Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.hp = 616;
		gareen.damage = 50;
		
		Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
        
        while (!teemo.isDead()) {
        	gareen.attackHero(teemo);
        }
        
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }
	}

}
