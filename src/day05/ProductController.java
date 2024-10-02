package day05;

import java.util.Scanner;

// Product 배열 생성
// 추가, 삭제, 수정, 리스트 보기
public class ProductController {
	//멤버변수
	private Product[] menu = new Product[10];
	private int cnt; //index 역할
	
	//생성자
	public ProductController() {
		
	}

	//Getters and Setters
	public Product[] getMenu() {
		return menu;
	}

	public void setMenu(Product[] menu) {
		this.menu = menu;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void printProduct() {
		for(int i=0; i<cnt; i++) {
			if(menu[i].getPrice() != 0) {
				System.out.print(i+1 + ". ");
				menu[i].printProduct();
			}
		}
	}

	public void insertProduct(Scanner scan) {
		if(cnt>=menu.length) {
			// 배열 크기 늘리기
			Product [] newMenu = new Product[menu.length+5];
			// 배열 복사 : 기존 배열의 0번지부터 새 배열의 0번지에 복사 (cnt 개수만큼)
			System.arraycopy(menu, 0, newMenu, 0, cnt);
			
			this.menu = newMenu;
		}
		System.out.print("상품 이름: ");
		String name = scan.next();
		System.out.print("상품 가격: ");
		int price = scan.nextInt();
		
		Product p = new Product(name, price);
		menu[cnt] = p;
		cnt++;
	
	}

	public void deleteProduct(Scanner scan) {
		System.out.println("다음 목록에서 삭제할 상품의 번호를 선택해주세요.");
		printProduct();
		System.out.print("상품 선택: ");
		int num = scan.nextInt();
		
//		for(int i=num-1; i<cnt-1; i++) {
//			menu[i] = menu[i+1];
//		}
		
		// arraycopy를 이용해 작성 >> 속도가 빠름
		int copyCut = menu.length - num;
		System.arraycopy(menu, num, menu, num-1, copyCut);
		
		menu[cnt-1] = null;
		cnt--;
		System.out.println("삭제되었습니다.");
		
	}

	public void modifyProduct(Scanner scan) {
		System.out.println("다음 목록에서 수정할 상품의 번호를 선택해주세요.");
		printProduct();
		System.out.print("상품 선택: ");
		int num = scan.nextInt();
		menu[num-1].printProduct();
		System.out.print("상품 이름: ");
		String name = scan.next();
		System.out.print("상품 가격: ");
		int price = scan.nextInt();
		
		menu[num-1].setProduct(name, price);
		System.out.println("수정되었습니다.");

	}
	
	
	
}
