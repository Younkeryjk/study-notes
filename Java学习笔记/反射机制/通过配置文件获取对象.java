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
 * 2019��5��31��
 * 
 * ͨ�������ļ���ȡ����
 * 
 * ����׼��һ���ı��ļ���hero.config�� ������ļ��б������ȫ���ƣ�������charactor.APHero ������charactor.ADHero
 * �������һ������������
 * public static Hero getHero()
 * ����������У���ȡhero.config�����ݣ�ȡ�����е���������������ʵ����������Ȼ�󷵻ض���
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
    	/*˼·��
    	 * 1����ȡ�����ļ���ȡ������
    	 * 2��ͨ��������ƻ�ȡ�����
    	 * 3��ͨ��������ȡ������
    	 * 4��ͨ������������ʵ��*/
    	File configFile = new File("E:\\Java\\Test\\src\\hero.config");
    	
    	
    	String className = getHero(configFile);
    	Class pClass = Class.forName(className);
    	Constructor c = pClass.getConstructor();
    	Hero h2 = (Hero)c.newInstance();
    	h2.name="gareen";
        System.out.println(h2);
    }
}