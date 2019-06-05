package property;

import java.io.PrintStream;

public class Item implements Comparable<Item> {
    String name;
    int price;
     
    //�ṩһ����ʼ��name�Ĺ��췽��
    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

	@Override
	public int compareTo(Item o) {
		if (price < o.price)
			return 1;
		else
			return -1;
	}
	
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]\r\n";
	}
}
