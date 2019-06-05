import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import charactor.Hero;

/**
 * @author Younker
 *
 * 2019年5月31日
 * 
 * 通过配置文件获取对象
 * 
 * 首先准备一个文本文件：hero.config。 在这个文件中保存类的全名称，可以是charactor.APHero 或者是charactor.ADHero
 * 接着设计一个方法叫做：
 * public static Hero getHero()
 * 在这个方法中，读取hero.config的数据，取出其中的类名，根据类名实例化出对象，然后返回对象。
 */
public class Test {
	
	public static String getHero(File f){
        File file = (File)f;
        String className = null;
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)
        ) {
            className = br.readLine();
 
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return className;
    }
	
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	/*思路：
    	 * 1、读取配置文件获取类名称
    	 * 2、通过反射机制获取类对象
    	 * 3、通过类对象获取构造器
    	 * 4、通过构造器创建实例*/
    	File configFile = new File("E:\\Java\\Test\\src\\hero.config");
    	
    	
    	String className = getHero(configFile);
    	Class pClass = Class.forName(className);
    	Constructor c = pClass.getConstructor();
    	Hero h2 = (Hero)c.newInstance();
    	h2.name="gareen";
        System.out.println(h2);
    }
}