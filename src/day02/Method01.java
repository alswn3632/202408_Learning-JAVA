package day02;

public class Method01 {
	// 메서드 선언 가능
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* <메서드(Method) : function 기능(함수)>
		 * 
		 * [메서드 선언 및 구현]
		 * 접근제한자(제어자) 리턴타입 메서드명(매개변수){
		 *     기능구현;
		 * }
		 * 
		 * [용어 정리]
		 * - 접근제한자(제어자) : 접근할 수 있는 주체의 제한 범위
		 * - 리턴타입 : 리턴할 값의 타입(타입으로만 기재)
		 * - void :  리턴값이 없다는 것을 의미함
		 * - 메서드명 : 소문자로 시작
		 * - 매개변수 : 기능을 수행하기 위해 필요로 하는 값(외부에서 들어와야 하는 값)
		 * 
		 * [메서드 선언 위치]
		 * - 클래스 안, 다른 메서드 밖
		 * - 메서드의 선언 순서는 상관없음
		 * - 메서드는 순서대로 실행되는 것이 아니라 호출되어야 실행됨
		 * - 메서드의 호출은 다른 메서드에서도 가능, 다른 클래스의 메서드에서도 가능함(접근권한만 된다면)
		 * 
		 * [접근 권한]
		 * - public : 모두 사용 가능
		 * - protected : 나(내 클래스), 내 패키지, 자식 클래스(상속을 위해서 사용)
		 * - default : 나, 내 패키지에서만 사용가능(생략가능)
		 * - private : 나
		 * - private < default < protected < public
		 */
		
		System.out.println(sum(1,2));
		// static 없는 메서드 호출
		Method01 m = new Method01();
		System.out.println(m.sum2(1, 3));
		// 리턴이 없는 버전
		m.sum3(1,4);
		
		// static을 붙이는 것이 당장 사용하기에는 용이하지만, 전체 공용으로 메서드를 만드는 것은 바람직하지 않다. 
	}
	// 메서드 선언 가능
	// <연습>
	// 두 정수의 값을 매개변수로 주고, 두 수의 합을 리턴하는 메서드
	public static int sum(int a, int b) {
		return a+b;
	}
	// static 없는 버전
	public int sum2(int a, int b) {
		return a+b;
	}
	// 리턴이 없는 버전
	public void sum3(int a, int b) {
		System.out.println(a+b);
	}
}
