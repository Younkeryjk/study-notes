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
 * 2019年5月20日
 * 
 * 序列化一个对象
 */

    public static void main(String[] args) {
    	Hero h = new Hero();
    	h.name = "garen";
    	h.hp = 616;
    	File f = new File("d:/garen.lol");
    	try (
    			FileOutputStream fos = new FileOutputStream(f);
    			ObjectOutputStream oos = new ObjectOutputStream(fos);
    			
    			FileInputStream fis = new FileInputStream(f);
    			ObjectInputStream ois = new ObjectInputStream(fis);
    	) {
			oos.writeObject(h);
			Hero h2 = (Hero)ois.readObject();
			System.out.println(h2.name);
			System.out.println(h2.hp);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}