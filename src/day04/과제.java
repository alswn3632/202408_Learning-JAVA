package day04;

import java.util.Scanner;

/* Product 클래스 생성 : 상품을 등록하는 클래스
 * 상품명(name), 가격(price)을 멤버변수로 생성
 * 상품을 추가하는 메서드
 * 상품을 출력하는 메서드(toString이용)
 * ex. 사탕 : 500원
 * 	   과자 : 2000원
 *     젤리 : 1000원
 */

class Product {
	//멤버변수
	private String name = "미입력";
	private int price;
	
	//생성자
	public Product() {
		
	}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	//메서드
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}

public class 과제 {

	public static void main(String[] args) {
		/* 상품 10개를 등록할 수 있는 배열을 생성
		 * 스캐너를 통해서 상품 등록
		 * 등록한 상품을 출력
		 * 상품을 등록하시겠습니까? (y/n) >> y >> 등록 // n >> 그만
		 */
		Scanner scan = new Scanner(System.in);
		
		Product proArr[] = new Product[10];
		int idx = 0;
		
		System.out.println("어서오세요!!");
		while(true) {
			System.out.println("상품을 등록하시겠습니까? (y/n)");
			System.out.print(">> ");
			String op = scan.nextLine();
			
			if(idx >= 10) {
				System.out.println("등록 가능한 수량을 초과했습니다.");
				break;
			}
			
			if(op.toLowerCase().equals("y")) {
				System.out.println("상품 이름과 가격을 입력해주세요! 쉼표로 구분 ex. 젤리,1000 ");
				System.out.print(">> ");
				String str = scan.nextLine();
				Product p = new Product(str.substring(0, str.indexOf(",")),Integer.parseInt(str.substring(str.indexOf(",")+1)));
				proArr[idx] = p;
				idx++;
			}else if(op.toLowerCase().equals("n")) {
				System.out.println("상품 등록을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
		
		System.out.println("\n\n\n등록한 상품을 출력합니다.");
		for(int i=0; i<idx; i++) {
			System.out.println(proArr[i].toString());
		}
		
	}

}
