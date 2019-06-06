import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Younker
 *
 * 2019��5��31��
 * 
 * Log4j
 */
public class Test {
	static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) throws InterruptedException {
    	PropertyConfigurator.configure("E:\\Java\\Test\\src\\log4j.properties");
    	 for (int i = 0; i < 5000; i++) {
             logger.trace("������Ϣ");
             logger.debug("������Ϣ");
             logger.info("�����Ϣ");
             logger.warn("������Ϣ");
             logger.error("������Ϣ");
             logger.fatal("������Ϣ");
         }
    }
}