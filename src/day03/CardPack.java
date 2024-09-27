package day03;

// 카드 한 묶음을 나타내는 클래스
/* ♠1~13 ◆1~13 ♥1~13 ♣1~13 총 52장의 카드 구성
 * 52장의 카드를 담을 수 있는 배열 (카드 한 묶음 배열) - 멤버변수
 * 
 * 생성자 : 52장의 카드를 순서대로 생성되게 만들기
 * 메서드 : 
 *    1. 카드 출력 기능 : Card class의 print() 사용할것임
 *    2. 카드 초기화 기능
 *    3. 카드 한장을 나눠주는 기능
 *    4. 카드를 섞는 기능
 */
public class CardPack {
	
	//멤버변수
	private Card pack[] = new Card[52];
	// 카드의 index를 체크하기 위한 변수
	private int cnt;
	
	//생성자
	public CardPack() {
		// 52장의 카드를 생성하여 배열에 넣기 
		
		for(int i=1; i<=4; i++) {
			for(int f=1; f<=13; f++) {
				Card c = new Card();
				String str = "";
				switch(i) {
				case 1 : str = "s"; break;
				case 2 : str = "d"; break;
				case 3 : str = "h"; break;
				case 4 : str = "c"; break;
				}
				c.setCard(str, f);
				pack[cnt] = c;
				cnt++;
			}
		}
	}
	
	//메서드
	//카드 섞는 메서드
	public void mixCard() {
		for(int i=0; i<pack.length; i++) {
			int num = (int)(Math.random()*pack.length);
			Card t = pack[i];
			pack[i] = pack[num];
			pack[num] = t;
		}
	}
	
	//카드 정렬 메서드
	public void sortCard() {
		int cnt = 0;
		for(int i=1; i<=4; i++) {
			for(int f=1; f<=13; f++) {
				String str = "";
				switch(i) {
				case 1 : str = "s"; break;
				case 2 : str = "d"; break;
				case 3 : str = "h"; break;
				case 4 : str = "c"; break;
				}
				pack[cnt].setCard(str, f);
				cnt++;
			}
		}
	}
	
	//카드팩 출력 메서드
	public void printPack() {
		int cnt = 0;
		
		for(int f=0; f<4; f++) {
			for(int i=0; i<13; i++) {
				pack[cnt].print();	
				System.out.print(" ");
				cnt++;
			}
			System.out.println();
		}
	}
	
	//카드 한장 드로우 메서드
	public Card drawCard() {
		cnt--;
		
		if(cnt == -1) {
			System.out.println("카드 소진");
			cnt = 51;
		}
		return pack[cnt];			
	}
	
	public void initDraw() {
		cnt = 52;
	}

	//Getters and Setters
	public Card[] getPack() {
		return pack;
	}

	public void setPack(Card[] pack) {
		this.pack = pack;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
