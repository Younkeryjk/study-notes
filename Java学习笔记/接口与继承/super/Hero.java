package charactor;
 
import property.Item;
 
public class Hero {
        
    String name; //姓名
        
    float hp; //血量
        
    float armor; //护甲
        
    int moveSpeed; //移动速度
     
    public void useItem(Item i){
        System.out.println("hero use item");
        i.effect();
    }
     
    public Hero(){
        System.out.println("Hero的无参的构造方法 ");
    }
     
    public Hero(String name){
        System.out.println("Hero的有一个参数的构造方法 ");
        this.name = name;
    }
    public int getMoveSpeed(){
        return this.moveSpeed;
    }
    public static void main(String[] args) {
        new Hero();
    }
      
}