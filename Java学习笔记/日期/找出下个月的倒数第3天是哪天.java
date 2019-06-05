import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Younker
 *
 * 2019年5月15日
 * 
 * 找出下个月的倒数第3天是哪天
 */
public class Test {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static String format(Date time) {
		return sdf.format(time);
	}
    public static void main(String args[]) {
    	Calendar c = Calendar.getInstance();
    	Date now = c.getTime();
    	c.setTime(now);
    	c.add(Calendar.MONTH, 2);
    	c.set(Calendar.DAY_OF_MONTH, 1);
    	c.add(Calendar.DATE, -3);
    	System.out.println(format(c.getTime()));
    }
}