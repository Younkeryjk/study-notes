package charactor;
 
import property.LifePotion;
import property.MagicPotion;
   
public class Hero {
    public String name;
    protected float hp;
 
    public void useLifePotion(LifePotion lp){
        lp.effect();
    }
    public void useMagicPotion(MagicPotion mp){
        mp.effect();
    }
 
    public static void main(String[] args) {
         
        Hero garen =  new Hero();
        garen.name = "¸ÇÂ×";
     
        LifePotion lp =new LifePotion();
        MagicPotion mp =new MagicPotion();
         
        garen.useLifePotion(lp);
        garen.useMagicPotion(mp);
         
    }
       
}