package day06;

public class Exception03 {

	public static void main(String[] args) {
		/* 자주 발생하는 예외 코드들
		 * ArithmeticException : 0으로 나누었을 때 발생
		 * ArrayIndexOutOfBoundsException : 배열의 index가 범위를 벗어났을 때 발생
		 * NullPointerException : 객체의 값이 null일 경우, 혹은 객체 자체가 없을 경우
		 * ClassCastException : 다운 캐스팅이 잘못 되었을 경우  >> 자주 등장함
		 */
		
//		int arr[] = null;
		int arr[] = new int[5];
		for(int i=0; i<=arr.length; i++) {
			System.out.println(arr[i]);
		}
		

	}

}
