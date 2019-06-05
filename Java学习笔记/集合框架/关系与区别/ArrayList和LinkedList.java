import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Younker
 * 
 * 2019��5��7��
 * 
 * ArrayList��LinkedList������
 * 
 * ����
 * ArrayList��λ�죬���롢ɾ����
 * LinkedList��λ�������롢ɾ����
 */
public class Test {
	
	public static void main(String[] args) {
       /* �ڿ�ͷ�������ݣ�
        * List<Integer> l;
        l = new ArrayList<>();
        insertFirst(l, "ArrayList");
 
        l = new LinkedList<>();
        insertFirst(l, "LinkedList");*/
		
		/* ���м�������ݣ�
		 * List<Integer> l;
        l = new ArrayList<>();
        insertMiddle(l, "ArrayList");
 
        l = new LinkedList<>();
        insertMiddle(l, "LinkedList");*/
		

		/* �����������ݣ�
		 * List<Integer> l;
        l = new ArrayList<>();
        insertLast(l, "ArrayList");
 
        l = new LinkedList<>();
        insertLast(l, "LinkedList");*/
        
		/* ��λ���ݣ�
		 * List<Integer> l;
		l = new ArrayList<>();
		modify(l, "ArrayList");
		
		l = new LinkedList<>();
		modify(l, "LinkedList");*/
    }
	
	private static void modify(List<Integer> l, String type) {
		int total = 1000 * 100;
		int index = total / 2;
		final int number = 5;
		for (int i = 0; i < total; i++) {
			l.add(number);
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			int n = l.get(index);
			n++;
			l.set(index, n);
		}
		long end = System.currentTimeMillis();
		 System.out.printf("%s�ܳ�����%d����λ����%d�����ݣ�ȡ��������1���ٷŻ�ȥ%n �ظ�%d�飬�ܹ���ʱ %d ���� %n", type,total, index,total, end - start);
	}
	
    private static void insertFirst(List<Integer> l, String type) {
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(0, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("��%s ��ǰ�����%d�����ݣ��ܹ���ʱ %d ���� %n", type, total, end - start);
    }
    
    private static void insertLast(List<Integer> l,String s) {
        int total=100*1000;//�ܲ������������
        final int number=5;//���������
        long start=System.currentTimeMillis();
        for(int i=0;i<total;i++)
            l.add(i);//���뵽���
        long end=System.currentTimeMillis();
        System.out.printf("��%s��������%d��������Ҫ��%d����%n",s,total,(end-start));
    }
    
    private static void insertMiddle(List<Integer> l, String type) {
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(l.size()/2, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("��%s �м����%d�����ݣ��ܹ���ʱ %d ���� %n", type, total, end - start);
    }
}