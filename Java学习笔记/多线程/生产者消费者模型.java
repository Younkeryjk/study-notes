import java.util.LinkedList;
import java.util.Random;

import collection.Stack;

/**
 * @author Younker
 *
 * 2019��5��24��
 * 
 * ����������������
 * 
 * ������������������һ���ǳ������Ե��߳̽��������⡣
 * 1. ʹ��ջ���������
 * 1.1 ��ջ����Ϊ֧���̰߳�ȫ
 * 1.2 ��ջ�ı߽�������д�����ջ���������0��ʱ�򣬷���pull���߳̾ͻ�ȴ��� ��ջ���������200��ʱ�򣬷���push���߳̾ͻ�ȴ�
 * 2. �ṩһ�������ߣ�Producer���߳��࣬���������д�ַ�ѹ�뵽��ջ
 * 3. �ṩһ�������ߣ�Consumer���߳��࣬�Ӷ�ջ�е����ַ�����ӡ������̨
 * 4. �ṩһ�������࣬ʹ���������ߺ������������߳�ͬʱ���У������������ ��
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
