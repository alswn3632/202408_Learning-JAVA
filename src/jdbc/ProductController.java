package jdbc;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	/* Controller <-> Service <-> DAO <-> DB
	 * Controller 모든 메뉴 분기 처리
	 */
	
	private Scanner scan; // 여기서만 쓸꺼임!
	private Service svc; // 아직안맹금
	private boolean flag; // 종료변수
	
	public ProductController() {
		scan = new Scanner(System.in);
		svc = new ProductServiceImpl(); // service interface 구현체
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--상품 관리 프로그램--");
			System.out.println("1.상품 등록 2.상품 목록 3.상품 검색(상세보기) 4.상품 수정 5.상품 삭제 6.종료)");
			System.out.print("menu: ");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: register();
				break;
			case 2: list();
				break;
			case 3: search();
				break;
			case 4: modify();
				break;
			case 5: delete();
				break;
			case 6: 
				flag = false;
				System.out.println("종료합니다!");
				break;
			default : 
				System.out.println("잘못된 입력!");
			}
		}
	}

	private void delete() {
		
	}

	private void modify() {
		
	}

	private void search() {
		
	}

	private void list() {
		// 상품 전체 리스트
		// 매개변수는 없고, 리턴은 List로 
		List<Product> list = svc.getList();
		// 출력
		for(Product p : list) {
			p.printList();
		}
	}

	private void register() {
		// 상품 등록
		System.out.print("상품이름: ");
		String name = scan.next();
		System.out.print("상품가격: ");
		int price = scan.nextInt();
		scan.nextLine(); // 엔터처리용
		System.out.print("상세내역: ");
		String madeby = scan.nextLine(); // 공백 포함
		
		Product p = new Product(name, price, madeby);
		//service에게 p 객체에 대한 등록 요청 (메서드 작성)
		// Query OK, 1 row affected (0.00 sec)
		// isOK == 1? DB에 성공적으로 들어감 / isOK == 0? 실패
		int isOK = svc.insert(p);
		System.out.println("상품등록 " + (isOK > 0? "[성공]" : "[실패]"));
	}
	
	
}
