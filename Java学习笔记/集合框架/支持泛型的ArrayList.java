import java.util.ArrayList;
import java.util.List;

import charactor.Hero;
import charactor.HeroItem;
import property.Item;

/**
 * @author Younker
 *
 * 2019��5��21��
 * 
 * ֧�ַ��͵�ArrayList
 * ע��Hero���Item�඼�̳���HeroItem��
 */
public class Test {
    public static void main(String[] args) {
    	List<HeroItem> hi = new ArrayList<>();
    	hi.add(new Hero("����"));
    	hi.add(new Item("��Ѫ��"));
    }
}