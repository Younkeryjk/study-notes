import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019��5��9��
 * 
 * ��ά�������� -��ϰ
 * 
 * ���ȶ���һ��5X8�Ķ�ά���飬Ȼ��ʹ��������������
 * ����Arrays�ķ����Զ�ά�����������
 * �ο�˼·���ȰѶ�ά����ʹ��System.arraycopy�������鸴�Ƶ�һ��һά����,
 * Ȼ��ʹ��sort������������ٸ��ƻص���ά���顣
 */
public class Test {

	public static void main(String[] args) {
		int[][] arr = new int[5][8];
		int[][] newArr = new int[5][8];
		int[] tempArr = new int[5 * 8];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				arr[i][j] = (int)(Math.random() * 100);
			}
			//Arrays.copyOfRange(arr[i], i * 8, arr[i].length);
			System.arraycopy(arr[i], 0, tempArr, i * 8, 8);
		}
		Arrays.sort(tempArr);
		for (int i = 0; i < 40; i++) {
			System.out.print(tempArr[i] + "\t");
			if ((i + 1) % 8 == 0) {
				System.out.println();
			}
		}
		System.out.println("-----------------------------------");
		for (int i = 0; i < 5; i++) {
			System.arraycopy(tempArr, i * 8, newArr[i], 0, 8);
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(newArr[i][j] + "\t");
				if ((j + 1) % 8 == 0) {
					System.out.println();
				}
			}
			
		}
	}

}