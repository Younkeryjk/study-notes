import java.util.LinkedList;

import javax.swing.plaf.synth.SynthScrollBarUI;

import charactor.Hero;
import collection.Stack;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * 使用LinkedList实现Stack栈
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
		myStack a = new myStack(); // 非静态要有对象
        //压栈
        a.push(new Hero("Hero1"));
        a.push(new Hero("Hero2"));
        a.push(new Hero("Hero3"));
        System.out.println("压栈后：");
        showAll();
        System.out.println("出栈元素："+a.pull());
        System.out.println("出栈后：");
        showAll();
        System.out.println("查看最后一个元素：");
        System.out.println(a.peek());
	}

}
