package day06;

public class CustomerGold extends Customer{
	//멤버변수
	private double discountRatio;
	
	//생성자
	public CustomerGold() {
		grade = "Gold";
		bonusRatio = 0.02;
		discountRatio = 0.1;
	}
	
	public CustomerGold(String customerID, String customerName) {
		super(customerID, customerName);
		grade = "Gold";
		bonusRatio = 0.02;
		discountRatio = 0.1;
	}

	//메서드
	@Override
	public int calcPrice(int price) {
		bonusPoint += (int)(price*bonusRatio);
		price = price - (int)(price*discountRatio);
		return price;
	}

	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	
	
}
