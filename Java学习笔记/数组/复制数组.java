import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019年5月9日
 * 
 * 复制数组
 */
public class Test {

	public static void main(String[] args) {
		int a[] = {18,62,68,82,65,9};
		int b[] = new int[3];
		//方法一：for循环
		/*for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}*/
		//方法二：System.arraycopy(src, srcPos, dest, destPos, length)
		System.arraycopy(a, 0, b, 0, b.length);
		System.out.println(Arrays.toString(b));

	}

}