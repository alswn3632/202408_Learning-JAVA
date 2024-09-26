package day01;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Scanner 클래스 : 콘솔에서 값을 입력받을 때 사용
		 * 값을 입력받으려면 Scanner scan = new Scanner(System.in);
		 * 
		 * (int)(Math.random()*개수)+시작 : 시작 값 부터 개수 만큼 정수형 랜덤 값 생성
		 */
		
		// 주사위 값 랜덤 발생
		int random = (int)(Math.random()*6)+1;
		System.out.println(random);
		
		// 랜덤으로 주사위를 굴려 총 30칸을 이동하시오.
		// 주사위 던진 횟수 출력
		/* 주사위 게임.
		 * 주사위는 enter를 치면 던져짐
		 * 도착하면 총 주사위 던진 횟수 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int total = 30;
		int cnt = 0;
		
		while(total > 0){
			System.out.print("주사위가 데구르르...");
			// scan.next();는 엔터를 처리할 수 없음
			scan.nextLine(); // 받은 값으로 할 게 없으니 변수에 담을 필요도 없겠죠?
			int num = (int)(Math.random()*6)+1;
			total = total - num;
			cnt++;
			if(total > 0){
				System.out.println(num + "칸 전진!! 남은 칸: " + total);
			}else {				
				System.out.println(num + "칸 전진!! 도착했습니다.");
			}
			System.out.println("--------------------");
		}
		
		System.out.println("주사위 굴린 횟수: " + cnt);
		
		scan.close();
		
		
	}

}
