/**
 * @author Younker
 *
 * 2019年5月10日
 * 
 * 饿汉单例模式
 */
public class Singleton {
	//私有化构造方法，使其外部无法通过new实例化
	private Singleton() {
		
	}
	//声明一个static类属性，用来指向一个单例对象；因为是类属性，所以只能有一个
	private static Singleton instance = new Singleton();
	//因为不能构造对象，只能设置为public static， 并返回给外部调用者这个独有的对象
	public static Singleton getInstance() {
		return instance;
	}
}
