package multiplethread;
  
import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��25��
 * 
 * ����-���õĽ����ʽ
 * �߳�֮���н���֪ͨ�����󣬿������������ 
 * �������̣߳�����ͬһ��Ӣ�ۡ� 
 * һ����Ѫ��һ����Ѫ�� 
 * ��Ѫ���̣߳�����Ѫ��=1����ֹͣ��Ѫ��ֱ����Ѫ���߳�ΪӢ�ۼ���Ѫ���ſ��Լ�����Ѫ
 * 
 * ���õĽ����ʽ
 * ������Ƽ�Ѫ�߳�Ƶ�ʸ��ߣ����׵�Ѫ������ᵽ��1
 * ��Ѫ�߳���ʹ��whileѭ���ж��Ƿ���1�������1�Ͳ�ͣ��ѭ��,ֱ����Ѫ�̻߳ظ���Ѫ��
 * ���ǲ��õĽ����ʽ����Ϊ�����ռ��CPU,��������
 */
public class TestThread {
    public static void main(String[] args) {
    	final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        
        Thread t1 = new Thread() {
        	public void run() {
        		while (true) {
        			//��Ϊ��Ѫ���죬���Ը��׵�Ѫ������ᵽ��1
                    //ʹ��whileѭ���ж��Ƿ���1�������1�Ͳ�ͣ��ѭ��
                    //ֱ����Ѫ�̻߳ظ���Ѫ��
        			while (gareen.hp == 1) {
        				continue;
        			}
        			gareen.hurt();
        			System.out.printf("t1 Ϊ%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n",gareen.name,gareen.name,gareen.hp);
        			try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
        		}
        	}
        };
        t1.start();
        
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
                    System.out.printf("t2 Ϊ%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n",gareen.name,gareen.name,gareen.hp);
 
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
 
            }
        };
        t2.start();
    }
      
}
