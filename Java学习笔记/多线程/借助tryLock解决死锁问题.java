import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Younker
 *
 * 2019��5��28��
 * 
 * ��ϰ-����tryLock �����������
 * 
 * ������̰߳��ղ�ͬ˳��ռ�ö��ͬ�������ʱ�򣬾��п��ܲ�����������
 * ����֮���Իᷢ����������Ϊsynchronized ���ռ�ò���ͬ������
 * �ͻ����һֱ�ȴ���ȥ������tryLock�����޵ȴ�ʱ�䣬�����������
 */
public class Test {
	static boolean locked1;
	static boolean locked2;
	public static String now() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	public static void log(String msg) {
		System.out.printf("%s %s %s %n", now(), Thread.currentThread(), msg);
	}
	public static void main(String[] args) {
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		
		Thread t1 = new Thread() {
			public void run() {
				try {
					log("�߳�����");
					log("��ͼռ�ж���lock1");
					locked1 = lock1.tryLock(3, TimeUnit.SECONDS);
					if (locked1) {
						log("ռ�ж���lock1");
						log("����5���ҵ�����");
						Thread.sleep(5000);
					} else {
						log("��������ĵȴ�����û��ռ��Ŀ��,������");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("�ͷŶ���lock1");
					lock1.unlock();
				}
				log("�߳̽���");
			}
		};
		t1.setName("t1");
		t1.start();
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					log("�߳�����");
					log("��ͼռ�ж���lock2");
					locked2 = lock2.tryLock(3, TimeUnit.SECONDS);
					if (locked2) {
						log("ռ�ж���lock2");
						log("����5���ҵ�����");
						Thread.sleep(5000);
					} else {
						log("��������ĵȴ�����û��ռ��Ŀ��,������");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("�ͷŶ���lock2");
					lock2.unlock();
				}
				log("�߳̽���");
			}
		};
		t2.setName("t2");
		t2.start();
	}
}
