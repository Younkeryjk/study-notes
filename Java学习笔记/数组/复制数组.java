import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019��5��9��
 * 
 * ��������
 */
public class Test {

	public static void main(String[] args) {
		int a[] = {18,62,68,82,65,9};
		int b[] = new int[3];
		//����һ��forѭ��
		/*for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}*/
		//��������System.arraycopy(src, srcPos, dest, destPos, length)
		System.arraycopy(a, 0, b, 0, b.length);
		System.out.println(Arrays.toString(b));

	}

}