import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Younker
 *
 * 2019��5��28��
 * 
 * ʹ��trylock����ʵ��ͬ��Ч��
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
				boolean locked = false;
				try {
					log("�߳�����");
					log("��ͼռ�ж���lock");
					locked = lock.tryLock(1, TimeUnit.SECONDS);
					if (locked) {
						log("ռ�ж���");
						log("����5���ҵ�����");
						Thread.sleep(5000);
					} else {
						log("����1���ӵ�Ŭ������û��ռ�ж��󣬷���ռ��");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (locked) {
						log("�ͷŶ���lock");
						lock.unlock();
					}
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
				boolean locked = false;
				try {
					log("�߳�����");
					log("��ͼռ�ж���lock");
					locked = lock.tryLock(1,TimeUnit.SECONDS);
					if (locked) {
						log("ռ�ж���lock");
						log("����5���ҵ�����");
						Thread.sleep(5000);
					} else {
						log("����1���ӵ�Ŭ������û��ռ�ж��󣬷���ռ��");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (locked) {
						log("�ͷŶ���lock");
						lock.unlock();
					}
				}
				log("�߳̽���");
			}
		};
		t2.setName("t2");
		t2.start();
	}
}
