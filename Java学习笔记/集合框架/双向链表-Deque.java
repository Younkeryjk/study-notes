import java.util.LinkedList;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * 双向链表-Deque
 */
public class Test {
    public static void main(String[] args) {
    	LinkedList<Hero> ll = new LinkedList<>();
    	ll.addLast(new Hero("hero1"));
    	ll.addLast(new Hero("hero2"));
    	ll.addLast(new Hero("hero3"));
    	System.out.println("addLast后：");
    	System.out.println(ll);
    	ll.addFirst(new Hero("heroX"));
    	System.out.println("addFirst后：");
    	System.out.println(ll);
    	System.out.println("查看第一个元素：");
    	System.out.println(ll.getFirst());
    	System.out.println("查看最后一个元素：");
    	System.out.println(ll.getLast());
    	ll.removeFirst();
    	ll.removeLast();
    	System.out.println("删除第一个和最后一个元素后：");
    	System.out.println(ll);
    }
}