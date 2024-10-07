package day06;

public class CustomerVIP extends Customer{
	//멤버변수
	private double discountRatio;
	private String agentID;
	
	//생성자
	public CustomerVIP() {
		grade = "VIP";
		bonusRatio = 0.05;
	}
	
	public CustomerVIP(String customerID, String customerName, String agentID) {
		super(customerID, customerName);
		this.agentID = agentID;
		grade = "VIP";
		bonusRatio = 0.05;
		discountRatio = 0.1;
	}

	//메서드
	@Override
	public int calcPrice(int price) {
		bonusPoint += (int)(price*bonusRatio);
		price = price - (int)(price*discountRatio);
		return price;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("전담 상담사 번호는 " + agentID + "입니다.");
	}

	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}
	
	
}
