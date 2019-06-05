import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
/**
 * @author Younker
 *
 * 2019年5月20日
 * 
 * 练习-自动创建类
 * 自动创建有一个属性的类文件。
 * 通过控制台，获取类名，属性名称，属性类型，根据一个模板文件，自动创建这个类文件，并且为属性提供setter和getter
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
    	System.out.println("请输入类的名称");
    	String className = s.nextLine();
    	System.out.println("请输入属性的类型");
    	String propertyType = s.nextLine();
    	System.out.println("请输入属性的名称");
    	String propertyName = s.nextLine();
    	char[] propertyCharArr = propertyName.toCharArray();
    	propertyCharArr[0] = Character.toUpperCase(propertyCharArr[0]);
    	//读取模板文件
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