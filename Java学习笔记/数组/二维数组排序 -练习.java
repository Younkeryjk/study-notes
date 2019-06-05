import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019年5月9日
 * 
 * 二维数组排序 -练习
 * 
 * 首先定义一个5X8的二维数组，然后使用随机数填充满。
 * 借助Arrays的方法对二维数组进行排序。
 * 参考思路：先把二维数组使用System.arraycopy进行数组复制到一个一维数组,
 * 然后使用sort进行排序最后再复制回到二维数组。
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