import java.util.Arrays;

/**
 * @author Younker
 * 
 * 2019年5月7日
 * 
 * 选择排序
 * 原数组		18	62	68	82	65	9
 * 第一轮		9	62  68  82  65  18
 * 第二轮		9	18  68  82	 65  62
 * 第三轮		9	18	  62  82	 68  65	
 * 第四轮		9	18	  62	65	 82  68
 * 第五轮		9	18	  62	65	 68  82
 */
public class Test {

	public static void main(String[] args) {
		 int[] nums = new int[]{18, 62, 68, 82, 65, 9};
		 //n个数排序，需要进行n-1轮排序；本例一共需要排序 6 - 1 = 5轮 
		for (int j = 0; j < nums.length - 1; j++) {
			 //每轮排序开始位置从nums[j]的后一位nums[j+1]开始分别与nums[j]比较，比较到最末尾即length结束；
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