package day09;

import java.util.ArrayList;
import java.util.List;

public class Generics01 {

	public static void main(String[] args) {
		/* 제네릭스(Generics) : 데이터의 타입을 나중에 확장하는 기법
		 * 클래스나 메서드를 선언할 때 어떤 데이터가 올 지 확신이 없다면,
		 * 제네릭 타입으로 구현 => 나중에 객체 생성 시 타입을 확정하여 구현
		 * 
		 * 객체의 타입을 컴파일 할 때 체크할 수 있어서 안정성을 해치지 않는 선에서 적당히 형변환이 가능한 기법
		 *  여기서 안정성 - 의도하지 않은 타입의 객체가 저장되는 것을 막는 것
		 * 
		 * 보통은 라이브러리 제공하는 쪽에서 Generics로 제공하여 내가 사용할 때 형변환을 통해 사용하기도함
		 * 타입의 다형성..?
		 */
		
		// 객체 구현시 타입을 적어서 처리 (안해도됨 근데 노란밑줄이 계속 생김 ㅇㅅㅇ;;;)
		List<Sale<Integer, String>> list = new ArrayList<>();
		int id = 1;
		String name = "햄버거";
		int price = 5000;
		
		Sale<Integer, String> s = new Sale<Integer, String>(id,name,price);
		list.add(s);
		list.add(new Sale<Integer, String>(2,"콜라",1500));
		
		int sum = 0;
		for(Sale<Integer, String> t : list) {
			System.out.println(t);
			sum += t.getId(); //에러 발생 : 내가 숫자를 넣어줬어도 형이 안정해졌기 때문에
//			sum += (int)t.getId(); //형변환 해주면 정상적으로 들어감
			
			//(int) 형 변환 없이 사용하려면 Sale이 들어가는 곳에 전부 타입을 지정해줘야함
		}
		System.out.println("ID 합계: " + sum);
	}

}
