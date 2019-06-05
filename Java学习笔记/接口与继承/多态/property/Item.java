package property;

public class Item {
	String name;
	int price;
	
	public void buy(){
        System.out.println("购买");
    }
    public void effect() {
        System.out.println("物品使用后，可以有效果");
    }
    public static void main(String[] args) {
    	Item i1= new LifePotion();
        Item i2 = new MagicPotion();
        System.out.print("i1是Item类型，执行effect打印:");
        i1.effect();
        System.out.print("i2也是Item类型，执行effect打印:");
        i2.effect();
    }
}
