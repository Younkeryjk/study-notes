import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Younker
 *
 * 2019年5月31日
 * 
 * Log4j
 */
public class Test {
	static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) throws InterruptedException {
    	PropertyConfigurator.configure("E:\\Java\\Test\\src\\log4j.properties");
    	 for (int i = 0; i < 5000; i++) {
             logger.trace("跟踪信息");
             logger.debug("调试信息");
             logger.info("输出信息");
             logger.warn("警告信息");
             logger.error("错误信息");
             logger.fatal("致命信息");
         }
    }
}