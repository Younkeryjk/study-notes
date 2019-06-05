/**
 * @author Younker
 *
 * 2019年5月9日
 * 
 * 单例模式
 */
public class Test {

	public static void main(String[] args) {
		//Singleton s = new Singleton(); //通过new实例化会报错，只能通过getInstance得到这个独有的对象
		Singleton d1 = Singleton.getInstance();
		Singleton d2 = Singleton.getInstance();
		Singleton d3 = Singleton.getInstance();
		System.out.println(d1==d2);
        System.out.println(d1==d3);
	}

}