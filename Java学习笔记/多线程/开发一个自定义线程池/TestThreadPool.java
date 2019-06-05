package multiplethread;

/**
 * @author Younker
 *
 * 2019��5��28��
 * 
 * ����һ���Զ����̳߳�
 */
public class TestThreadPool {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();
		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("ִ������");
				}
			};
			pool.add(task);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
