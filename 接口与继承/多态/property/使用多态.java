package charactor;
 
import property.Item;
import property.LifePotion;
import property.MagicPotion;
   
public class Hero {
    public String name;
    protected float hp;
 
    public void useItem(Item i){
        i.effect();
    }
 
    public static void main(String[] args) {
         
        Hero garen =  new Hero();
        garen.name = "¸ÇÂ×";
     
        LifePotion lp =new LifePotion();
        MagicPotion mp =new MagicPotion();
         
        garen.useItem(lp);
        garen.useItem(mp);     
         
    }
       
}