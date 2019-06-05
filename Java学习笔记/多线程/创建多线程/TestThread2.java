package multiplethread;

import charactor.Hero;

public class TestThread2 {

	public static void main(String[] args) {
		 Hero gareen = new Hero();
	        gareen.name = "¸ÇÂ×";
	        gareen.hp = 616;
	        gareen.damage = 50;
	 
	        Hero teemo = new Hero();
	        teemo.name = "ÌáÄª";
	        teemo.hp = 300;
	        teemo.damage = 30;
	         
	        Hero bh = new Hero();
	        bh.name = "ÉÍ½ğÁÔÈË";
	        bh.hp = 500;
	        bh.damage = 65;
	         
	        Hero leesin = new Hero();
	        leesin.name = "Ã¤É®";
	        leesin.hp = 455;
	        leesin.damage = 80;
	        
	        KillThread2 k2 = new KillThread2(gareen, teemo);
	        new Thread(k2).start();
	        
	        KillThread2 k22 = new KillThread2(bh, leesin);
	        new Thread(k22).start();
	}

}
