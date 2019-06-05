/**
 * @author Younker
 *
 * 2019年5月9日
 * 
 * 枚举类型
 */
public class Test {

	public static void main(String[] args) {
		Season season = Season.SUMMER;
		switch (season) {
		case SPRING:
			System.out.println("春天");
            break;
		case SUMMER:
            System.out.println("夏天");
            break;
        case AUTUMN:
            System.out.println("秋天");
            break;
        case WINTER:
            System.out.println("冬天");
            break;
		}
	}

}