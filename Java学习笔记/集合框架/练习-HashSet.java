import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * ��ϰ-HashSet
 * ����һ��������100���ַ�������
 * ʹ�ó�����2������ַ������ַ�������
 * ͳ������ַ����������ظ����ַ����ж�����
 */
public class Test {
	public static String randStr(int len) {
		String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	char[] c = new char[len];
    	int randIndex;
    	for (int i = 0; i < c.length; i++) {
    		randIndex = (int)(Math.random() * 62);
			c[i] = pool.charAt(randIndex);
		}
    	return new String(c);
	}
	
    public static void main(String[] args) {
    	String[] arr = new String[100];
    	System.out.println("��ʼ�����飺");
    	for (int i = 0; i < arr.length; i++) {
    		arr[i] = randStr(2);
    		System.out.print(arr[i]+"\t");
    		if ((i+1)%10==0) {
    			System.out.println();
    		}
		}
    	
    	HashSet<String> hs = new HashSet<>();
    	List repeatStrArr = new ArrayList<>();
    	for (String str : arr) {
			if (!hs.add(str)) {
				repeatStrArr.add(str);
			}
		}
    	System.out.printf("�ܹ���%d���ظ����ַ���", repeatStrArr.size());
    	System.out.println("�ֱ��ǣ�");
    	for (int i = 0; i < repeatStrArr.size(); i++) {
			System.out.println(repeatStrArr.get(i));
		}
    }
}