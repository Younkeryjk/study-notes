package multiplethread;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��24��
 * 
 * ��ʾͬ������
 * ���������10000��Ѫ�������ڻ����ͬʱ�ֱ��Է����Ӣ�۹���
 * �����ж���߳��ڼ��ٸ��׵�hp
 * ͬʱ���ж���߳��ڻָ����׵�hp
 * �����̵߳�������һ���ģ�����ÿ�θı��ֵ����1����ô�����߳̽����󣬸���Ӧ�û���10000��Ѫ��
 * ���ǡ�����
 * ע�⣺ ����ÿһ�����ж��ῴ����������ݲ����������м��Σ������������еĴ���
 */
public class TestThread {

	public static void main(String[] args) {
		final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 10000;
        System.out.printf("���׵ĳ�ʼѪ���� %.0f%n", gareen.hp);
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
        System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ������� %.0f%n", n,n,gareen.hp);
	}

}
