import java.util.Arrays;

/**
 * @author Younker
 * 
 * 2019��5��7��
 * 
 * ѡ������
 * ԭ����		18	62	68	82	65	9
 * ��һ��		9	62  68  82  65  18
 * �ڶ���		9	18  68  82	 65  62
 * ������		9	18	  62  82	 68  65	
 * ������		9	18	  62	65	 82  68
 * ������		9	18	  62	65	 68  82
 */
public class Test {

	public static void main(String[] args) {
		 int[] nums = new int[]{18, 62, 68, 82, 65, 9};
		 //n����������Ҫ����n-1�����򣻱���һ����Ҫ���� 6 - 1 = 5�� 
		for (int j = 0; j < nums.length - 1; j++) {
			 //ÿ������ʼλ�ô�nums[j]�ĺ�һλnums[j+1]��ʼ�ֱ���nums[j]�Ƚϣ��Ƚϵ���ĩβ��length������
			for (int i = j + 1; i < nums.length; i++) {
				if (nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		 }
		 System.out.println(Arrays.toString(nums));
	}

}