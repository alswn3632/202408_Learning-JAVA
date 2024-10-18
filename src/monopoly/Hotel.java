package monopoly;

import java.util.Objects;

public class Hotel {
	//(멤버변수) - owner, hotelPo, price(매입가), toll(통행료) [(take)인수: 매입가+통행료] [(sale)매각:매입가-통행료]
	// 200만원
	
	
	private String owner;  //호텔주인
	private int hotelPo;  //호텔위치
	private int price;  //매입가
	private int toll;  //통행료 
	private int take;  //인수
	private int sale;  //매각
	
	//생성자
	public Hotel() {}
	public Hotel(String owner, int hotelPo) {
		this.owner = owner;
		this.hotelPo = hotelPo;
	}
	public Hotel(int hotelPo, int price, int toll) {
		this.hotelPo = hotelPo;
		this.price = price;
		this.toll = toll;
		updateTakeAndSale();
	}
	public Hotel(String owner, int hotelPo, int price, int toll) {
		this(owner, hotelPo);
		this.price = price;
		this.toll = toll;
		updateTakeAndSale();
	}
	
    // 인수와 매각 값을 자동으로 계산하는 메서드
    private void updateTakeAndSale() {
        this.take = price + toll;
        this.sale = price - toll;
    }

	@Override
	public String toString() {
		return  "🏢 매입	: "+price+"만원"+" | ✈︎ 통행료 : "+toll+"만원"+"\r\n"
				+ "💰 인수	: "+take+"만원"+" | 💸 매각  : "+sale+"만원";
	}

	
	// getter/setter
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getHotelPo() {
		return hotelPo;
	}
	public void setHotelPo(int hotelPo) {
		this.hotelPo = hotelPo;
//		this.hotelPo = h.getHotelPo();
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
		updateTakeAndSale();
	}
	public int getToll() {
		return toll;
	}
	public void setToll(int toll) {
		this.toll = toll;
		updateTakeAndSale();
	}
	public int getTake() {
		return take;
	}
	public void setTake(int take) {
		this.take = take;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(hotelPo, owner, price, sale, take, toll);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return hotelPo == other.hotelPo;
	}
	
}
