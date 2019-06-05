/**
 * @author Younker
 *
 * 2019年5月10日
 * 
 * 懒汉单例模式
 */
public class Singleton {
	//私有化构造方法，使其外部无法通过new实例化
	private Singleton() {
		
	}
	//声明一个static类属性，先指向null；因为是类属性，所以只能有一个
	private static Singleton instance;
	//因为不能构造对象，只能设置为public static， 并返回给外部调用者这个独有的对象
	public static Singleton getInstance() {
		//只有第一次调用时，创建实例对象，其他情况直接返回实例对象
		if (null == instance) {
			instance = new Singleton();
		}
		return instance;
	}
}
