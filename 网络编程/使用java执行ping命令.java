import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Younker
 *
 * 2019��5��24��
 * 
 * ʹ��java ִ��ping����
 */
public class Test {
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("ping " + "169.254.238.102");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while (null != (line = br.readLine())) {
			if (line.length() != 0)
				sb.append(line + "\r\n");
		}
		System.out.println("����ָ��ص���Ϣ�ǣ�");
		System.out.println(sb.toString());
	}
}
