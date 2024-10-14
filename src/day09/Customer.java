package day09;

public class Customer implements Comparable<Customer>{
	//멤버변수
	private String name;
	private int age;
	
	//생성자
	public Customer() {
		
	}
	
	// sorted를 기존 클래스에서 구현
	@Override
	public int compareTo(Customer o) {
		// this와 o 객체를 정렬하기
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
