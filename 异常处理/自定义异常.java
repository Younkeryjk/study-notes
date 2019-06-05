package charactor;
 
/**
 * @author Younker
 *
 * 2019年5月16日
 * 
 * 自定义异常-练习
 */
public class MyStringBuffer implements IStringBuffer{
 
    int capacity = 16;
    int length = 0;
    char[] value;
    public MyStringBuffer(){
        value = new char[capacity];
    }
     
    //有参构造方法
    public MyStringBuffer(String str){
        this();
        if(null==str)
            throw new NullPointerException("空指针异常");
         
        if(capacity<str.length()){
            capacity  = value.length*2;
            value=new char[capacity];
        }
         
        if(capacity>=str.length())
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
         
        length = str.length();
         
    }
    
    class IndexIsNagetiveException extends Exception {
    	public IndexIsNagetiveException() {
    		
    	}
    	public IndexIsNagetiveException(String msg) {
    		super(msg);
    	}
    }
    
    class IndexIsOutofRangeException extends Exception {
    	public IndexIsOutofRangeException() {
    		
    	}
    	public IndexIsOutofRangeException(String msg) {
    		super(msg);
    	}
    }
    
    @Override
    public void append(String str) throws IndexIsNagetiveException, IndexIsOutofRangeException {
        insert(length,str);
    }
 
    @Override
    public void append(char c) throws IndexIsNagetiveException, IndexIsOutofRangeException {
        append(String.valueOf(c));
         
    }
 
    @Override
    public void insert(int pos, char b) throws IndexIsNagetiveException, IndexIsOutofRangeException {
        insert(pos,String.valueOf(b));
    }
 
    @Override
    public void delete(int start) throws IndexIsNagetiveException, IndexIsOutofRangeException {
         
        delete(start,length);
    }
 
    @Override
    public void delete(int start, int end) throws IndexIsNagetiveException, IndexIsOutofRangeException {
        //边界条件判断
        if(start<0)
            throw new IndexIsNagetiveException("下标为负异常");
         
        if(start>length)
        	throw new IndexIsOutofRangeException("下标超出范围异常");
         
        if(end<0)
        	throw new IndexIsNagetiveException("下标为负异常");
         
        if(end>length)
        	throw new IndexIsOutofRangeException("下标超出范围异常");
         
        if(start>=end)
        	throw new IndexIsOutofRangeException("下标超出范围异常");
         
        System.arraycopy(value, end, value, start, length- end);
        length-=end-start;
         
    }
 
    @Override
    public void reverse() {
        for (int i = 0; i < length/2; i++) {
            char temp = value[i];
            value[i] = value[length-i-1];
            value[length-i-1] = temp;
        }
    }
 
    @Override
    public int length() {
        // TODO Auto-generated method stub
        return length;
    }
 
    @Override
    public void insert(int pos, String b) throws IndexIsNagetiveException, IndexIsOutofRangeException {
 
        //边界条件判断
        if(pos<0)
            throw new IndexIsNagetiveException("下标为负异常");
         
        if(pos>length)
        	throw new IndexIsOutofRangeException("下标超出范围异常");
         
        if(null==b)
        	throw new NullPointerException("空指针异常");
         
        //扩容
        while(length+b.length()>capacity){
            capacity = (int) ((length+b.length())*1.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }
         
        char[] cs = b.toCharArray();
         
        //先把已经存在的数据往后移
         
        System.arraycopy(value, pos, value,pos+ cs.length, length-pos);
        //把要插入的数据插入到指定位置
        System.arraycopy(cs, 0, value, pos, cs.length);
         
        length = length+cs.length;
         
    }
     
    public String toString(){
         
        char[] realValue = new char[length];
 
        System.arraycopy(value, 0, realValue, 0, length);
         
        return new String(realValue);
         
    }
    
    
    public static void main(String[] args) {
    	MyStringBuffer sb = new MyStringBuffer("there light");
        System.out.println(sb);
    	try {
            sb.insert(10000, "let ");
            System.out.println(sb);
            sb.insert(10, "be ");
            System.out.println(sb);
            sb.insert(0, "God Say:");
            System.out.println(sb);
            sb.append("!");
            System.out.println(sb);
            sb.append('?');
            System.out.println(sb);
            sb.delete(0,4);
            System.out.println(sb);
            sb.delete(4);
            System.out.println(sb);
		} catch (IndexIsNagetiveException e) {
			e.printStackTrace();
		} catch (IndexIsOutofRangeException e) {
			e.printStackTrace();
		}

        sb.reverse();
        System.out.println(sb);
         
        sb.reverse();
        System.out.println(sb);
         
        
         
    }
 
}
