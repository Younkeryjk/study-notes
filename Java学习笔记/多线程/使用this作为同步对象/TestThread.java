package multiplethread;
  
import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��25��
 * 
 * ʹ��this��Ϊͬ������
 */
public class TestThread {
  
    public static void main(String[] args) {
    	
        final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 10000;
         
        int n = 10000;
 
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
         
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                	
                	//ʹ��gareen��Ϊsynchronized
                	synchronized (gareen) {
                		gareen.recover();
					}
                    
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }
         
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                	//�κ��߳�Ҫ�޸�hp��ֵ��������ռ��someObject
                	//ʹ��gareen��Ϊsynchronized
                    //�ڷ���hurt��ʹ��synchronized(this)
                		gareen.hurt();
                	
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
         
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         
        System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ���� %.0f%n", n,n,gareen.hp);
    }
      
}
