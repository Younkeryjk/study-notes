package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 守护线程
 */
public class TestThread {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				int seconds = 0;
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.printf("已经玩了LOL %d 秒%n", seconds++);
				}
			}
		};
		t1.setDaemon(true);
		t1.start();
	}

}
