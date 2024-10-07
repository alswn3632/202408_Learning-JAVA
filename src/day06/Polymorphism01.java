package day06;

/* 객체 지향 프로그램 4가지의 특징 
 * - 프로그램을 독립된 단위(객체)의 객체들을 모아서 관계를 맺어 처리하는 형태 
 * - 각각의 객체는 메세지를 주고 받으면서 데이터를 처리
 * - 메세지를 받을 경우(매개변수를 통해) / 메세지를 주는 경우(return)
 * - 추상화, 캡슐화(정보은닉), 상속, 다형성
 * 
 * 1. 추상화(Abstraction) : 핵심적인(공통적인) 코드만 보여줌
 * - 구현된 부분과 구현되지 않은 부분으로 분리
 * - 개인(자식)이 구현해야할 부분은 분리하여 처리
 * - 불필요한 부분을 숨겨준다는 의미로 쓰이기도 함
 * 
 * 2. 캡슐화(Encapsulation) : 데이터 보호(정보은닉)
 * - 멤버변수(private)를 숨기는 형태, 메서드로 접근
 * - 멤버변수와 메서드를 하나로 묶어 처리하는 형태
 * - 은닉화 : 객체의 내부의 정보를 숨겨 외부로 드러나지 않게 보호 하는 것
 * 
 * 3. 상속(Inheritance) : 코드 재사용(확장)
 * - 클래스를 상속받아서 수정하면 중복 코드를 줄일 수 있음
 * - 유지보수가 편함
 * 
 * 4. 다형성(Polymorphism) : 객체 변환이 용이함
 * - 하나의 코드가 여러 객체의 형태로 구현되어 실행되는 것
 * - 코드는 같은데 들어오는 객체에 따라 다른 실행 결과를 얻을 수 있음
 * - 다형성을 잘 활용하면 유연하고 확장성 있는 유지보수가 편한 프로그램을 만들 수 있음
 */

class Animal {
	// 공통적인 속성
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal {
	
	@Override
	public void move() {
		System.out.println("사람은 두 발로 걷습니다.");
	}
	
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
	
}

class Tiger extends Animal {

	@Override
	public void move() {
		System.out.println("호랑이가 네 발로 어슬렁거립니다.");
	}
	
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
	
}

class Eagle extends Animal {

	@Override
	public void move() {
		System.out.println("독수리가 하늘을 날아다닙니다.");
	}
	
	public void flying() {
		System.out.println("독수리가 날카로운 눈으로 날아다니며 사냥합니다.");
	}
	
}

class Dog { // 상속 받지 않은 클래스
	
	public void move() {
		System.out.println("강아지가 아장 아장 걷습니다.");
	}
}

public class Polymorphism01 {
	
	public static void main(String[] args){
		// Human, Tiger, Eagle 객체 생성
		
		Human human = new Human(); // 내 객체로 나를 생성하는 것
		human.move();
		human.readBook();
		System.out.println("----------------------------------");
		Tiger tiger = new Tiger();
		tiger.move();
		tiger.hunting();
		System.out.println("----------------------------------");
		Eagle eagle = new Eagle();
		eagle.move();
		eagle.flying();
		System.out.println();
		System.out.println("------조상 객체로 자식 객체를 생성------");
		Animal hAnimal = new Human(); // 조상(Animal)의 객체로 자식(Human) 생성
		// 조상에게 상속받은 메서드만 실행 가능
		hAnimal.move(); // 사용 가능
		// hAnimal.readBook(); 사용 불가능 (공통되지 않음)
		Animal tAnimal = new Tiger();
		tAnimal.move();
		
		Animal eAnimal = new Eagle();
		eAnimal.move();
		
		// Human h = new Animal(); 자식 객체로 부모 객체를 생성하는 것은 불가능
		
		System.out.println();
		System.out.println("----------다형성 메서드 예시----------");
		Polymorphism01 ex01 = new Polymorphism01();
		// 처음부터 부모의 객체로 생성되었기 때문에 당연히 가능한 것
		ex01.moveAnimal(hAnimal); 
		ex01.moveAnimal(tAnimal); 
		ex01.moveAnimal(eAnimal); 
		// 내 객체로 생성되었다 하더라도 자동으로 형 변환이 이루어짐 (다형성)
		ex01.moveAnimal(human);
		ex01.moveAnimal(tiger);
		ex01.moveAnimal(eagle);
		
		Dog dog = new Dog();
		dog.move(); // 메서드명이 같더라도 이 move는 Dog만의 move임
		// ex01.moveAnimal(dog); Animal을 상속받지 않기 때문에 불가능한 것
		
		System.out.println();
		System.out.println("--------Animal 배열 생성 예시--------");
		int cnt = 0;
		Animal[] aniList = new Animal[5];
		aniList[cnt] = hAnimal;
		cnt++;
		aniList[cnt] = tAnimal;
		cnt++;
		aniList[cnt] = eAnimal;
		cnt++;
		
		for(int i=0; i<cnt; i++) {
			aniList[i].move();
		}
		
		System.out.println();
		System.out.println("-----------다운 캐스팅 예시-----------");
		// Human 클래스 객체에 Animal을 상속 받은 Human 클래스 객체를 다운 캐스팅한 예시
		Human h = (Human)hAnimal;
		h.readBook(); // 아까는 readBook을 사용할 수 없었지만 (공통으로 가지고있지 않아서) 지금은 쓸 수 있지요!
		
		// Human h1 = (Human)tAnimal;
		// h1.readBook(); 
		// 빨간 밑줄이 그어지지 않았지만 실행해보면 ClassCastException 에러가 발생함
		
		// instanceof 연산자로 확인하여 실행해보면 누구로부터 만들어졌는지 확인할 수 있다.
		System.out.println();
		System.out.println("--------instanceof 연산자 사용--------");
		System.out.println(tAnimal instanceof Human); 
		System.out.println(tAnimal instanceof Tiger); 
		System.out.println(hAnimal instanceof Human); 
		
		Animal downCasingTest = eAnimal;
		downCasingTest.move();
		// downCasingTest.flying();
		if(downCasingTest instanceof Human) {
			// ((Human) downCasingTest).readBook(); // 괄호 꼭 넣어줘야함!
			// 위 방법을 풀어서 표현한 것이 아래
			Human testHuman = (Human)downCasingTest;
			testHuman.readBook();
		}else if(downCasingTest instanceof Eagle) {
			((Eagle) downCasingTest).flying();
		}else if(downCasingTest instanceof Tiger) {
			((Tiger) downCasingTest).hunting();
		}else {
			System.out.println("다운캐스팅 실패");
		}
	}
	
	// 다형성 메서드 예시 (업캐스팅 : 자동형변환가능)
	public void moveAnimal(Animal animal) {
		animal.move();
		
		if(animal instanceof Human) {
			((Human)animal).readBook();
		}else if(animal instanceof Tiger) {
			((Tiger)animal).hunting();
		}else if(animal instanceof Eagle) {
			((Eagle)animal).flying();
		}else {
			System.out.println("다운캐스팅 실패");
		}
	}
	
}
