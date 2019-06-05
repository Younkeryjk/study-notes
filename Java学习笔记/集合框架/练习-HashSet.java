import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Younker
 *
 * 2019年5月22日
 * 
 * 练习-HashSet
 * 创建一个长度是100的字符串数组
 * 使用长度是2的随机字符填充该字符串数组
 * 统计这个字符串数组里重复的字符串有多少种
 */
public class Test {
	public static String randStr(int len) {
		String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	char[] c = new char[len];
    	int randIndex;
    	for (int i = 0; i < c.length; i++) {
    		randIndex = (int)(Math.random() * 62);
			c[i] = pool.charAt(randIndex);
		}
    	return new String(c);
	}
	
    public static void main(String[] args) {
    	String[] arr = new String[100];
    	System.out.println("初始化数组：");
    	for (int i = 0; i < arr.length; i++) {
    		arr[i] = randStr(2);
    		System.out.print(arr[i]+"\t");
    		if ((i+1)%10==0) {
    			System.out.println();
    		}
		}
    	
    	HashSet<String> hs = new HashSet<>();
    	List repeatStrArr = new ArrayList<>();
    	for (String str : arr) {
			if (!hs.add(str)) {
				repeatStrArr.add(str);
			}
		}
    	System.out.printf("总共有%d种重复的字符串", repeatStrArr.size());
    	System.out.println("分别是：");
    	for (int i = 0; i < repeatStrArr.size(); i++) {
			System.out.println(repeatStrArr.get(i));
		}
    }
}