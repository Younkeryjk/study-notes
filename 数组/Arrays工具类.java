import java.util.Arrays;

/**
 * @author Younker
 *
 * 2019��5��9��
 * 
 * Arrays
 */
public class Test {

	public static void main(String[] args) {
		int a[] = new int[] { 18, 62, 68, 82, 65, 9 };
		/*
		 *  1��copyOfRange
		 *  2��toString
		 * int[] b = Arrays.copyOfRange(a, 0, 3);
		System.out.println(Arrays.toString(b));*/
		/*
		 * 3��sort
		 * Arrays.sort(a);//����*/	
		/*
		 * 4��binarySearch
		 * ʹ��binarySearch���в���֮ǰ������ʹ��sort��������
		 * Arrays.sort(a);
		System.out.println(Arrays.binarySearch(a, 62));*/
		
        /*5��equals�Ƚ���������������Ƿ�һ��
         * int b[] = new int[] { 18, 62, 68, 82, 65, 8 };
		System.out.println(Arrays.equals(a, b));*/
		
		/*6��fill
		 * int b[] = new int[10];
		Arrays.fill(b, 5);
		System.out.println(Arrays.toString(b));*/
	}

}