package charactor;
 
/**
 * @author Younker
 *
 * 2019��5��24��
 */
public class Hero {
   public String name;
   public float hp;
   public int damage;
   public boolean isDead() {
	   return 0 >= hp ? true : false;
   }
   public void recover() {
	   hp += 1;
   }
   public void hurt() {
	synchronized (this) {
		hp -= 1;
	}
   }
   public void attackHero(Hero h) {
		h.hp -= damage;
		System.out.format("%s ���ڹ��� %s�� %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name+"���ˣ�");
		}
   }
}
