package day02;

public class Class01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 클래스 : 객체를 생성하기 위한 설명서
		 * 객체를 생성(new)해야 사용이 가능.
		 * Lotto l = new Lotto(); //Lotto 클래스에서 객체를 생성 / 객체명 => l
		 * 
		 * 클래스 : 객체를 생성하기 위한 설명서
		 * 객체 : 실제 사용되는 제품
		 * 메서드 : 기능
		 * 멤버변수 : 객체의 변수
		 * 
		 * 클래스 구성요소 : 멤버변수, 메서드
		 * 
		 * 프린터 클래스 생성
		 * - 멤버변수 : 크기, 색, 제조사, 제품명, 종류 ... 등
		 * - 메서드(기능) : 출력, 복사, 스캔, 팩스
		 * 
		 * 클래스 생성 방법
		 * class 클래스명{
		 *     멤버변수;
		 *     메서드();
		 *     메서드();
		 *     메서드();
		 * } 
		 * 
		 * 객체 생성 방법
		 * - 클래스명 객체명 = new 클래스명();
		 * - 클래스명 객체명; >> 선언만
		 * 
		 * 메서드 사용법
		 * 같은 클래스 안에서 메서드를 호출할 경우 => 메서드명();
		 * 다른 클래스에서 메서드를 호출할 경우 => 객체명.메서드명();
		 * 단, static은 같은 클래스든 아니든 무조건 메서드명();
		 * 
		 * 클래스에 public을 붙일 수 있는건 파일명과 클래스명이 같을 경우만 가능
		 * >> .java 파일 하나에 하나의 클래스만 있을 수 있는건 아니다. 여러개 넣을 수 있음
		 * - 멤버변수와 메서드는 public 상관 없음.
		 * - 일반적으로 각 클래스의 멤버변수는 private이 원칙/ method는 public이 일반적
		 * - private는 내 클래스에서만 사용 가능 (다른 클래스에서는 접근 불가능)
		 * - private로 선언된 멤버변수에 접근하기 위해서는 getter, setter가 필요하다.
		 * 
		 * - 접근제한자
		 * private : 나 (내 클래스)
		 * (default) : 나 + 패키지
		 * protected : 나 + 패키지 + 상속받는 자식클래스
		 * public : 모두
		 */
		
		Test1 t = new Test1();
		t.print();
//		t.a = 3;
//		t.b = 1;
		t.setA(3);
		t.print();
	}

}

/*public*/ class Test1{
	// 멤버변수 위치
	// 멤버변수는 초기갑슬 설정하지 않아도 자동 설정됨
	// 숫자는 0 문자는 null
	private int a;
	private int b;
	
	public void print() {
		System.out.println(a+"-"+b);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	// getter, setter 메서드 생성
	// getter : 멤버변수의 값을 리턴하는 메서드
//	public int getA() {
//		return this.a; // this 멤버변수를 의미하는 키워드
//	}
//	public int getB() {
//		return this.b; // this 멤버변수를 의미하는 키워드
//	}
	
	// setter : 멤버변수에 값을 설정하는 메서드
//	public void setA(int a) {
//		this.a = a;
//	}
//	public void setB(int a) {
//		this.b = a;
//	}
	
	// getter, setter 자동으로 생성할 수 있음
	// 우클릭 > source > generate getters and setters
	
}
