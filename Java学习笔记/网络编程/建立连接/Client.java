package socket;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			System.out.println(s);
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
