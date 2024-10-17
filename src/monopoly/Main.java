package monopoly;

public class Main {

	public static void main(String[] args) {
		
		Controller c = new Controller();
		
		System.out.println("게임을 시작합니다.");
		boolean a = c.gameStarter();
		
		if(a) {
			c.gamePlay();
		}
	}

}

