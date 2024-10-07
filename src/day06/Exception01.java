package day06;

public class Exception01 {

	public static void main(String[] args) {
		// RuntimeException : 실행 예외 클래스
		// Error : 시스템이 종료되어야할 수준의 상황과 같이 수습할 수 없는 심각한 문제
		// >> error는 개발자 입장에서 미리 예측 방지할 수 없음
		
		/* Exception : 예외
		 * 개발자가 코드 구현시 발생할 수 있는 에러를 예외라고 함
		 * 예외처리 : 예외를 개발자가 처리하는 구문
		 * 예외가 발생하면 예외 발생 시점부터 코드는 중지 => 예외문구 출력
		 * 예외처리 => 예외가 발생할 수 있는 값만 빼고 나머지는 정상처리로 유지시키기 위한 기능
		 * try ~ catch
		 * try ~ catch ~ finally
		 * try : 예외가 발생할 가능성이 있는 구문 작성
		 * catch : try 구문에서 발생한 예외를 처리
		 * finally : try 구문과 상관없이 반드시 처리되어야하는 구문을 작성(생략가능) 
		 */
		
		try {
			System.out.println(1);
			System.out.println(2);
			System.out.println(1/0); // 얜 나올 수 없지!
		}catch(Exception e) {
			e.printStackTrace(); // 실제 예외 구문을 콘솔에 출력
			System.out.println("예외가 발생했습니다~!~!");
		}
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		System.out.println(7);

	}

}
