package sale;

public class Order extends Menu{
	//멤버변수
	private int orderNum;
	private int cnt;
	private int totalPrice;
	
	//생성자
	public Order() {
		
	}
	
	public Order(int id, String name, int price, int cnt, int orderNum) {
		//id,name,price는 menu의 기본값으로 세팅
		super(id, name, price);
		this.cnt = cnt;
		this.orderNum = orderNum;
		this.totalPrice = cnt*price;
	}
	
	//메서드
	public void orderPrint() {
		//super.toString 활용
		System.out.print(super.toString()+" / ");
		System.out.println(cnt+"개 / 금액: " + totalPrice);
	}
	
	//자동생성
	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + ", cnt=" + cnt + ", totalPrice=" + totalPrice + "]";
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
}
