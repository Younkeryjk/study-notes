import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019年5月9日
 * 
 * Arrays
 */
public class Test {

	public static void main(String[] args) {
		int a[] = new int[] { 18, 62, 68, 82, 65, 9 };
		/*
		 *  1、copyOfRange
		 *  2、toString
		 * int[] b = Arrays.copyOfRange(a, 0, 3);
		System.out.println(Arrays.toString(b));*/
		/*
		 * 3、sort
		 * Arrays.sort(a);//排序*/	
		/*
		 * 4、binarySearch
		 * 使用binarySearch进行查找之前，必须使用sort进行排序
		 * Arrays.sort(a);
		System.out.println(Arrays.binarySearch(a, 62));*/
		
        /*5、equals比较两个数组的内容是否一样
         * int b[] = new int[] { 18, 62, 68, 82, 65, 8 };
		System.out.println(Arrays.equals(a, b));*/
		
		/*6、fill
		 * int b[] = new int[10];
		Arrays.fill(b, 5);
		System.out.println(Arrays.toString(b));*/
	}

}