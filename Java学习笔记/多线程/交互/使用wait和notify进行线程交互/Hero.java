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
   public Hero(String name) {
	this.name = name;
   }

public Hero() {
	// TODO Auto-generated constructor stub
}

public boolean isDead() {
	   return 0 >= hp ? true : false;
   }
   
   //直接在方法前加上修饰符synchronized
   //其所对应的同步对象，就是this
   //和hurt方法达到的效果一样
   public synchronized void recover() {
	   hp += 1;
	   System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
	// 通知那些等待在this对象上的线程，可以醒过来了，等待着的减血线程，苏醒过来
	   this.notify();
   }
   public synchronized void hurt() {
	   if (hp == 1) {
			try {
				// 让占有this的减血线程，暂时释放对this的占有，并等待
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	   hp = hp - 1;
	   System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
   }
   public void attackHero(Hero h) {
		h.hp -= damage;
		System.out.format("%s 正在攻击 %s， %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name+"死了！");
		}
   }
}
