package day02;

import java.util.Scanner;

public class MethodEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* <문제>
		 * --menu--
		 * 1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 5.나머지 6.종료
		 * > 메뉴선택 : 1
		 * > 숫자입력 : 1 5
		 * 결과 : 1 + 5 = 6
		 * (더하기 메서드를 호출하여 연산결과를 출력)
		 * 4,5번은 두번째 숫자가 0이면 0으로 나눌 수 없습니다. 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		Method02 m = new Method02();
		
		System.out.println("계산기를 시작합니다!");
		
		while(true) {
			System.out.println("-----------------menu-----------------");
			System.out.println("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 5.나머지 6.종료");
			
			System.out.print("메뉴선택: ");
			int menu = scan.nextInt();
			scan.nextLine(); //넘어간 엔터 처리
			int num1 = 0, num2 = 0;
			
			if(menu < 1 || menu > 6) {
				System.out.println("올바른 숫자를 입력해주세요.");
				continue;
			}else if(menu != 6) {
				System.out.print("숫자입력: ");
				String num = scan.nextLine();
				num1 = Integer.parseInt(num.substring(0,num.indexOf(" ")));
				num2 = Integer.parseInt(num.substring(num.indexOf(" ")+1));
				System.out.print("계산결과: ");
			}else if(menu == 6) {
				System.out.println("계산기를 종료합니다!");
				break;
			}
			
			switch(menu) {
			case 1 : 
				m.sum(num1,num2);
				break;
			case 2 : 
				m.sub(num1,num2);
				break;
			case 3 : 				
				m.mul(num1,num2);
				break;
			case 4 : 
				m.div(num1,num2);
				break;
			case 5 : 
				m.res(num1,num2);
				break;
			default : 
				System.out.println("오류");
			}
			
		}
		
		scan.close();
	}
	
}
