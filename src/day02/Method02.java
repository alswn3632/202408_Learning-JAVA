package day02;

public class Method02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// <문제>
		// 사칙연산 각각의 메서드 생성
		Method02 m = new Method02();
		System.out.println("메서드 확인");
		m.sum(20, 10);
		m.sub(20, 10);
		m.mul(20, 10);
		m.div(20, 10);
		m.res(20, 3);
		System.out.println("오류 확인");
		m.div(20, 0);
		m.res(20, 0);
	}
	
	public int sum(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a + b));
		return a+b;
	}
	public int sub(int a, int b) {
		System.out.println(a + "-" + b + "=" + (a - b));
		return a-b;

	}
	public int mul(int a, int b) {
		System.out.println(a + "X" + b + "=" + (a * b));
		return a*b;
	}
	public double div(int a, int b) {
		if(b != 0) {
			System.out.println(a + "/" + b + "=" + ((double)a / b));	
			return (double)a/b;
		}else if(b == 0){
			System.out.println("오류 : 0으로 나눌 수 없음.");
			return 0;
		}
		return 0;
	}
	public int res(int a, int b) {
		if(b != 0) {
			System.out.println(a + "%" + b + "=" + (a / b));		
			return a%b;
		}else if(b == 0){
			System.out.println("오류 : 0으로 나눌 수 없음.");
			return 0;
		}
		return 0;
	}

}
