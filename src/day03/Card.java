package day03;

// 카드 1장의 카드를 생성하기 위한 클래스
/* - 숫자 : 1~13까지 (1=A, 11=J, 12=Q, 13=K)
 * - 모양 : ♠ ◆ ♥ ♣ 
 * - 한장의 카드를 출력하는 print() >> ♥A ◆3
 * - ♣11이라면? ♣J로 출력해야겠죠!
 * - 오류 제어, 없는 모양은 ♥로 통일 없는 숫자는 1로 통일 
 * ex. #1 = ♥A / #2 = ♥2 / ♣15 = ♣1 
 */
/* 클래스 구성
 * - 멤버변수 : 모양(shape), 숫자(num) >> private getter/setter
 * - 생성자 : 기본 생성자만, 그 안에 기본값이 ♥A / 이후 setShape()와 setNum()을 통해 조작
 * - 메서드 : print()
 */

public class Card {
	//멤버변수
	private String shape;
	private int num;
	
	//생성자
	public Card() {
		shape = "h";
		num = 1;
	}
	
	//메서드
	public void print() {
		String str1 = "";
		String str2 = "";
		
		switch(shape) {
		case "s" : str1 = "♠"; break;
		case "d" : str1 = "◆"; break;
		case "h" : str1 = "♥"; break;
		case "c" : str1 = "♣"; break;
		}
		
		if(num <= 10 && num != 1) {
			str2 = Integer.toString(num);
		}else {
			switch(num) {
			case 1 : str2 = "A"; break;
			case 11 : str2 = "J"; break;
			case 12 : str2 = "Q"; break;
			case 13 : str2 = "K"; break;
			}
		}
		
		System.out.print(str1+str2);
	}
	
	public void setCard(String shape, int num) {
		setShape(shape);
		setNum(num);
	}

	//Getters and Setters
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		switch(shape) {
		case "s" : case "♠" : case "스페이드" : this.shape = "s"; break;
		case "d" : case "◆" : case "다이아" : this.shape = "d"; break;
		case "h" : case "♥" : case "하트" : this.shape = "h"; break;
		case "c" : case "♣" : case "클로버" : this.shape = "c"; break;
		default : this.shape = "h";
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num<1 || num>13) {
			num = 1;
		}
		this.num = num;
	}

}
