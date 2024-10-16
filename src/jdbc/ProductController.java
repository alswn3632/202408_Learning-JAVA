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
		System.out.print("상품번호: ");
		int pno = scan.nextInt();
		// 메서드 명은 기능과 관련있게 명명
		// set get insert register add update modify remove delete
		int isOk = svc.delete(pno);
		System.out.println("상품삭제 " + (isOk > 0? "[성공]" : "[실패]"));
	}

	private void modify() {
		// 상품 수정: 이름, 가격, 상세내용
		System.out.print("상품번호: ");
		int pno = scan.nextInt();
		
		// 수정할 내용
		System.out.print("상품이름: ");
		String name = scan.next();
		System.out.print("상품가격: ");
		int price = scan.nextInt();
		scan.nextLine(); 
		System.out.print("상세내역: ");
		String madeby = scan.nextLine();
		
		Product p = new Product(name, price, madeby, pno);
		int isOk = svc.update(p);
		System.out.println("상품수정 " + (isOk > 0? "[성공]" : "[실패]"));
	}

	private void search() {
		// 특정 상품을 검색 (세부 내용 madeby / regdate 전부 확인할 수 있는)
		// pno가 필요함
		// select * from product WHERE pno = ? 
		// pno 값을 입력 받아 매개변수로 전달 Product 객체를 리턴 받아~
		
		//화면에서 입력 받을 정보
		System.out.print("상품번호: ");
		int pno = scan.nextInt();
		
		//DB로 요청
		Product p = svc.getProduct(pno);
		
		//받은 객체 출력하기
		if(p != null) {
			System.out.println(p.toString());			
		}else {
			System.out.println("찾는 상품이 없습니다.");
		}
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
