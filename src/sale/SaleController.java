package sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleController {
	//멤버변수
	private int orderNum;
	private int menuId;
	private List<Menu> menu = new ArrayList<>();
	private List<Order> order = new ArrayList<>();
	
	public void addMenu() {
		// 기본 메뉴 추가 메서드
		menu.add(new Menu(++menuId, "김치찌개" , 9000));
		menu.add(new Menu(++menuId, "된장찌개" , 8000));
		menu.add(new Menu(++menuId, "순두부찌개" , 9000));
		menu.add(new Menu(++menuId, "부대찌개" , 10000));
		menu.add(new Menu(++menuId, "고추장찌개" , 7000));
	}
	
	public void add(Scanner scan) {
		// 메뉴 추가
		this.menuId++;
		System.out.print("메뉴명: ");
		String menu = scan.next();
		System.out.print("가 격: ");
		int price = scan.nextInt();
		this.menu.add(new Menu(menuId, menu, price));
		System.out.println(menu + "(" + price + ")" + " 추가되었습니다.");
	}

	public void delete(Scanner scan) {
		// 메뉴 삭제 : remove(index), remove(object)
		// remove(object) 사용이 불가능 why? 하나의 객체 요소로 그 객체가 전체 일치라고 볼 수 없음
		// equals 명령어 자체를 수정하면 가능함 
		System.out.print("삭제할 메뉴 번호: ");
		int delMenu = scan.nextInt();
		boolean ok = menu.remove(new Menu(delMenu));
		if(ok) {
			System.out.println("삭제완료");
		}else {
			System.out.println("찾는 메뉴가 없습니다.");
		}
//		for(int i=0; i<menu.size(); i++) {
//			if(menu.get(i).getMenuId() == delMenu) {
//				menu.remove(i); //index를 이용한 삭제
////				menu.remove(menu.get(i)); //object를 이용한 삭제
//				System.out.println("삭제 완료");
//				return;
//			}
//		}
//		System.out.println("찾는 메뉴가 없습니다.");
	}

	public void update(Scanner scan) {
		// 메뉴 수정
		System.out.print("수정할 메뉴 번호: ");
		int modMenu = scan.nextInt();
		System.out.print("수정할 가격: ");
		int modPrice = scan.nextInt();
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).getMenuId() == modMenu) {
				menu.get(i).setPrice(modPrice);;
				// 해당 객체의 가격만 수정
				System.out.println("수정 완료");
				return;
			}
		}
		System.out.println("찾는 메뉴가 없습니다.");
	}

	public void printMenu() {
		// 전체 메뉴 출력 메서드
		System.out.println("--메뉴--");
		for(Menu m : menu) {
			System.out.println(m);
		}
		System.out.println("-------");
	}

	public void orderPick(Scanner scan) {
		// 사용자 주문
		// 메뉴번호와 수량을 입력받아 > order 객체를 생성 > > orderList에 추가
		// order 객체를 생성할 때 필요한 메뉴명, 가격을 menuList에서 찾아와야함
		int op = -1;
		int cnt = 0;
		boolean a = false;
		this.orderNum++;
		
		while(op != 0) {
			System.out.print("주문할 메뉴 번호: ");
			int pickMenu = scan.nextInt();
			System.out.print("수량: ");
			int count = scan.nextInt();
			for(int i=0; i<menu.size(); i++) {
				if(menu.get(i).getMenuId() == pickMenu) {
					Menu m = menu.get(i);
					order.add(new Order(m.getMenuId(), m.getMenuName() , m.getPrice() , count, orderNum));
					System.out.println("주문완료");
					cnt++;
					a = true;
				}
			}
			
			if(!a) {
				System.out.println("찾는 메뉴가 없습니다.");				
			}
			
			System.out.print("더 주문하시겠습니까? 그만하려면 숫자 0 입력: ");
			op = scan.nextInt();
		}
		
		System.out.println("전체 주문이 완료되었습니다. 주문번호는 [" + orderNum + "]입니다.");
		System.out.println();
		
		if(cnt == 0) {
			this.orderNum--;
		}
	}

	public void orderPrint(Scanner scan) {
		// 주문 출력
		int cnt = 0;
		int sum = 0;
		
		System.out.print("주문 번호: ");
		int num = scan.nextInt();

		for(int i=0; i<order.size(); i++) {
			if(order.get(i).getOrderNum() == num) {
				order.get(i).orderPrint();
				sum += order.get(i).getTotalPrice();
				cnt++;
			}
		}
		
		if(cnt == 0) {
			System.out.println("일치하는 주문번호가 없습니다.");			
		}
		
		System.out.println("총 지불금액: " + sum);
		System.out.println();
	}

	public void totalOrder() {
		int sum = 0;
		System.out.println("--매출--");
		for(Order o : order) {
			sum+= o.getTotalPrice();
			o.orderPrint();
		}
		
		System.out.println("총 매출 : " + sum);
		System.out.println();
	}
		
		
		
		
		
		
		
		
		

}
