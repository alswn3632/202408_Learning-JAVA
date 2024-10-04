package lotto;

public class LottoExtend extends Lotto {
	//멤버변수
	private int bonus;
	
	//생성자
	public LottoExtend() {
		super();
	}

	//메서드
	@Override
	public void printLotto() {
		super.printLotto();
		System.out.println("[" + bonus + "]");
	}
	
	//Getters and Setters
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
