import java.util.LinkedList;

import javax.swing.plaf.synth.SynthScrollBarUI;

import charactor.Hero;
import collection.Stack;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * ʹ��LinkedListʵ��Stackջ
 */
public class myStack implements Stack{
	static LinkedList<Hero> ll = new LinkedList<>();
	public void push(Hero h) {
		ll.addLast(h);
	}
	
	 public Hero pull() {
		return ll.removeLast();
	 }
	 
	 public Hero peek() {
		 return ll.getLast();
	 }
	 public static void showAll() {
		 for (Hero hero : ll) {
			System.out.println(hero);
		}
	 }
	public static void main(String[] args) {
		myStack a = new myStack(); // �Ǿ�̬Ҫ�ж���
        //ѹջ
        a.push(new Hero("Hero1"));
        a.push(new Hero("Hero2"));
        a.push(new Hero("Hero3"));
        System.out.println("ѹջ��");
        showAll();
        System.out.println("��ջԪ�أ�"+a.pull());
        System.out.println("��ջ��");
        showAll();
        System.out.println("�鿴���һ��Ԫ�أ�");
        System.out.println(a.peek());
	}

}
