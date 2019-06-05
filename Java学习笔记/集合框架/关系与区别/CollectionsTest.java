import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Younker
 * 
 * 集合框架
 *
 * 2019年5月7日
 */
public class CollectionsTest {

    public static void main(String[] args) {
    	List<Integer> nums = new ArrayList<>();
    	for (int i = 0; i < 10; i++) {
    		nums.add(i);
    	}
    	
    	 System.out.println("修改前集合中的数据:");
         System.out.println(nums);
         
        //反转
        //Collections.reverse(nums);
         
        //打乱
        //Collections.shuffle(nums);
       
        //排序
        //Collections.sort(nums);
         
        //交换
        //Collections.swap(nums, 2, 3);
         
        //滚动
        //Collections.rotate(nums, 3);
         
        //线程安全化
        //List<Integer> synchronizedNumbers = (List<Integer>)Collections.synchronizedList(nums);
         
        System.out.println("修改后集合中的数据:");
        System.out.println(nums);
    }
}