import java.util.LinkedList;
import java.util.Random;

import collection.Stack;

/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 生产者消费者问题
 * 
 * 生产者消费者问题是一个非常典型性的线程交互的问题。
 * 1. 使用栈来存放数据
 * 1.1 把栈改造为支持线程安全
 * 1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 当栈里的数据是200的时候，访问push的线程就会等待
 * 2. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
 * 3. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
 * 4. 提供一个测试类，使两个生产者和三个消费者线程同时运行，结果类似如下 ：
 */
class MyStack<T> {
	private LinkedList<T> list;
	private int count;

	public MyStack() {
		list = new LinkedList<>();
		count = 0;
	}

	public synchronized int getSize() {
		return count;
	}

	public synchronized void push(T ele) {
		while (count >= 200) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		list.offerLast(ele);
		count++;
		this.notifyAll();
	}

	public synchronized T pull() {
		while (count <= 0) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		T res = list.pollLast();
		count--;
		this.notifyAll();
		return res;
	}

	public synchronized T peek() {
		return list.peekLast();
	}
}

class Producer implements Runnable {
	private MyStack<Character> stack;

	public Producer(MyStack<Character> stack) {
		this.stack = stack;
	}

	private char generateChar() {
		return (char) (new Random().nextInt(26) + 'a');
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			char c = generateChar();
			stack.push(c);
			System.out.println("Producer pushed: " + c + " " + stack.getSize());
		}

	}
}

class Consumer implements Runnable {
	private MyStack<Character> stack;

	public Consumer(MyStack<Character> stack) {
		this.stack = stack;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Consumer pulled: " + stack.pull() + " " + stack.getSize());
		}
	}
}

public class Test {
	public static void main(String[] args) {
		MyStack<Character> stack = new MyStack();
		for (int i = 0; i < 3; i++) {
			new Thread(new Producer(stack)).start();
		}
		for (int i = 0; i < 2; i++) {
			new Thread(new Consumer(stack)).start();
		}
	}
}
