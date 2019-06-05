import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import charactor.Hero;
import collection.Stack;
 
 
/**
 * @author Younker
 *
 * 2019年5月28日
 * 
 * Lock版本
 */
public class myStack implements Stack{
     //把LinkedList通过 Collections.synchronizedList转换成了一个线程安全的List
    List<Hero> heros = new LinkedList<Hero>();
   
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    //虽然多个线程可以同时进入push方法，但是调用heros.add方法的时候 
    //同一时间，只有一个线程可以进入
    public void push(Hero h) {
    	lock.lock();

    	while (heros.size() >= 200) {
    		try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        heros.add(h);
        condition.signalAll();
        lock.unlock();
    }
      
    public Hero pull() {
    	lock.lock();

    	while (heros.size()<=0) {
    		try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	condition.signalAll();
    	Hero h = heros.remove(heros.size()-1);
    	lock.unlock();
        return h;
    }
      
    public Hero peek() {
        return heros.get(heros.size()-1);
    }
 
     
     
    @Override
    public String toString() {
        return "MyStack [list=" + heros + "]";
    }
 
    public static void main(String[] args) {
        int n = 1000;
        final myStack heroStack = new myStack();
        Thread[] threads = new Thread[n];
        Thread[] threads1 = new Thread[n];
        for (int i = 0; i < n; i++) {
            final Hero h = new Hero("hero name " + i);
            System.out.println("压入 hero:" + h);
            Thread thread = new Thread(){
                public void run() {
                    heroStack.push(h);
                };
            };
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    Hero h = heroStack.pull();
                    System.out.println("弹出 hero" + h);
                };
            };
            thread.start();
            threads1[i] = thread;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Thread thread : threads1) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         
        System.out.println(heroStack);
    }
 
     
}