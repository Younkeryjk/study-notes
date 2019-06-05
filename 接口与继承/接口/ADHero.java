package charactor;

/**
 * @author Younker
 *
 * 2019年5月11日
 */
public class ADHero extends Hero implements AD{
	@Override
	public void physicAttack() {
		 System.out.println("进行物理攻击");
	}
}
