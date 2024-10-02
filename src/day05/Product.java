package day05;

public class Product {
	//멤버변수
	private String name;
	private int price;
	
	//생성자
	public Product() {
		
	}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	//메서드
	public void setProduct(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void printProduct() {
		System.out.println(name + "(" + price + "원)" );
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
