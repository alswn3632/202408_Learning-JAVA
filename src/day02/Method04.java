package day02;

public class Method04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* <메서드 오버로딩>
		 * 동일한 이름의 메서드를 여러개 만드는 케이스
		 * 
		 * [오버로딩의 조건]
		 * 1. 매개변수의 개수가 달라야함
		 * 2. 매개변수의 타입이 달라야함
		 * - 리턴 타입, 매개변수의 이름은 상관이 없음
		 */
		
		/* <가변인자 메서드>
		 * - ... 배열처럼 받을 수 있는 메서드
		 * - 매개변수의 개수가 고정되지 않은 케이스 
		 * 
		 */
		
		Method04 m = new Method04();
		System.out.println(m.sum(1, 3));
		System.out.println(m.sum(1, 3, 5));		
		System.out.println(m.sum2(1,2,3,4,5,6,7,8,9,10));
		
		Test1 t = new Test1();
		t.print();
	}
	
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	public int sum2(int ...num) {
		int result = 0;
		for(int tmp : num) {
			result += tmp;
		}
		return result;
	}

}
