import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Younker
 *
 * 2019��5��28��
 * 
 * ʹ��Lock����ʵ��ͬ��Ч��
 */
public class Test {
	public static String now() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	public static void log(String msg) {
		System.out.printf("%s %s %s %n", now(), Thread.currentThread(), msg);
	}
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Thread t1 = new Thread() {
			public void run() {
				try {
					log("�߳�����");
					log("��ͼռ�ж���lock");
					lock.lock();
					log("ռ�ж���");
					log("����5���ҵ�����");
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("�ͷŶ���lock");
					lock.unlock();
				}
				log("�߳̽���");
			}
		};
		t1.setName("t1");
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread t2 = new Thread() {
			public void run() {
				try {
					log("�߳�����");
					log("��ͼռ�ж���lock");
					lock.lock();
					log("ռ�ж���lock");
					log("����5���ҵ�����");
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("�ͷŶ���");
					lock.unlock();
				}
				log("�߳̽���");
			}
		};
		t2.setName("t2");
		t2.start();
	}
}
