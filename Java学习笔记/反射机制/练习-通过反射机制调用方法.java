import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

/**
 * @author Younker
 *
 * 2019��5��31��
 * 
 * ���÷���
 * 
 * ������һ����ϰ ��ϰ-ͨ�������ļ���ȡ���󣬰�hero.config�Ķ���Ϊ֧�����¸�ʽ��
 * charactor.APHero
 * garen
 * charactor.ADHero
 * teemo
 * 
 * ���ȸ�����������ļ���ʹ�÷���ʵ����������Ӣ�۳�����Ȼ��ͨ�������������Ӣ���������ƣ�
 * ������ͨ�����䣬���õ�һ��Ӣ�۵�attackHero�����������ڶ���Ӣ��
 */
public class Test {
	
    public static void main(String[] args) {
    	
    	try {
    		//��ȡ�����ļ�
			FileReader fr = new FileReader("E:\\Java\\Test\\src\\hero.config");
			BufferedReader br = new BufferedReader(fr);
			List<String> list = new ArrayList<>();
			String str = null;
			while (null != (str = br.readLine())) {
				//ͨ���������ʵ��������Ӣ��
				list.add(str);
			}
			Class gClass = Class.forName(list.get(0));
			Constructor c = gClass.getConstructor();
			Hero h = (Hero)c.newInstance();
			Field field1 = Hero.class.getDeclaredField("name");
			field1.set(h, list.get(1));
			
			Class gClass2 = Class.forName(list.get(2));
			Constructor c2 = gClass2.getConstructor();
			Hero h2 = (Hero)c2.newInstance();
			field1.set(h2, list.get(3));
			
			Method m = h.getClass().getMethod("attackHero", Hero.class);
			m.invoke(h, h2);
			
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}