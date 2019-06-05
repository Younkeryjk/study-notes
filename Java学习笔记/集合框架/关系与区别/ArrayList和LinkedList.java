import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Younker
 * 
 * 2019年5月7日
 * 
 * ArrayList和LinkedList的区别
 * 
 * 区别：
 * ArrayList定位快，插入、删除快
 * LinkedList定位慢，插入、删除快
 */
public class Test {
	
	public static void main(String[] args) {
       /* 在开头插入数据：
        * List<Integer> l;
        l = new ArrayList<>();
        insertFirst(l, "ArrayList");
 
        l = new LinkedList<>();
        insertFirst(l, "LinkedList");*/
		
		/* 在中间插入数据：
		 * List<Integer> l;
        l = new ArrayList<>();
        insertMiddle(l, "ArrayList");
 
        l = new LinkedList<>();
        insertMiddle(l, "LinkedList");*/
		

		/* 在最后插入数据：
		 * List<Integer> l;
        l = new ArrayList<>();
        insertLast(l, "ArrayList");
 
        l = new LinkedList<>();
        insertLast(l, "LinkedList");*/
        
		/* 定位数据：
		 * List<Integer> l;
		l = new ArrayList<>();
		modify(l, "ArrayList");
		
		l = new LinkedList<>();
		modify(l, "LinkedList");*/
    }
	
	private static void modify(List<Integer> l, String type) {
		int total = 1000 * 100;
		int index = total / 2;
		final int number = 5;
		for (int i = 0; i < total; i++) {
			l.add(number);
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			int n = l.get(index);
			n++;
			l.set(index, n);
		}
		long end = System.currentTimeMillis();
		 System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type,total, index,total, end - start);
	}
	
    private static void insertFirst(List<Integer> l, String type) {
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(0, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
    }
    
    private static void insertLast(List<Integer> l,String s) {
        int total=100*1000;//总插入的数据条数
        final int number=5;//插入的数据
        long start=System.currentTimeMillis();
        for(int i=0;i<total;i++)
            l.add(i);//插入到最后
        long end=System.currentTimeMillis();
        System.out.printf("在%s最后面插入%d条数据需要用%d毫秒%n",s,total,(end-start));
    }
    
    private static void insertMiddle(List<Integer> l, String type) {
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(l.size()/2, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s 中间插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
    }
}