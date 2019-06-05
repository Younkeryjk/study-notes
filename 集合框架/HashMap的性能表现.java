import java.util.HashMap;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��22��
 * 
 * 	HashMap�����ܱ���
 * 
 * 	������HashMap�д�������ظ����ƣ�û��˳���2000000��Hero
	Ҫ�����ֽ�����hero 1000000���Ķ����ҳ���
	�����߼���
	1. ��ʼ��2000000������HashMap�С�
	2. ����10�β�ѯ
	3. ͳ��ÿһ�εĲ�ѯ���ĵ�ʱ��
 */
public class Test {
    public static void main(String[] args) {
    	HashMap<String, Hero> hm = new HashMap<>();
    	for (int i = 0; i < 2000000; i++) {
    		Hero h = new Hero("hero "+i);
			hm.put(h.name, h);
		}
    	for (int i = 0; i < 10; i++) {
    		long start = System.currentTimeMillis();
			if (null != hm.get("hero 1000000")) {
				System.out.println("�ҵ���hero!");
			}
			long end = System.currentTimeMillis();
			System.out.printf("��%d�λ��ˣ�%d ����", i+1, end-start);
			System.out.println();
		}
    }
}