/**
 * @author Younker
 *
 * 2019��5��10��
 * 
 * ��������ģʽ
 */
public class Singleton {
	//˽�л����췽����ʹ���ⲿ�޷�ͨ��newʵ����
	private Singleton() {
		
	}
	//����һ��static�����ԣ�����ָ��һ������������Ϊ�������ԣ�����ֻ����һ��
	private static Singleton instance = new Singleton();
	//��Ϊ���ܹ������ֻ������Ϊpublic static�� �����ظ��ⲿ������������еĶ���
	public static Singleton getInstance() {
		return instance;
	}
}
