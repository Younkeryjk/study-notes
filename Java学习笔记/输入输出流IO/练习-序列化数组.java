import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import charactor.Hero;

public class Test {
/**
 * @author Younker
 *
 * 2019��5��20��
 * 
 * ��ϰ-���л�����
 */

    public static void main(String[] args) {
    	Hero[] heros = new Hero[10];
    	for (int i = 0; i < heros.length; i++) {
    		heros[i] = new Hero("hero:"+i);
		}
		File file = new File("E:/Java/Test/src/lol.txt");

    	try (
    			FileOutputStream fos = new FileOutputStream(file);
    			ObjectOutputStream oos = new ObjectOutputStream(fos);
    			
    			FileInputStream fis = new FileInputStream(file);
    			ObjectInputStream ois = new ObjectInputStream(fis);
    	) {
    		for (int i = 0; i < heros.length; i++) {
    			oos.writeObject(heros[i]);
			}
			System.out.println("�鿴�ļ��з����л������������е�ÿһ��Ԫ�أ�");
	        for(int i = 0;i < heros.length;i++) {
	        	System.out.println(((Hero)ois.readObject()).name);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}