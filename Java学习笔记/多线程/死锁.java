package multiplethread;
  
import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��25��
 * 
 * ���� 
 */
public class TestThread {
  
    public static void main(String[] args) {
    	final Hero ahri = new Hero();
    	ahri.name = "��β����";
        final Hero annie = new Hero();
        annie.name = "����";
        final Hero yjk = new Hero();
        yjk.name = "Younker";
        Thread t1 = new Thread() {
        	public void run() {
        		synchronized (ahri) {
					System.out.println("t1 ��ռ�о�β����");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("t1 ��ͼռ�а���");
                    System.out.println("t1 �ȴ��� ��������");
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
        			System.out.println("t2 ��ռ�а���");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("t2 ��ͼռ��Younker");
                    System.out.println("t2 �ȴ��� ��������");
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
        			System.out.println("t3 ��ռ�а���");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("t3 ��ͼռ�о�β����");
                    System.out.println("t3 �ȴ��� ��������");
                    synchronized (ahri) {
                    	System.out.println("do something3");
					}
				}
        	}
        };
        t3.start();
    }
      
}
