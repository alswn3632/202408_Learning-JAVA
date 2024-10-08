package day07;

public class Exception04 {

	public static void main(String[] args) {
		/* 멀티 캐치 구문, 다중 캐치 구문
		 * try{
		 * 
		 * }catch(예외클래스명1 객체){
		 * 
		 * }catch(예외클래스명2 객체){
		 * 
		 * }
		 * 
		 * 예외를 구체적으로 세분화하여 잡고싶을 때 => 멀티캐치 
		 * 
		 */
		
		double res = 0;
		
		try {
			int arr[] = null;
			arr[1] = 3;
			int arr1[] = new int [3];
			arr1[5] = 3;
			res = 1/0;
		} catch(NullPointerException e) {
			System.out.println("객체가 null 입니다.");
			e.printStackTrace();
		} catch(ArithmeticException e) {
			System.out.println("0으로 나누었습니다.");
			e.printStackTrace();
		} catch(Exception e){
			// 최고 조상은 가장 마지막에 처리
			e.printStackTrace();
		}
		
		System.out.println("종료");
		
	}

}
