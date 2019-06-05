import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019年5月9日
 * 
 * 二维数组练习
 * 定义一个5X5的二维数组。 然后使用随机数填充该二维数组。
 * 找出这个二维数组里，最大的那个值，并打印出其二维坐标
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
		System.out.printf("最大值为%d，其二维坐标为X：%d；Y:%d", max, x, y);
		
	}

}