/**
 * @author Younker
 *
 * 2019��5��9��
 * 
 * ����ģʽ
 */
public class Test {

	public static void main(String[] args) {
		//Singleton s = new Singleton(); //ͨ��newʵ�����ᱨ��ֻ��ͨ��getInstance�õ�������еĶ���
		Singleton d1 = Singleton.getInstance();
		Singleton d2 = Singleton.getInstance();
		Singleton d3 = Singleton.getInstance();
		System.out.println(d1==d2);
        System.out.println(d1==d3);
	}

}