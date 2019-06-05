package multiplethread;

import java.util.LinkedList;

/**
 * @author Younker
 *
 * 2019年5月28日
 * 
 * 开发一个自定义线程池
 */
public class ThreadPool {
	// 线程池大小
    int threadPoolSize;
    
    // 任务容器
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();
    
    //试图消费任务的线程
    public ThreadPool() {
    	threadPoolSize = 10;
    	synchronized (tasks) {
    		for (int i = 0; i < threadPoolSize; i++) {
				new TaskConsumeThread("任务消费者线程 "+i).start();
			}
		}
    }
    public void add(Runnable r) {
    	synchronized (tasks) {
			tasks.add(r);
			tasks.notifyAll();
		}
    }
    class TaskConsumeThread extends Thread {
    	public TaskConsumeThread(String name) {
    		super(name);
    	}
    	Runnable task;
    	public void run() {
    		System.out.println("启动： "+this.getName());
    		while (true) {
    			synchronized (tasks) {
    				while (tasks.isEmpty()) {
    					try {
							tasks.wait();
						} catch (Exception e) {
							e.printStackTrace();
						}
    				}
    				task = tasks.removeLast();
    				//允许添加任务的线程可以继续添加任务
    				tasks.notifyAll();
    			}
    			System.out.println(this.getName() + " 获取到任务，并执行");
    			task.run();
    		}
    	}
    }
}
