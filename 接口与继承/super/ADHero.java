package charactor;

import property.Item;
import property.LifePotion;

public class ADHero extends Hero {
	int moveSpeed=400; //移动速度
    public ADHero(){
    	//super();
    	System.out.println("AD Hero的无参构造方法");
    }
    public ADHero(String name){
        super(name);
        System.out.println("AD Hero的构造方法");
    }
    public int getMoveSpeed(){
        return this.moveSpeed;
    }
     
    public int getMoveSpeed2(){
        return super.moveSpeed;
    }
    public void useItem(Item i) {
        System.out.println("adhero use item");
        super.useItem(i);
    }
 
    public static void main(String[] args) {
    	ADHero h= new ADHero();
    	LifePotion lp = new LifePotion();
    }
 
}
