package day06;
/* 멤버변수 : 
 * customerID(고객ID), customerName(고객이름), customerGrade(등급), bonusPoint, bonusRatio
 * 기본 customerGrade = Silver
 * 
 * 메서드 : 
 * 1. 보너스 적립 계산 메서드 
 * => 구매 금액을 주고 적립 보너스를 계산하여 bonusPoint 누적(공통)
 * => 보너스 적립, 할인 여부를 체크하여 구매 금액을 리턴 
 * 
 * 2. 출력 메서드 
 * => 홍길동님은 VIP등급이며, 보너스 포인트는 5000점 입니다.
 * => (VIP)일 경우 : 전담 상담사 번호는 1111입니다. (agentID)
 */

public class Customer {
	//멤버변수
	protected String customerID;
	protected String customerName;
	protected String grade;
	protected int bonusPoint;
	protected double bonusRatio;
	
	//생성자
	public Customer() {
		grade = "Silver";
		bonusRatio = 0.01;
	}

	public Customer(String customerID, String customerName) {
		this.grade = "Silver";
		this.bonusRatio = 0.01;
		this.customerID = customerID;
		this.customerName = customerName;
	}
	
	//메서드
	public int calcPrice(int price) {
		// 적립금
		bonusPoint += (int)(price*bonusRatio);
		// 할인 금액 계산
//		if(grade.equals("Gold") || grade.equals("VIP")) {
//			price = (int)((double)price * 0.9);		
//		}
		return price;
	}
	
	public void print() {
		System.out.println(customerName + " 고객님은 " + grade + "등급이며, 보너스 포인트는" + bonusPoint + "점 입니다.");
	}
	
	//
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", grade=" + grade
				+ ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
}
