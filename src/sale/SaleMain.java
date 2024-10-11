package sale;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		// 키오스크
		/* menu
		 * 1.메뉴추가|2.메뉴삭제|3.메뉴수정(가격수정)
		 * 4.메뉴보기(전체메뉴보기)|5.주문|6.주문내역출력(영수증)
		 * 7.전체 판매 내역|8.종료
		 * 
		 * 1,2,3,7 > 관리자용
		 * 4,5,6 > 사용자용
		 * 
		 * Menu Class 생성 >> 메뉴 1개에 대한 정보
		 * 제품ID, 제품명, 가격
		 * 
		 * Order Class 생성 Menu 상속 >> 한 주문에 대한 정보
		 * 주문번호, 제품ID, 제품명, 수량, 가격, 금액
		 * 
		 * 1. 관리자가 제품에 대한 정보를 입력
		 * 2. 주문자가 제품을 주문(제품ID, 수량)
		 * 3. 주문ID에 해당하는 Menu를 찾아서 이름과 가격 가져오기
		 * 4. Order 클래스에 제품ID, 제품명, 수량, 수량*가격 저장
		 * */
		SaleController sc = new SaleController();
		Scanner scan = new Scanner(System.in);
		
//		Menu a1 = new Menu(1,"a",1);
//		Menu a2 = new Menu(1,"a",1);
//		System.out.println(a1==a2);
		
		//미리 메뉴 몇가지 추가해서 메서드 호출
		sc.addMenu();
		
		int menu = -1;
		
		do {
			System.out.println("-------------------키오스크-------------------");
			System.out.println("1.메뉴추가 2.메뉴삭제 3.메뉴수정(가격수정) 4.메뉴보기(전체메뉴보기)");
			System.out.println("5.주문 6.주문내역출력(영수증) 7.전체 판매 내역 8.종료");
			System.out.print(">> ");
			
			menu = scan.nextInt();
			System.out.println();
			switch(menu) {
			case 1 : 
				sc.add(scan);
				break;
			case 2 : 
				sc.delete(scan);
				break;
			case 3 : 
				sc.update(scan);
				break;
			case 4 : 
				sc.printMenu();
				break;
			case 5 : 
				sc.orderPick(scan);
				break;
			case 6 : 
				sc.orderPrint(scan);
				break;
			case 7 : 
				sc.totalOrder();
				break;
			case 8 : 
				System.out.println("종료합니다.");
				break;
			default :
				System.out.println("잘못된 입력입니다.");
			}
			
		}while(menu != 8);
		
		scan.close();
		
	}

}
