package charactor;
 
public class Hero implements Comparable<Hero>{
    public String name;
    public float hp;
 
    public int damage;
 
    public Hero() {
 
    }
 
    public Hero(String name) {

        this.name = name;
    }
 
 	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	}

	public Hero(String name, int hp, int damage) {
    	this.name = name;
    	this.hp = hp;
    	this.damage = damage;
	}

	@Override
	public int compareTo(Hero o) {
		if (damage < o.damage)
			return 1;
		else
			return -1;
	}
 
}
