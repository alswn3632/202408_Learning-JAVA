package day05;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		// 키오스크 생성
		// 1. 전체 상품 리스트 | 2. 상품 등록 | 3. 상품 삭제 | 4. 상품 수정 | 5. 종료
		
		ProductController productController = new ProductController();
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		do {
			// Scanner를 메뉴를 받을 때 필요, 상품을 받을 때 필요
			// Scanner가 두개 열리면 에러 발생할 수 있음
			// Scanner를 매개변수로 전달
			System.out.print("menu: ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1 :
				productController.printProduct();
				break;
			case 2 : 
				productController.insertProduct(scan);
				break;
			case 3 : 
				productController.deleteProduct(scan);
				break;
			case 4 : 
				productController.modifyProduct(scan);
				break;
			case 5 :
				System.out.println("종료합니다.");
				break;
			default : 
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu != 5);
		
		
	}

}
