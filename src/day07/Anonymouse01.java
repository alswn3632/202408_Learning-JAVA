package day07;

interface Power {
	void turnOn();
	void turnOff();
}

//class Tv implements Power{
//
//	@Override
//	public void turnOn() {
//		System.out.println("전원이 켜집니다.");
//		
//	}
//
//	@Override
//	public void turnOff() {
//		System.out.println("전원이 꺼집니다.");
//
//	} 
//	
//}

public class Anonymouse01 {

	public static void main(String[] args) {
		/* 익명 클래스(Anonymouse Class) : 내부 클래스의 일종
		 * - 인터페이스를 이용하여 객체를 생성할 때, 클래스를 구현하여 객체를 생성
		 * 익명 클래스를 사용하는 이유
		 * - 인터페이스의 기능이 적고, 그 객체가 1개만 필요한 경우
		 * 
		 * 메서드로 매개변수의 값이 들어와야 할때 익명클래스를 사용함
		 */
//		Tv t = new Tv(); //Power를 구현한 클래스이기 때문에 업캐스팅이 가능
		Anonymouse01 a = new Anonymouse01();
//		a.product(t);

		a.product(new Power() {

			@Override
			public void turnOn() {
				System.out.println("익명클래스/전원이 켜집니다.");
				
			}
		
			@Override
			public void turnOff() {
				System.out.println("익명클래스/전원이 꺼집니다.");
				
			}
			
		});
		// 쓸 때 마다 이렇게 구현해줘야한다면 아까 처럼 Tv 클래스 만들어 사용하고
		// 한 번 만 사용할 경우는 위와 같이 사용해준다! 
		
	}
	
	public void product(Power p) {
		p.turnOn(); //켜짐
		System.out.println("정상작동중..");
		p.turnOff(); //꺼짐
		
	}

}

//외부 클래스(outer class) : 외부 클래스 바깥 클래스
class A {
	//내부 클래스(inner class)
	private class B {
		//내부 클래스를 사용하는 이유
		//A클래스에서만 필요한 클래스를 생성하기 위해 사용함
	}
}
