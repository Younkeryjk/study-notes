import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
/**
 * @author Younker
 *
 * 2019��5��20��
 * 
 * ��ϰ-�Զ�������
 * �Զ�������һ�����Ե����ļ���
 * ͨ������̨����ȡ�������������ƣ��������ͣ�����һ��ģ���ļ����Զ�����������ļ�������Ϊ�����ṩsetter��getter
 * public class @class@ {
	    public @type@ @property@;
	    public @class@() {
	    }
	    public void set@Uproperty@(@type@  @property@){
	        this.@property@ = @property@;
	    }
	      
	    public @type@  get@Uproperty@(){
	        return this.@property@;
	    }
	}
 */

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.println("�������������");
    	String className = s.nextLine();
    	System.out.println("���������Ե�����");
    	String propertyType = s.nextLine();
    	System.out.println("���������Ե�����");
    	String propertyName = s.nextLine();
    	char[] propertyCharArr = propertyName.toCharArray();
    	propertyCharArr[0] = Character.toUpperCase(propertyCharArr[0]);
    	//��ȡģ���ļ�
    	try (
    			FileReader fr = new FileReader("E:/Java/Test/src/template.txt");
    			BufferedReader br = new BufferedReader(fr);
    			
    			FileWriter fw = new FileWriter("E:/Java/Test/src/"+className+".java");
    			PrintWriter pw = new PrintWriter(fw);
    	) {
			while (true) {
				String str = br.readLine();
				if (null == str) {
					break;
				}
				String replaceStr = str.replaceAll("@class@", className);
				replaceStr = replaceStr.replaceAll("@type@", propertyType);
				replaceStr = replaceStr.replaceAll("@Uproperty@", String.valueOf(propertyCharArr));
				replaceStr = replaceStr.replaceAll("@property@", propertyName);
				pw.println(replaceStr);
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}