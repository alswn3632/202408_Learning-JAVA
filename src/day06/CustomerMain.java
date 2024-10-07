package day06;

/* 손님 등급 : Silver고객/Gold고객(할인)/VIP고객(할인)
 * - Silver 고객 : 제품을 구매할 때 0% 할인 / 보너스 포인트 1% 적립
 * - Gold 고객 : 제품을 구매할 때 10% 할인 / 보너스 포인트 2% 적립
 * - VIP 고객 : 제품을 구매할 때 10% 할인 / 보너스 포인트 5% 적립 + 전담 상담사 혜택
 * 
 * >> Customer / GoldCustomer / VIPCustomer 클래스 생성
 *    Gold와 VIP는 Customer를 상속 받음
 */

public class CustomerMain {

	public static void main(String[] args) {
		// 업캐스팅 : ?
		Customer[] customerList = new Customer[10];
		
		Customer cLee = new Customer("1001", "리정혁");
		Customer cHong = new Customer("1002", "홍길동");
		Customer cKim = new CustomerGold("1003", "김철수");
		Customer cChoi = new CustomerGold("1004", "최유진");
		
		int cnt = 0;
		customerList[cnt] = cLee;
		cnt++;
		customerList[cnt] = cHong;
		cnt++;
		customerList[cnt] = cKim;
		cnt++;
		customerList[cnt] = cChoi;
		cnt++;
		customerList[cnt] = new CustomerVIP("1005","박영희","1111");
		cnt++;
		customerList[cnt] = new CustomerVIP("1006","김영수","2222");
		cnt++;
		customerList[cnt] = new CustomerVIP("1007","한유리","1111");
		cnt++;
		customerList[cnt] = new CustomerVIP("1008","이훈이","2222");
		cnt++;
		
		System.out.println("--할인율과 포인트 계산--");
		int price = 100000;
		// 모든 손님 대상
		for(int i=0; i<cnt; i++) {
			System.out.println(customerList[i].customerName + "님의 지불 금액은 " + customerList[i].calcPrice(price) + "/ 포인트는 " + customerList[i].bonusPoint + "입니다.");
		}
		
		for(int i=0; i<cnt; i++) {
			customerList[i].print();
		}
		
		// agentID = 1111 => 3333로 변경
		for(int i=0; i<cnt; i++) {
			if(customerList[i] instanceof CustomerVIP) {
				if(((CustomerVIP)customerList[i]).getAgentID().equals("1111")) {
					((CustomerVIP)customerList[i]).setAgentID("3333");
				}
			}
		}
		// 다운캐스팅 : 부모의 공유되는 멤버변수나 메서드가 아닌 자식 고유의 멤버변수나 메서드를 호출하고자할 경우 사용한다.
		// 다운캐스팅시 반드시 명시적으로 형변환 해야함.
		
		for(int i=0; i<cnt; i++) {
			customerList[i].print();
		}
		
	}

}
