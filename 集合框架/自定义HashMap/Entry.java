package collection;

public class Entry {

	public Object key;
	public Object value;
	public Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}
	

}
