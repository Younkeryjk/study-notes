package charactor;
 
public class Hero {
   public String name;
   public float hp;
   public int damage;
   public boolean isDead() {
	   return 0 >= hp ? true : false;
   }
   public void attackHero(Hero h) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		h.hp -= damage;
		System.out.format("%s ���ڹ��� %s�� %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name+"���ˣ�");
		}
   }
}
