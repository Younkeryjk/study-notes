package multiplethread;
  
import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月25日
 * 
 * 死锁 
 */
public class TestThread {
  
    public static void main(String[] args) {
    	final Hero ahri = new Hero();
    	ahri.name = "九尾妖狐";
        final Hero annie = new Hero();
        annie.name = "安妮";
        final Hero yjk = new Hero();
        yjk.name = "Younker";
        Thread t1 = new Thread() {
        	public void run() {
        		synchronized (ahri) {
					System.out.println("t1 已占有九尾妖狐");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("t1 试图占有安妮");
                    System.out.println("t1 等待中 。。。。");
                    synchronized (annie) {
						System.out.println("do something");
					}
        		}
        	}
        };
        t1.start();
        Thread t2 = new Thread() {
        	public void run() {
        		synchronized (annie) {
        			System.out.println("t2 已占有安妮");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("t2 试图占有Younker");
                    System.out.println("t2 等待中 。。。。");
                    synchronized (yjk) {
                    	System.out.println("do something2");
					}
				}
        	}
        };
        t2.start();
        
        Thread t3 = new Thread() {
        	public void run() {
        		synchronized (yjk) {
        			System.out.println("t3 已占有安妮");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("t3 试图占有九尾妖狐");
                    System.out.println("t3 等待中 。。。。");
                    synchronized (ahri) {
                    	System.out.println("do something3");
					}
				}
        	}
        };
        t3.start();
    }
      
}
