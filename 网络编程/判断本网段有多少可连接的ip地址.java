import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Younker
 *
 * 2019��5��29��
 * 
 * �жϱ������ж��ٿ����ӵ�ip��ַ
 * 
 * ���Ȼ�ȡ ��ȡ����IP��ַ������˵��192.168.2.100�� ��ô�����ε�ip��ַ���Ǵ� 192.168.2.1 �� 192.168.2.255
 * ��ͨ��ʹ��java ִ��ping���� �ж���Щip��ַ�ܷ����ӣ����ܹ����ӵ�ip��ӡ����
 */
public class Test {
	public static boolean isConnect(String ip) throws IOException {
		String cmdStr = "ping " + ip;
		Process p = Runtime.getRuntime().exec(cmdStr);
	    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    String line = null;
	    while (null != (line = br.readLine())) {
	    	if (line.length() != 0) {
		    	if (line.contains("TTL")) {
		    		br.close();
		    		return true;
		    	}
	    	}
	    }
    	br.close();

		return false;
	}
	
	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		String myIpRange = ip.substring(0, ip.lastIndexOf(".") + 1);
		//����ʹ�� ʵ��IP����10.0.1. myIpRange = "10.0.1.";
		ArrayList<String> ips = new ArrayList<>();
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		AtomicInteger number = new AtomicInteger();
		
		for (int i = 1; i <= 255; i++) {
			String testIp = myIpRange + "" + i;

			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						if (isConnect(testIp)) {
							ips.add(testIp);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (number) {
						System.out.println("�����"+number.incrementAndGet());
					}
				}
			});
		}
		threadPool.shutdown();
		if (threadPool.awaitTermination(1, TimeUnit.HOURS)) {
			System.out.println("������ip:");
			for (String s : ips) {
				System.out.println(s);
			}
			System.out.println("�ܹ���:" + ips.size() + " ����ַ");
		}
		
    }
}