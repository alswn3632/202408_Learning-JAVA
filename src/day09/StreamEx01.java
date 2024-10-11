package day09;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamEx01 {

	public static void main(String[] args) {
		/* 여행사 상품
		 * 여행 비용이 15세 이상은 100만원, 미만은 50만원으로 계산
		 * 고객 5명이 패키지 여행을 떠난다고 했을 경우
		 * 1. 비용 계산 => 출력
		 * 2. 고객 명단 출력
		 * 
		 * 고객 클래스 생성하고, ArrayList로 고객 관리
		 * 
		 * 예시) 이름:이순신 나이:40 비용:100만원
		 * 	    이름:신사임당 나이:38 비용:100만원
		 * 	    이름:홍길동 나이:30 비용:100만원
		 *      이름:신짱구 나이:10 비용:50만원
		 *      이름:신짱아 나이:5 비용:50만원
		 *      총 여행 경비:400만원
		 * 
		 *      20세 이상 고객 명단을 이름순으로 정렬하여 출력
		 * 	    이름:신사임당 나이:38 비용:100만원
		 *      이름:이순신 나이:40 비용:100만원
		 * 	    이름:홍길동 나이:30 비용:100만원
		 */
		
		ArrayList<Customer> cstList = new ArrayList<Customer>();
		
		cstList.add(new Customer("신짱구", 7));
		cstList.add(new Customer("신형만", 45));
		cstList.add(new Customer("봉미선", 42));
		cstList.add(new Customer("신짱아", 3));
		cstList.add(new Customer("나미리", 30));
		
		// 1. 비용 계산, 출력
		cstList.stream().forEach(n->{
			System.out.println("이름:" + n.getName() + " 나이:" + n.getAge() + " 비용:" + (n.getAge() >= 15? "100만원" : "50만원"));
		});
		
		int sum = cstList.stream().mapToInt(n->n.getAge()>=15? 100:50).sum();
		System.out.println("총 여행 경비:" + sum);
		
		System.out.println();
		
		// 2. 고객 명단 출력 
		// 20세 이상 고객 명단 이름순 정렬
		cstList.stream().filter(n-> n.getAge()>=20).sorted(new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		}).forEach(n->{
			System.out.println("이름:" + n.getName() + " 나이:" + n.getAge() + " 비용:" + (n.getAge() >= 15? "100만원" : "50만원"));
		});
	}

}
