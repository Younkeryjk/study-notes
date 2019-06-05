import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    // ���ӽڵ�
    public Node<T> leftNode;
    // ���ӽڵ�
    public Node<T> rightNode;
   
    // ֵ
    public Object value;
   
    // ���� ����
    public void add(Object v) {
        // �����ǰ�ڵ�û��ֵ���Ͱ����ݷ��ڵ�ǰ�ڵ���
        if (null == value)
            value = v;
   
        // �����ǰ�ڵ���ֵ���ͽ����жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
        else {
            // ������ֵ���ȵ�ǰֵС������ͬ
              
            try{
                if ((Integer) v -((Integer)value) <= 0) {
                    if (null == leftNode)
                    leftNode = new Node<>();
                    leftNode.add(v);
                }
                // ������ֵ���ȵ�ǰֵ��
                else {
                    if (null == rightNode)
                    rightNode = new Node<>();
                    rightNode.add(v);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
                 
   
        }
   
    }
   
 // ����������еĽڵ�
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
   
        // ��ڵ�ı������
        if (null != leftNode)
            values.addAll(leftNode.values());
   
        // ��ǰ�ڵ�
        values.add(value);
   
        // �ҽڵ�ı������
        if (null != rightNode)
   
            values.addAll(rightNode.values());
   
        return values;
    }
   
    public static void main(String[] args) {
   
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
   
        Node<Integer> roots = new Node<>();
        for (int number : randoms) {
            roots.add(number);
        }
        try {
            roots.add("1234");//�ᱨ����Ϊ�����Ѿ�ָ���˷���
        }catch(ClassCastException e) {
            e.printStackTrace();
        }
         
   
        System.out.println(roots.values());
   
    }
}
