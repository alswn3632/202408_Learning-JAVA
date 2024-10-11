package day09;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lambda01 {

	public static void main(String[] args) {
		// Lambda + Stream => 람다와 스트림
		/* javascript의 arrowFunction(화살표함수)와 비슷한 형태
		 * lambda(람다식) : 식을 단순하게 표현하는 방법
		 * 	외부 자료의 부수적인 영향(side effect)를 주지 않도록 구현하는 방법
		 * Stream : 자료의 대상과 관계 없이 동일한 연산을 수행할 수 있도록 해주는 반복자
		 * - 메서드 체이닝 기법을 사용
		 * 
		 * Lambda function : 익명클래스를 사용하여 쓰는 함수
		 * 람다식의 장점 : 코드 간결성, 병렬처리가능, 불필요한 연산 최소화
		 * 단점 : 가독성이 떨어짐, 반복문 사용시 성능 저하
		 * 
		 * - 람다의 표현식
		 * 자바의 람다 // (매개변수) -> {구현}
		 * 자바스크립트 // const name = () => { }
		 * 매개변수가 1개면 () 생략가능
		 *  x -> {return x+1;}
		 *  (x,y) -> {return x+y;}
		 *  
		 *  return이 없으면 { 이 괄호도 생략 가능함
		 *   x -> x+1;
		 *   x -> return x+1; // 안됨
		 * 
		 */
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(50);
		list.add(60);
		list.add(90);
		list.add(20);
		list.add(40);
		list.add(30);
		list.add(60);
		list.add(20);
		list.add(80);
		list.add(10);
		
		for(Integer tmp : list) {
			System.out.println(tmp);
		}
		
		System.out.println("---forEach로 출력---");
		// 구현+실행
		list.forEach(n -> {
			System.out.print(n + " ");
		});
		
//		int sum = 0;
//		// stream을 구성 / side effect 최소화 
//		list.forEach(n -> {
//			sum+=n;
//		});
		
		// 람다함수(익명함수) 구현 -> 실행
		System.out.println("---람다 함수 사용 Consumer---");
		Consumer<Integer> method = n -> {
			System.out.println(n+ " ");
		};
		
		list.forEach(method);
		
		
	}

}
