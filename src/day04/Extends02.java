package day04;

class Animal{
	// 동물의 이름과 종류를 나타내는 클래스
	// 메서드 : 이름과 종류를 출력, 동물의 울음소리를 출력
	private String name;
	private String category;
	
	public Animal(){
		
	}

	public Animal(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	//메서드
	public void printInfo() {
		System.out.println("이름:" + name + ", 종류:" + category);
	}
	
	public void howl() {
		System.out.println("-+-" + name + "의 울음소리-+-");
		// 자식이 구현
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}

// Dog, Car : Animal 클래스를 상속받아 생성
// printInfo() / howl() : 오버라이딩 후 본인의 울음소리를 추가하여 출력
class Dog extends Animal{
	private String howl = "멍";
	
	public Dog() {
		super();
	}
	
	public Dog(String name, String category) {
		super(name,category);
	}

	@Override
	public void howl() {
		super.howl();
		System.out.println(">> " + howl);
	}
	
	
}

class Cat extends Animal{
	private String howl = "냥";
	
	public Cat() {
		super();
	}
	
	public Cat(String name, String category) {
		super(name,category);
	}
	
	@Override
	public void howl() {
		super.howl();
		System.out.println(">> " + howl);
	}
	
}

class Raccoon extends Animal{
	private String howl = "그루트!";
	
	public Raccoon() {
		super();
	}
	
	public Raccoon(String name, String category) {
		super(name,category);
	}
	
	@Override
	public void howl() {
		super.howl();
		System.out.println(">> " + howl);
	}
	
}


public class Extends02 {

	public static void main(String[] args) {
		// 오버라이딩 : 부모 클래스의 메서드를 재정의 하여 사용하는 것
		// - 부모 클래스의 메서드와 선언부가 일치해야함 { 괄호 안 구현만 재정의 가능. }
		// - 접근제한자는 더 넓은 범위만 가능하고 축소할 수 없음
		
		Dog d = new Dog("바둑이", "강아지");
		d.printInfo();
		d.howl();
		
		Cat c = new Cat("삼색이", "고양이");
		c.printInfo();
		c.howl();
		
		Raccoon r = new Raccoon("로켓", "북미라쿤");
		r.printInfo();
		r.howl();
		
	}

}
