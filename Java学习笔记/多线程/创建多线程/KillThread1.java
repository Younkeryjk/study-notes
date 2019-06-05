package multiplethread;

import charactor.Hero;

public class KillThread1 extends Thread {
	private Hero h1;
	private Hero h2;
	public KillThread1(Hero h1, Hero h2) {
		this.h1 = h1;
		this.h2 = h2;
	}
	public void run() {
		while (!h2.isDead()) {
			h1.attackHero(h2);
		}
	}

}
