import java.util.LinkedList;
import java.util.Queue;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * 队列-Queue
 */
public class Test {
    public static void main(String[] args) {
    	LinkedList<Hero> ll = new LinkedList<>();
    	Queue<Hero> q = new LinkedList<>();
    	System.out.print("初始化队列：\t");
		q.offer(new Hero("Hero1"));
	    q.offer(new Hero("Hero2"));
	    q.offer(new Hero("Hero3"));
	    q.offer(new Hero("Hero4"));
	    System.out.println(q);
	    System.out.print("把第一个元素取poll()出来:\t");
	    Hero h = q.poll();
	    System.out.println(h);
	    System.out.print("取出第一个元素之后的队列:\t");
        System.out.println(q);
        h = q.peek();
        System.out.print("查看peek()第一个元素:\t");
        System.out.println(h);
        System.out.print("查看并不会导致第一个元素被取出来:\t");
        System.out.println(q);
    }
}