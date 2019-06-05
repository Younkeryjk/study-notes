import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Younker
 *
 * 2019年5月28日
 * 
 * 练习-借助tryLock 解决死锁问题
 * 
 * 当多个线程按照不同顺序占用多个同步对象的时候，就有可能产生死锁现象。
 * 死锁之所以会发生，就是因为synchronized 如果占用不到同步对象，
 * 就会苦苦的一直等待下去，借助tryLock的有限等待时间，解决死锁问题
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
					log("线程启动");
					log("试图占有对象：lock1");
					locked1 = lock1.tryLock(3, TimeUnit.SECONDS);
					if (locked1) {
						log("占有对象：lock1");
						log("进行5秒的业务操作");
						Thread.sleep(5000);
					} else {
						log("经过三秒的等待，还没有占有目标,放弃！");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("释放对象：lock1");
					lock1.unlock();
				}
				log("线程结束");
			}
		};
		t1.setName("t1");
		t1.start();
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					log("线程启动");
					log("试图占有对象：lock2");
					locked2 = lock2.tryLock(3, TimeUnit.SECONDS);
					if (locked2) {
						log("占有对象：lock2");
						log("进行5秒的业务操作");
						Thread.sleep(5000);
					} else {
						log("经过三秒的等待，还没有占有目标,放弃！");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("释放对象：lock2");
					lock2.unlock();
				}
				log("线程结束");
			}
		};
		t2.setName("t2");
		t2.start();
	}
}
