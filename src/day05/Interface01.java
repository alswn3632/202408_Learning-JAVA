package day05;

interface Power {
	void turnOn();
	void turnOff(); // 추상 키워드 안써도 괜찮음

}

interface Remocon {
	void volUp();
	void volDown();
	
}

// 구현 : class Tv implements Power
// 상속 : class Tv extends A implements B,C {  }
class Tv implements Power, Remocon {
	private boolean power;
	private int vol;
	private int ch;
	
	// 재정의한 것
	@Override
	public void turnOn() {
		// 전원 켜기
		power = true;
		System.out.println("전원이 켜졌습니다.");
	}

	@Override
	public void turnOff() {
		// 전원 끄기
		power = false;
		System.out.println("전원이 꺼졌습니다.");		
	}

	@Override
	public void volUp() {
		vol++;
		System.out.println("볼륨:" + vol);
	}

	@Override
	public void volDown() {
		vol--;
		System.out.println("볼륨:" + vol);		
	}
	
	// 내가 구현한 것
	public void chUp() {
		ch++;
		System.out.println("채널:" + ch);
	}
	
	public void chDown() {
		ch--;
		System.out.println("채널:" + ch);
	}
	
}

public class Interface01 {

	public static void main(String[] args) {
		/* 인터페이스 : 추상메서드와 상수(final)로만 이루어진 것
		 * 추상메서드 : 메서드의 선언부만 있고 구현부가 없는 메서드
		 *  추상메서드가 포함되어있는 추상크래스/인터페이스 => 반드시 구현해야 객체를 생성할 수 있음
		 * 
		 * 인터페이스 키워드 : interface
		 * - 추상클래스는 대부분 상속을 하기위해 사용함. 인터페이스는 메뉴얼화, 상속을 하기 위해 사용
		 * - 기능 요약서라도고 함
		 * - 팀 작업, 유지보수를 위해 필수적이다.
		 * - 상속 키워드 : extends, 구현 키워드 : implements
		 * - 인터페이스는 멤버변수를 포함하지 않기 때문에 이 부분을 염두해 두고 메서드 정리를 해야함.
		 * 
		 * - 상속 : 다중상속이 불가능
		 * - 구현 : 다중구현이 가능**
		 * - 상속 + 구현을 동시에 할 수 있다.
		 */
		
		Tv t = new Tv();
		t.turnOn();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.chUp();
		t.chUp();
		t.chUp();
		t.chDown();
		t.chDown();
		t.chDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.turnOff();
	
		
	}

}
