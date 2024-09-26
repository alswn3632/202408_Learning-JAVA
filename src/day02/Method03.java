package day02;

import java.util.Scanner;

public class Method03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* <문제>
		 * 구구단 : 정수 하나를 주면 해당 정수의 구구단을 출력하는 메서드
		 */
		Method03 m = new Method03();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("구구단 시작!");
		System.out.print("단 수 입력: ");
		int num = scan.nextInt();
		m.gugu(num);
	}
	
	public void gugu(int num) {
		if(num < 0) {
			System.out.println("양의 정수만 가능합니다.");
		}else {
			for(int i=1; i<10; i++) {
				System.out.println(num + "X" + i + "=" + (num*i));
			}
		}
	}

}
