package charactor;
 
/**
 * @author Younker
 *
 * 2019��5��24��
 * 
 * Ӣ���п��Է�һ�����ܽ���: ����ȭ-a du gen�� 
 * ÿ��һ���ӣ����Է�һ�Σ�����ֻ��������3�Ρ� 
 * ����3��֮����Ҫ����5���ӣ��������ټ������� 
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
		System.out.format("%s ���ڹ��� %s�� %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name+"���ˣ�");
		}
   }
   public static void aDuGen() {
	   Thread t1 = new Thread() {
		 public void run() {
			 int count = 0;
			 while (true) {
				 for (int i = 0; i < 3; i++) {
					 count =  i+1;
					System.out.println("����ȭ��"+count+"��");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("��ʼΪʱ5��ĳ���");
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
