package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 演示同步问题
 * 假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击
 * 就是有多个线程在减少盖伦的hp
 * 同时又有多个线程在恢复盖伦的hp
 * 假设线程的数量是一样的，并且每次改变的值都是1，那么所有线程结束后，盖伦应该还是10000滴血。
 * 但是。。。
 * 注意： 不是每一次运行都会看到错误的数据产生，多运行几次，或者增加运行的次数
 */
public class TestThread {

	public static void main(String[] args) {
		final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);
        int n = 10000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
        for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {
					gareen.recover();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			};
			t.start();
			addThreads[i] = t;
		}
        
        for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {
					gareen.hurt();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			};
			t.start();
			reduceThreads[i] = t;
		}
        for (Thread t : addThreads) {
			try {
				t.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
        for (Thread t : reduceThreads) {
			try {
				t.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n,n,gareen.hp);
	}

}
