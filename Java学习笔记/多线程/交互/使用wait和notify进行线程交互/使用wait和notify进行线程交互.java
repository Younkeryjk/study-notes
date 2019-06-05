package multiplethread;
  
import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��25��
 * 
 * �߳�֮���н���֪ͨ�����󣬿������������ 
 * �������̣߳�����ͬһ��Ӣ�ۡ� 
 * һ����Ѫ��һ����Ѫ�� 
 * ��Ѫ���̣߳�����Ѫ��=1����ֹͣ��Ѫ��ֱ����Ѫ���߳�ΪӢ�ۼ���Ѫ���ſ��Լ�����Ѫ
 * 
 * ��Hero���У�hurt()��Ѫ��������hp=1��ʱ��ִ��this.wait().
 * this.wait()��ʾ ��ռ��this���̵߳ȴ�������ʱ�ͷ�ռ��
 * ����hurt�������̱߳�Ȼ�Ǽ�Ѫ�̣߳�this.wait()���ü�Ѫ�߳���ʱ�ͷŶ�this��ռ�С� ������Ѫ�̣߳����л������recover()��Ѫ�����ˡ�
 * recover() ��Ѫ������������Ѫ����ִ��this.notify();
 * this.notify() ��ʾ֪ͨ��Щ�ȴ���this���̣߳��������ѹ����ˡ� �ȴ���this���̣߳�ǡǡ���Ǽ�Ѫ�̡߳� һ��recover()������ ��Ѫ�߳��ͷ���this����Ѫ�̣߳��Ϳ�������ռ��this����ִ�к���ļ�Ѫ������
 */
public class TestThread {
    public static void main(String[] args) {
    	final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        
        Thread t1 = new Thread() {
        	public void run() {
        		while (true) {
        			//����ѭ���ж�
        			/*while (gareen.hp == 1) {
        				continue;
        			}*/
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
