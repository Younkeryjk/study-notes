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
   public Hero(String name) {
	this.name = name;
   }

public Hero() {
	// TODO Auto-generated constructor stub
}

public boolean isDead() {
	   return 0 >= hp ? true : false;
   }
   
   //ֱ���ڷ���ǰ�������η�synchronized
   //������Ӧ��ͬ�����󣬾���this
   //��hurt�����ﵽ��Ч��һ��
   public synchronized void recover() {
	   hp += 1;
	   System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
	// ֪ͨ��Щ�ȴ���this�����ϵ��̣߳������ѹ����ˣ��ȴ��ŵļ�Ѫ�̣߳����ѹ���
	   this.notify();
   }
   public synchronized void hurt() {
	   if (hp == 1) {
			try {
				// ��ռ��this�ļ�Ѫ�̣߳���ʱ�ͷŶ�this��ռ�У����ȴ�
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	   hp = hp - 1;
	   System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
   }
   public void attackHero(Hero h) {
		h.hp -= damage;
		System.out.format("%s ���ڹ��� %s�� %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name+"���ˣ�");
		}
   }
}
