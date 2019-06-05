import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Younker
 *
 * 2019��5��23��
 * 
 * 	�Զ���˳���TreeSet
 * 
 * 	Ĭ������£�TreeSet�е������Ǵ�С��������ģ�����TreeSet�Ĺ��췽��֧�ִ���һ��Comparator
	public TreeSet(Comparator comparator) 
	ͨ��������췽������һ��TreeSet��ʹ�����еĵ������ǵ������
 */
public class Test {
    public static void main(String[] args) {
    	TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
    		@Override
    		public int compare(Integer i1, Integer i2) {
    			if (i1 < i2)
    				return 1;
    			else
    				return -1;
    				
    		}	
		});
    	for (int i = 0; i < 10; i++) {
			ts.add(i);
		}
    	 System.out.println(ts);
    }
}
