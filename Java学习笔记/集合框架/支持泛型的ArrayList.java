import java.util.ArrayList;
import java.util.List;

import charactor.Hero;
import charactor.HeroItem;
import property.Item;

/**
 * @author Younker
 *
 * 2019年5月21日
 * 
 * 支持泛型的ArrayList
 * 注：Hero类和Item类都继承了HeroItem类
 */
public class Test {
    public static void main(String[] args) {
    	List<HeroItem> hi = new ArrayList<>();
    	hi.add(new Hero("盖伦"));
    	hi.add(new Item("回血包"));
    }
}