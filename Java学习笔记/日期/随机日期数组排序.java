import java.util.Arrays;
import java.util.Date;
/**
 * @author Younker
 *
 * 2019��5��15��
 * 
 * ��ϰ-���ڸ�ʽ��
 * ׼��һ��������9����������
 * ʹ��1970��-2000��֮���������ڳ�ʼ��������
 * ������Щ���ڵ�ʱ�������������
 * ���� 1988-1-21 12:33:22 �ͻ����� 1978-4-21 19:07:23 ǰ�棬��Ϊ����ʱ���С����Ȼ���ڸ���
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