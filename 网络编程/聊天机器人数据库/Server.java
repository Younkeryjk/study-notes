

package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {

	private static List<String> cannotUnderstand= new ArrayList<>();
	static{
		cannotUnderstand.add("听求不懂啊");
		cannotUnderstand.add("说人话");
		cannotUnderstand.add("再说一遍？");
		cannotUnderstand.add("大声点");
		cannotUnderstand.add("老子在忙，一边玩儿去");
	}
	public static void main(String[] args) {
		try {

			ServerSocket ss = new ServerSocket(8888);

			System.out.println("监听在端口号:8888");
			Socket s = ss.accept();

			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			while (true) {
				String msg = dis.readUTF();
				System.out.println(msg);
				
				List<Dictionary> ds= new DictionaryDAO().query(msg);
				String response = null;
				if(ds.isEmpty()){
					Collections.shuffle(cannotUnderstand);
					response = cannotUnderstand.get(0);
				}
				else{
					Collections.shuffle(ds);
					response = ds.get(0).response;
				}
				dos.writeUTF(response);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}