import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019��5��9��
 * 
 * ��ά������ϰ
 * ����һ��5X5�Ķ�ά���顣 Ȼ��ʹ����������ö�ά���顣
 * �ҳ������ά����������Ǹ�ֵ������ӡ�����ά����
 */
public class Test {

	public static void main(String[] args) {
		int[][] a = new int[5][5];
		int max = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int)(Math.random() * 100);
				if (max < a[i][j]) {
					max = a[i][j];
					x = i;
					y = j;
				}
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.printf("���ֵΪ%d�����ά����ΪX��%d��Y:%d", max, x, y);
		
	}

}