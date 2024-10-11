package day09;

// 제네릭의 타입값은 대문자로 쓰는 것이 규칙

public class Sale<K,V> {
	//멤버변수
	private K id;
	private V menu;
	private int price;
	
	//생성자
	public Sale() {
		
	}
	
	public Sale(K id, V menu, int price) {
		this.id = id;
		this.menu = menu;
		this.price = price;
	}

	//자동생성
	@Override
	public String toString() {
		return "Sale [" + id + ". " + menu + ": " + price + "]";
	}
	
	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public V getMenu() {
		return menu;
	}

	public void setMenu(V menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
