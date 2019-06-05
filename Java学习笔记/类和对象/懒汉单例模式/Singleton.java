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
	//����һ��static�����ԣ���ָ��null����Ϊ�������ԣ�����ֻ����һ��
	private static Singleton instance;
	//��Ϊ���ܹ������ֻ������Ϊpublic static�� �����ظ��ⲿ������������еĶ���
	public static Singleton getInstance() {
		//ֻ�е�һ�ε���ʱ������ʵ�������������ֱ�ӷ���ʵ������
		if (null == instance) {
			instance = new Singleton();
		}
		return instance;
	}
}
