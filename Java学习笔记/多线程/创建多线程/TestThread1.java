package multiplethread;

import charactor.Hero;

public class TestThread1 {

	public static void main(String[] args) {
		Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "äɮ";
        leesin.hp = 455;
        leesin.damage = 80;
        
        KillThread1 killThread1 = new KillThread1(gareen, teemo);
        killThread1.start();
        KillThread1 killThread2 = new KillThread1(bh, leesin);
        killThread2.start();
	}

}
