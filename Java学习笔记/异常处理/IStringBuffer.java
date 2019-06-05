package charactor;

import charactor.MyStringBuffer.IndexIsNagetiveException;
import charactor.MyStringBuffer.IndexIsOutofRangeException;

public interface IStringBuffer {
	public void append(String str) throws IndexIsNagetiveException, IndexIsOutofRangeException; //׷���ַ���
    public void append(char c) throws IndexIsNagetiveException, IndexIsOutofRangeException;  //׷���ַ�
    public void insert(int pos,char b) throws IndexIsNagetiveException, IndexIsOutofRangeException; //ָ��λ�ò����ַ�
    public void insert(int pos,String b) throws IndexIsNagetiveException, IndexIsOutofRangeException; //ָ��λ�ò����ַ���
    public void delete(int start) throws IndexIsNagetiveException, IndexIsOutofRangeException; //�ӿ�ʼλ��ɾ��ʣ�µ�
    public void delete(int start,int end) throws IndexIsNagetiveException, IndexIsOutofRangeException; //�ӿ�ʼλ��ɾ������λ��-1
    public void reverse(); //��ת
    public int length(); //���س���
}
