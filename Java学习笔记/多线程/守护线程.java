package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��24��
 * 
 * �ػ��߳�
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
					System.out.printf("�Ѿ�����LOL %d ��%n", seconds++);
				}
			}
		};
		t1.setDaemon(true);
		t1.start();
	}

}
