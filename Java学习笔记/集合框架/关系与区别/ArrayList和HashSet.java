import java.util.HashSet;

/**
 * @author Younker
 * 
 * 2019��5��7��
 * 
 * ArrayList��HashSet������
 * 
 * ����
 * 1���Ƿ���˳��ArrayList��˳��HashSet��˳��
 * 2���Ƿ����ظ���ArrayList���ظ���HashSet�����ظ�
 * 
 * ��ϰ������50�� 0-9999֮����������Ҫ�������ظ���
 */
public class Test {

    public static void main(String[] args) {
    	HashSet<Integer> hs = new HashSet<>();
    	//����һ��
    	while (hs.size() < 50) {
    		hs.add((int)(Math.random() * 10000));
		}
    	//��������
    	/*for (int i = 0; i < 50; i++) {
        	if (!hs.add((int)(Math.random() * 100))) {
        		i--;
        	}
		}*/
    	int count = 0;
    	for (Integer integer : hs) {
    		count++;
			System.out.println(count + "---" + integer);
		}
       
    }
}