package charactor;
  
public class ADHero extends Hero{
  
     
    //���ظ����battleWin����
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }   
     
    public static void main(String[] args) {
    	//Hero.battleWin();//hero battle win
    	//ADHero.battleWin();//ad hero battle win
    	Hero h =new ADHero();
    	h.battleWin(); //hero battle win
    }
  
}