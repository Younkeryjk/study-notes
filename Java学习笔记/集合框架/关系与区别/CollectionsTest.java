import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Younker
 * 
 * ���Ͽ��
 *
 * 2019��5��7��
 */
public class CollectionsTest {

    public static void main(String[] args) {
    	List<Integer> nums = new ArrayList<>();
    	for (int i = 0; i < 10; i++) {
    		nums.add(i);
    	}
    	
    	 System.out.println("�޸�ǰ�����е�����:");
         System.out.println(nums);
         
        //��ת
        //Collections.reverse(nums);
         
        //����
        //Collections.shuffle(nums);
       
        //����
        //Collections.sort(nums);
         
        //����
        //Collections.swap(nums, 2, 3);
         
        //����
        //Collections.rotate(nums, 3);
         
        //�̰߳�ȫ��
        //List<Integer> synchronizedNumbers = (List<Integer>)Collections.synchronizedList(nums);
         
        System.out.println("�޸ĺ󼯺��е�����:");
        System.out.println(nums);
    }
}