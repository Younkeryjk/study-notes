package property;

public class Item {
	String name;
	int price;
	
	public void buy(){
        System.out.println("����");
    }
    public void effect() {
        System.out.println("��Ʒʹ�ú󣬿�����Ч��");
    }
    public static void main(String[] args) {
    	Item i1= new LifePotion();
        Item i2 = new MagicPotion();
        System.out.print("i1��Item���ͣ�ִ��effect��ӡ:");
        i1.effect();
        System.out.print("i2Ҳ��Item���ͣ�ִ��effect��ӡ:");
        i2.effect();
    }
}
