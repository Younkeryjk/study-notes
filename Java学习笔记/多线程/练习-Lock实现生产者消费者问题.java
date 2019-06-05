import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Younker
 *
 * 2019年5月28日
 * 
 * Lock实现生产者消费者问题
 * 
 * 在练习-生产者消费者问题这个练习中，是用wait(), notify(), notifyAll实现了。
 * 接下来使用Condition对象的：await, signal,signalAll 方法实现同样的效果
 */
public class myStack<T> {

	LinkedList<T> values = new LinkedList<T>();

	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void push(T t) {
		try {
			lock.lock();
			while (values.size() >= 200) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			condition.signalAll();
			values.addLast(t);
		} finally {
			lock.unlock();
		}

	}

	public T pull() {
		T t=null;
		try {
			lock.lock();
			while (values.isEmpty()) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			condition.signalAll();
			t= values.removeLast();
		} finally {
			lock.unlock();
		}
		return t;
	}

	public T peek() {
		return values.getLast();
	}
}
