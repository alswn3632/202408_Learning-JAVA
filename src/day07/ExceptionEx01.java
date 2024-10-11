package day07;

/* 보통 메서드에서는 try catch를 사용하지 않음. 상황에 따라 다르게 사용될 수 있기 때문에
 * 따라서 Throws를 이용해 예외를 떠넘기고 그걸 받는 쪽에서 try catch를 통해 예외를 처리하게 된다.
 * 
 */

public class ExceptionEx01 {

	public static void main(String[] args) {
		// 리턴 받은 배열을 출력 
		ExceptionEx01 ex01 = new ExceptionEx01();
		int arr[] = null;
		
		System.out.println("시작");
		try {
			ex01.method1(5, 1, 45);
			ex01.method1(-1, 1, 45);
			ex01.method1(5, 1, 0);
			ex01.method2(arr, 1, 45);
			
		}catch(Exception e) {
			//예외 처리 작성
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("종료");
		
	}
	
	/* 메서드1
	 * 기능 : Size를 입력받아(매개변수) size 만큼의 길이를 가지는 배열을 생성하여
	 * 		 랜덤 값을 채워서 배열을 리턴하도록 함
	 * 
	 * 랜덤값은 범위를 매개변수로 받아 start(시작값), count(개수)
	 * - size가 0보다 작으면 예외 발생
	 * - 랜덤값의 개수가 0이면 예외 발생 >> 얘를 가진 랜덤값 생성기 만들어도 될듯
	 */
	
	public int random(int start, int count) throws RuntimeException{
		// count가 0일 경우 예외 처리
		if(count == 0) {
			throw new RuntimeException("개수가 0일 수 없습니다.");
		}
		
		int tmp = 0;
		tmp = (int)(Math.random()*count) + start;
		
		return tmp;		
		
	}
	
	public void arrPrinter(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public int[] method1(int size, int start, int count) throws RuntimeException{
		// size가 0보다 작을 경우 예외 발생
		
		if(size < 0) {
			throw new RuntimeException("배열의 크기가 0보다 작을 수 없습니다.");
		}
		
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = random(start,count);
		}
		arrPrinter(arr);
		return arr;
	}
	

	/* 메서드2
	 * 기능 : 매개변수로 배열을 받아 랜덤값을 채우는 메서드
	 * 랜덤값은 범위를 매개변수로 받아 start(시작값), count(개수)
	 * - size가 0보다 작으면 예외 발생
	 * - 배열이 null이면 예외 발생
	 * - 배열의 길이가 0보다 작으면 예외발생 >> 테스트는 안될듯
	 */
	
	public void method2(int[] arr, int start, int count) throws RuntimeException{
		// 들어온 arr이 null일 경우 예외 발생
		
		if(arr == null) {
			throw new RuntimeException("null에 뭘 채우라는거니");
		}
		
		if(arr.length < 0) {
			throw new RuntimeException("배열의 크기가 0보다 작을 수 없습니다.");
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = random(start,count);
		}
		
		arrPrinter(arr);

	}
}


//class A extends ExceptionEx01{
//	
//}