package multiplethread;
  
import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月25日
 * 
 * 线程之间有交互通知的需求，考虑如下情况： 
 * 有两个线程，处理同一个英雄。 
 * 一个加血，一个减血。 
 * 减血的线程，发现血量=1，就停止减血，直到加血的线程为英雄加了血，才可以继续减血
 * 
 * 在Hero类中：hurt()减血方法：当hp=1的时候，执行this.wait().
 * this.wait()表示 让占有this的线程等待，并临时释放占有
 * 进入hurt方法的线程必然是减血线程，this.wait()会让减血线程临时释放对this的占有。 这样加血线程，就有机会进入recover()加血方法了。
 * recover() 加血方法：增加了血量，执行this.notify();
 * this.notify() 表示通知那些等待在this的线程，可以苏醒过来了。 等待在this的线程，恰恰就是减血线程。 一旦recover()结束， 加血线程释放了this，减血线程，就可以重新占有this，并执行后面的减血工作。
 */
public class TestThread {
    public static void main(String[] args) {
    	final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        
        Thread t1 = new Thread() {
        	public void run() {
        		while (true) {
        			//无需循环判断
        			/*while (gareen.hp == 1) {
        				continue;
        			}*/
        			gareen.hurt();
        			System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
        			try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
        		}
        	}
        };
        t1.start();
        
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
 
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
 
            }
        };
        t2.start();
    }
      
}
