package day04;

// 추상 클래스
abstract class Animal1 {
	protected String name;
	protected String category;
	
	// 일반 메서드
	public void printInfo() {
		System.out.println("이름:" + name + ", 종류:" + category);
	}
	
	// 추상 메서드
	abstract public void howl();
	
}

class Dog1 extends Animal1{
	private String eat;
	
	public Dog1() {
	
	}
	
	public Dog1(String name, String category) {
		super.name = name;
		super.category = category;
	}
	
	public Dog1(String name, String category, String eat) {
		super.name = name;
		super.category = category;
		this.eat = eat;
	}
	
	public void eating(String eat) {
		this.eat = eat;
		System.out.println(name + "은(는) " + eat + " 먹어용ㅋ-ㅋ");
	}

	@Override
	public void howl() {
		System.out.println("멍!");
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("먹이: " + eat);
	}
	
	
}




public class Abstract01 {

	public static void main(String[] args) {
		/* 추상 클래스 : 미완성 클래스, 추상 메서드를 포함하는 클래스
		 * 추상 클래스의 요소 : 멤버변수 + 상수(final) + 일반메서드 + 추상메서드
		 * 추상 클래스 : 객체를 생성할 수 없다. (미완성이기 때문에)
		 *  반드시 추상메서드를 구현하여 완성해야 객체를 생성할 수 있다.
		 * 추상 메서드 : 메서드의 선언부만 있고, 구현이 없는 메서드
		 * 추상 키워드 : abstract를 붙여주면 구현을 하지 않아도 에러가 발생하지 않음.
		 *  ex. 
		 *  	abstract class Animal{ }
		 *  	abstract public void howl(); //추상 메서드
		 *  - 추상 클래스에서 abstract 키워드는 반드시 포함해야 한다.
		 *  - 인터페이스는 추상 메서드를 포함해도 abstract 키워드 생략 가능.
		 *  - 추상 클래스는 상속을 하기 위한 부모 클래스를 만들 때 사용 
		 *  - 상속받은 클래스에 추상 메서드가 있다면 반드시 구현
		 * */
		
		Dog1 d = new Dog1("바둑이", "강아지");
		d.eating("사료");
		d.printInfo();
		d.howl();
	}

}
