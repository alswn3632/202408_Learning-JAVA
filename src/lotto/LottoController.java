package lotto;

import java.util.Scanner;

public class LottoController {
	Scanner scan = new Scanner(System.in);
	
	private Lotto[] userArr = new Lotto[10];
	private int userCnt;
	private LottoExtend[] winnerArr = new LottoExtend[10];
	private int winnerCnt;
	private int round = 1;
	private String[] rankStr = new String[10];
	private boolean toggle = false;

	//사용자 번호 자동 생성
	public void createUser1() {
		if(userCnt>=userArr.length) {
			Lotto [] newArr = new Lotto[userArr.length+10];
			System.arraycopy(userArr, 0, newArr, 0, userCnt);
			
			this.userArr = newArr;
		}
		
		if(toggle) {
			System.out.println(round-1 + "회차 복권 구매 마감입니다.");
			System.out.println("결과 확인 후 다음 회차로 넘어가 주세요!");
		}else {
			Lotto l = new Lotto();
			l.setLottoArr(l.createLotto());
			l.setRound(this.round);
			userArr[userCnt] = l;
			userCnt++;
			
			l.printLotto();
			System.out.println();			
		}
	}

	//사용자 번호 수동 생성
	public void createUser2(Scanner scan) {
		if(userCnt>=userArr.length) {
			Lotto [] newArr = new Lotto[userArr.length+10];
			System.arraycopy(userArr, 0, newArr, 0, userCnt);
			
			this.userArr = newArr;
		}
		
		if(toggle) {
			System.out.println(round-1 + "회차 복권 구매 마감입니다.");
			System.out.println("결과 확인 후 다음 회차로 넘어가 주세요!");
		}else {
			System.out.print("6개의 번호를 입력해주세요: ");
			String str = scan.next();
			String strArr[] = str.split(",");
			int intArr[] = new int[strArr.length];
			
			for(int i=0; i<strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i]);
				if(intArr[i]>45 || intArr[i]<=0) {
					System.out.println("숫자의 범위가 올바르지 않습니다.");
					return;
				}
			}
			
			Lotto l = new Lotto();
			l.setLottoArr(l.createLotto(intArr));
			
			if(l.verifyOver(intArr)) {
				System.out.println("중복된 숫자가 있습니다.");
			}else {
				l.setRound(this.round);
				userArr[userCnt] = l;
				userCnt++;
				
				l.printLotto();
				System.out.println();			
			}
		}
	}

	//당첨번호 수동 생성
	public void createWinner(Scanner scan) {
		if(winnerCnt>=winnerArr.length) {
			LottoExtend [] newArr = new LottoExtend[winnerArr.length+10];
			String [] newArr2 = new String[rankStr.length+10];
			System.arraycopy(winnerArr, 0, newArr, 0, winnerCnt);
			System.arraycopy(rankStr, 0, newArr2, 0, winnerCnt);
			
			this.winnerArr = newArr;
			this.rankStr = newArr2;
		}
		if(toggle) {
			System.out.println(round-1 + "회차 당첨 번호를 이미 뽑았습니다.");
		}else {
			System.out.print("6개의 번호를 입력해주세요: ");
			String str = scan.next();
			System.out.print("보너스 번호를 입력해주세요: ");
			int num = scan.nextInt();
			
			if(num>45 || num<=0) {
				System.out.println("숫자의 범위가 올바르지 않습니다.");
				return;
			}
			
			String strArr[] = str.split(",");
			int intArr[] = new int[strArr.length];
			
			for(int i=0; i<strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i]);
				if(intArr[i]>45 || intArr[i]<=0) {
					System.out.println("숫자의 범위가 올바르지 않습니다.");
					return;
				}
			}
			
			LottoExtend l = new LottoExtend();
			l.setLottoArr(l.createLotto(intArr));
			
			if(l.verifyOver(intArr)) {
				System.out.println("중복된 숫자가 있습니다.");			
			}else if(l.verifyOver(intArr, num)) {
				System.out.println("보너스 숫자가 중복됩니다.");
			}else {
				l.setRound(this.round);	
				l.setBonus(num);
				winnerArr[winnerCnt] = l;
				winnerCnt++;
				
				System.out.println(l.getRound() + "회차");
				l.printLotto();
				System.out.println();
				
				this.round++;
				toggle = true;
			}		
		}
	}

	//당첨 확인
	public void jackpot() {
		int rank1 = 0, rank2 = 0, rank3 = 0, rank4 = 0, rank5 = 0, rank6 = 0;
		System.out.println("------" + (round-1) + "회차 결과를 확인하겠습니다!------");
		System.out.println("--당첨번호--");
		winnerArr[round-2].printLotto();
		System.out.println("--사용자번호--");
		
		for(int f=0; f<userCnt; f++) {
			int cnt = 0;
			boolean op = false;
			
			for(int i=0; i<userArr[f].lottoArr.length; i++) {
				for(int j=0; j<winnerArr[round-2].lottoArr.length; j++) {
					if(userArr[f].lottoArr[i] == winnerArr[round-2].lottoArr[j]) {
						cnt++;
					}
				}
				if(userArr[f].lottoArr[i] == winnerArr[round-2].getBonus()) {
					op = true;
				}
			}

			switch(cnt){
				case 6:
					userArr[f].printLotto();
					System.out.println("1등입니다!"); rank1++; break;
				case 5:
					if(op) {
						userArr[f].printLotto();
						System.out.println("2등입니다!"); rank2++; break;
					}else {
						userArr[f].printLotto();
						System.out.println("3등입니다!"); rank3++; break;
					}
				case 4:
					userArr[f].printLotto();
					System.out.println("4등입니다!"); rank4++; break;
				case 3:
					userArr[f].printLotto();
					System.out.println("5등입니다!"); rank5++; break;
				default:
					userArr[f].printLotto();
					System.out.println("꽝 입니다!"); rank6++;
			}
		
		}		
		
		rankStr[winnerCnt-1] = "(1등:" + rank1 + ", 2등:" + rank2 + ", 3등:" + rank3 + ", 4등:" 
		+ rank4 + ", 5등:" + rank5 + ", 꽝:" +rank6 + "//총:" + userCnt + ")";

		toggle = false;
		userArr = new Lotto[10];
		userCnt = 0;
	}

	//당첨번호 목록 확인
	public void winnerList() {
		for(int i=0; i<winnerCnt; i++) {
			winnerArr[i].printLotto();
			System.out.println(">>" + rankStr[i]);
		}
	}
}
