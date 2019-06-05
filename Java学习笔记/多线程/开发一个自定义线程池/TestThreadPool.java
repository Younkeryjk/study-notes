package multiplethread;

/**
 * @author Younker
 *
 * 2019年5月28日
 * 
 * 开发一个自定义线程池
 */
public class TestThreadPool {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();
		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("执行任务");
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
