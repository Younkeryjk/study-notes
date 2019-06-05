import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019��5��9��
 * 
 * ����������ϰ
 * ����׼���������飬�����ĳ�����5-10֮������������ʹ���������ʼ������������
 * Ȼ��׼�����������飬����������ĳ�����ǰ�����ĺ�
 * ͨ��System.arraycopy ��ǰ��������ϲ���������������
 */
public class Test {

	public static void main(String[] args) {
		int aLen = (int)(Math.random() * 6) + 5;
		int[] a = new int[aLen];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100);
		}
		System.out.println(Arrays.toString(a));
		
		int bLen = (int)(Math.random() * 6) + 5;
		int[] b = new int[bLen];
		for (int i = 0; i < b.length; i++) {
			b[i] = (int)(Math.random() * 100);
		}
		System.out.println(Arrays.toString(b));
		
		int[] c = new int[aLen + bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		System.out.println(Arrays.toString(c));

	}

}