import java.util.LinkedList;
import java.util.Queue;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * ����-Queue
 */
public class Test {
    public static void main(String[] args) {
    	LinkedList<Hero> ll = new LinkedList<>();
    	Queue<Hero> q = new LinkedList<>();
    	System.out.print("��ʼ�����У�\t");
		q.offer(new Hero("Hero1"));
	    q.offer(new Hero("Hero2"));
	    q.offer(new Hero("Hero3"));
	    q.offer(new Hero("Hero4"));
	    System.out.println(q);
	    System.out.print("�ѵ�һ��Ԫ��ȡpoll()����:\t");
	    Hero h = q.poll();
	    System.out.println(h);
	    System.out.print("ȡ����һ��Ԫ��֮��Ķ���:\t");
        System.out.println(q);
        h = q.peek();
        System.out.print("�鿴peek()��һ��Ԫ��:\t");
        System.out.println(h);
        System.out.print("�鿴�����ᵼ�µ�һ��Ԫ�ر�ȡ����:\t");
        System.out.println(q);
    }
}