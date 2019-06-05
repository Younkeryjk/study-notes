package charactor;
 
/**
 * @author Younker
 *
 * 2019年5月24日
 * 
 * 英雄有可以放一个技能叫做: 波动拳-a du gen。 
 * 每隔一秒钟，可以发一次，但是只能连续发3次。 
 * 发完3次之后，需要充能5秒钟，充满，再继续发。 
 */
public class Hero {
   public String name;
   public float hp;
   public int damage;
   public boolean isDead() {
	   return 0 >= hp ? true : false;
   }
   public void attackHero(Hero h) {
		h.hp -= damage;
		System.out.format("%s 正在攻击 %s， %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name+"死了！");
		}
   }
   public static void aDuGen() {
	   Thread t1 = new Thread() {
		 public void run() {
			 int count = 0;
			 while (true) {
				 for (int i = 0; i < 3; i++) {
					 count =  i+1;
					System.out.println("波动拳第"+count+"发");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("开始为时5秒的充能");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }  
	   };
	   t1.start();
   }
   public static void main(String[] args) {
	   aDuGen();
   }
}
