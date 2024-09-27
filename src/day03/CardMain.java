package day03;

public class CardMain {

	public static void main(String[] args) {
		// 여기서 Card 클래스 생성 출력
		Card c = new Card();
		c.print();
		c.setShape("s");
		c.setNum(13);
		c.print();
		c.setNum(0);
		c.print();
		c.setNum(14);
		c.print();
		c.setShape("#");
		c.print();
		c.setCard("다이아",10);
		c.print();
		c.setCard("d",16);
		c.print();
		c.setCard("♠",10);
		c.print();
		
		System.out.println();
		System.out.println();
		
		// 여기서 CardPack 클래스 생성 출력
		CardPack p = new CardPack();
		p.printPack();
		System.out.println();
		p.mixCard();
		p.printPack();
		System.out.println();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		System.out.println();
		p.initDraw();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		p.drawCard().print();
		
		System.out.println();
		System.out.println();
		
		// 여기서 Student 클래스 테스트
		Student s = new Student("인천", "신짱구", "AWS 웹 개발자", "01012345678");
		s.print();

	}

}
