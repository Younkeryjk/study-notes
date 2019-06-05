/**
 * @author Younker
 *
 * 2019��5��31��
 * 
 * ��ϰ-�ھ�̬�����ϼ�synchronized��ͬ��������ʲô�������
 */
public class Test {
	
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(){
            public void run(){
                //����method1
            	Test.method1();
            }
        };
        t1.setName("��һ���߳�");
        t1.start();
          
        //��֤��һ���߳��ȵ���method1
        Thread.sleep(1000);
          
        Thread t2= new Thread(){
            public void run(){
                //����method2
            	Test.method2();
            }
        };
        t2.setName("�ڶ����߳�");
        t2.start();
    }
  
    public static void method1() {
  
        synchronized (Test.class) {
            // ����method1���ԣ�ͬ��������Test.class��ֻ��ռ��Test.class�ſ���ִ�е�����
            System.out.println(Thread.currentThread().getName() + " ������method1����");
            try {
                System.out.println("����5��");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
  
                e.printStackTrace();
            }
        }
    }
  
    public static synchronized void method2() {
        // ����mehotd2���ԣ���Ȼ�и�ͬ������ͨ���۲췢�֣���ĳ���߳���method1�У�ռ����Test.class֮��
        // ���޷�����method2���ƶϳ���method2��ͬ�����󣬾���Test.class
        System.out.println(Thread.currentThread().getName() + " ������method2����");
        try {
            System.out.println("����5��");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
  
            e.printStackTrace();
        }
  
    }
}