import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019年5月9日
 * 
 * 复制数组练习
 * 首先准备两个数组，他俩的长度是5-10之间的随机数，并使用随机数初始化这两个数组
 * 然后准备第三个数组，第三个数组的长度是前两个的和
 * 通过System.arraycopy 把前两个数组合并到第三个数组中
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