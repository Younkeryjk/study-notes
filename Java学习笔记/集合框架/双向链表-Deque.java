import java.util.LinkedList;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * ˫������-Deque
 */
public class Test {
    public static void main(String[] args) {
    	LinkedList<Hero> ll = new LinkedList<>();
    	ll.addLast(new Hero("hero1"));
    	ll.addLast(new Hero("hero2"));
    	ll.addLast(new Hero("hero3"));
    	System.out.println("addLast��");
    	System.out.println(ll);
    	ll.addFirst(new Hero("heroX"));
    	System.out.println("addFirst��");
    	System.out.println(ll);
    	System.out.println("�鿴��һ��Ԫ�أ�");
    	System.out.println(ll.getFirst());
    	System.out.println("�鿴���һ��Ԫ�أ�");
    	System.out.println(ll.getLast());
    	ll.removeFirst();
    	ll.removeLast();
    	System.out.println("ɾ����һ�������һ��Ԫ�غ�");
    	System.out.println(ll);
    }
}