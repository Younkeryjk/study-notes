package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��24��
 * 
 * ��ʱ��ͣ��ǰ�߳�
 */
public class TestThread {

	public static void main(String[] args) {
		final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        gareen.damage = 50;
  
        final Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;
          
        final Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;
          
        final Hero leesin = new Hero();
        leesin.name = "äɮ";
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
