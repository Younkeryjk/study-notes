package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("¼àÌýÔÚ¶Ë¿ÚºÅ:8888");
			Socket s = ss.accept();
			
			new SendThread(s).start();
			new RecieveThread(s).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}