package charactor;
 
/**
 * @author Younker
 *
 * 2019年5月24日
 */
public class Hero {
   public String name;
   public float hp;
   public int damage;
   public boolean isDead() {
	   return 0 >= hp ? true : false;
   }
   
   //直接在方法前加上修饰符synchronized
   //其所对应的同步对象，就是this
   //和hurt方法达到的效果一样
   public synchronized void recover() {
	   hp += 1;
   }
   public void hurt() {
	synchronized (this) {
		hp -= 1;
	}
   }
   public void attackHero(Hero h) {
		h.hp -= damage;
		System.out.format("%s 正在攻击 %s， %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name+"死了！");
		}
   }
}
