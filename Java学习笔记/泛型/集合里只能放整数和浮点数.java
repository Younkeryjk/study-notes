import java.util.ArrayList;
import java.util.List;

/**
 * @author Younker
 *
 * 2019年5月23日
 * 
 * 根据数字类的知识，设计一个集合，这个集合里即可以放整数，也可以放浮点数，但是不能放字符串
 */
public class Test {
	public static void main(String[] args) {
		List<Number> l = new ArrayList<>();
		l.add(1);
		l.add(2.0);
		//l.add("str");
		System.out.println(l);
	}
}
