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
 * Lock线程交互
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
		Condition condition = lock.newCondition();
		
		Thread t1 = new Thread() {
			public void run() {
				try {
					log("线程启动");
					log("试图占有对象：lock");
					lock.lock();
					log("占有对象：lock");
					log("进行5秒的业务操作");
					Thread.sleep(5000);
					log("临时释放对象lock，并等待");
					condition.await();
					log("重新占有对象lock，并进行5秒的业务操作");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("释放对象：lock");
					lock.unlock();
				}
				log("线程结束");
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
					log("线程启动");
					log("试图占有对象：lock");
					lock.lock();
					log("占有对象：lock");
					log("进行5秒的业务操作");
					Thread.sleep(5000);
					log("唤醒等待中的线程");
					condition.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("释放对象：lock");
					lock.unlock();
				}
				log("线程结束");
			}
		};
		t2.setName("t2");
		t2.start();
	}
}
