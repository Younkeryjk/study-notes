import java.util.Arrays;
import java.util.Date;
/**
 * @author Younker
 *
 * 2019年5月15日
 * 
 * 练习-日期格式化
 * 准备一个长度是9的日期数组
 * 使用1970年-2000年之间的随机日期初始化该数组
 * 按照这些日期的时间进行升序排序
 * 比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大
 */
public class Test {

    public static void main(String args[]) {
    	Date[] dateArr = new Date[9];
    	long endDateMillis = new Date(100, 11, 31, 23, 59, 59).getTime();
    	long[] randDateMilliArr = new long[9];
    	long randDateMilli = 0;
    	for (int i = 0; i < dateArr.length; i++) {
    		randDateMilli = (long)(Math.random() * endDateMillis + 1);
    		randDateMilliArr[i] = randDateMilli;
		}
    	Arrays.sort(randDateMilliArr);
    	for (int i = 0; i < randDateMilliArr.length; i++) {
    		dateArr[i] = new Date(randDateMilliArr[i]);
        	System.out.println(dateArr[i]);
		}
    }
}