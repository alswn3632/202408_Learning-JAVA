package lotto;

import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
		// 로또 프로그램
		/* --menu--
		 * 1. 사용자 로또 번호 생성 (수동) : 사용자가 직접 번호 입력
		 * 2. 사용자 로또 번호 생성 (자동) : Math.Random() 사용해서 
		 * 3. 당첨 번호 입력 (수동,자동) : 사용자가 직접 입력 // 일단 수동만
		 * 4. 당첨 확인 : 가장 마지막에 발행한 당첨 번호로 확인
		 * 5. 역대 당첨 번호 목록 확인
		 * 6. 종료
		 * 
		 * - 로또는 상속하여 사용
		 * 
		 * Lotto class : 사용자 번호(6자리)를 저장하는 클래스
		 * - 6자리 배열을 넣는 클래스 (중복X), 출력 메서드
		 * - ex. 1회차 1 2 3 4 5 6
		 * LottoExtend class : 당첨 번호(7자리) 클래스, Lotto를 상속 + 보너스 번호
		 * - ex. 1회차 1 2 3 4 5 6 [7]
		 * LottoController : 처리
		 * LottoMain : 출력 
		 */
		
		LottoController lc = new LottoController();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do {			
			System.out.println("---------------------------------------------------------------");
			System.out.println("1. 자동 2. 수동 3. 당첨번호 입력 4. 당첨확인 5. 역대 당첨번호 목록 6. 종료");
			System.out.print("menu: ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1 :
				lc.createUser1();
				break;
			case 2 : 
				lc.createUser2(scan);
				break;
			case 3 : 
				lc.createWinner(scan);
				break;
			case 4 : 
				lc.jackpot();
				break;
			case 5 : 
				lc.winnerList();
				break;
			case 6 :
				System.out.println("종료합니다.");
				break;
			default : 
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu != 6);
		
		
		scan.close();
	
		
	}

}
