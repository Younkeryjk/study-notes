/**
 * @author Younker
 *
 * 2019��5��9��
 * 
 * ö������
 */
public class Test {

	public static void main(String[] args) {
		Season season = Season.SUMMER;
		switch (season) {
		case SPRING:
			System.out.println("����");
            break;
		case SUMMER:
            System.out.println("����");
            break;
        case AUTUMN:
            System.out.println("����");
            break;
        case WINTER:
            System.out.println("����");
            break;
		}
	}

}