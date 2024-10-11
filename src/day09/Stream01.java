package day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Stream01 {

	public static void main(String[] args) {
		/* Strean(스트림)
		 * - 실제 입력(출력)되는 데이터의 흐름
		 * - 파이프라인으로 데이터가 흘러가는 흐름의 개념
		 * - 스트림은 자료에 스트림을 생성하여 연산(복사본)
		 * - 스트림 연산은 연산을 다 수행하면 소모됨(1회성)
		 * - 기존 자료를 복사하여 스트림을 구성하기 때문에 기존 자료의 변경을 유발하지 않음
		 * 
		 * - 스트림용 연산이 별도로 존재 
		 * - 중간 연산과, 최종 연산으로 구분됨
		 *  - 중간 연산 : 메서드를 이어서 사용할 수 있음.
		 *  	- disthinct() : 중복제거
		 *  	- filter() : 조건에 맞는 자료만 다음 스트림으로 이동
		 *  	- limit() : 스트림의 일부를 잘라냄
		 *  	- skip() : 스트림의 일부를 건너뜀
		 *  	- sorted() : 정렬...
		 *  	- map() : 새로운 형태로 변경
		 *  		- mapToInt(), mapToLong(), mapToObject()
		 *  
		 *  - 최종 연산 : 스트림의 최종 결과 연산 (마지막에서만  가능) 
		 *  	- forEach(), count(), sum(), allMatch() : 스트림 요소가 전부 일치하는지
		 *  	- anyMatch() : 하나라도 일치하는지
		 *  	- toArray() : 배열로 변환
		 *  	- collect() : 스트림 수집
		 */
		
		int [] arr = {1,2,3,4,5,6,7,8,9};
		//일반적인 합계
		int sum = 0;
		for(int i: arr) {
			sum+= i;
		}
		System.out.println(sum);
		
		System.out.println("스트림을 이용한 합계");
		
		int total = Arrays.stream(arr).sum();
		System.out.println(total);
		
		System.out.println("스트림 count()");
		// count() 연산은 return 이 Long
		long cnt = Arrays.stream(arr).count();
		System.out.println(cnt);
		
		// Optional : nullPointException 같은 Exception을 처리할 수 있게 도와줌
		System.out.println("스트림 average()");
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println(avg);
		
		// filter() : 조건
		// 배열의 값 중 5 이상만 출력
		System.out.println("---filter()---");
		Arrays.stream(arr).filter(n -> n>=5).forEach(m -> {
			System.out.print(m + " ");
		});
		
		System.out.println();
		int a = Arrays
				.stream(arr)
				.filter(n -> n>=5)
				.sum();
		System.out.println(a);
		
		int [] score = {78,89,86,58,74,51,63,89,91};
		// stream을 이용하여 합계 평균 최댓값 구하기
		int summ = Arrays.stream(score).sum();
		OptionalDouble avgg = Arrays.stream(score).average();
		OptionalInt maxx = Arrays.stream(score).max();
		
		System.out.println("합계: " + summ + ", 평균: " + String.format("%.2f", avgg.getAsDouble()) + ", 최댓값: "  + maxx.getAsInt());
		// stream을 이용하여 70점 이상의 인원수
		long cntt = Arrays.stream(score).filter(n -> n>=70).count();
		System.out.println("인원수: " + cntt);
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(6);
		list.add(8);
		
		System.out.println("--list stream 구성--");
		list.stream().forEach(n ->System.out.print(n + " ")); // 1 3 5 1 3 5 1 4 4 1 3 6 8 
		System.out.println();
		System.out.println("--distinct() 중복제거--");
		list.stream()
		.distinct()
		.forEach(n->System.out.print(n+" ")); // 1 3 5 4 6 8 
		System.out.println();
		System.out.println("--sorted() 정렬--");
		list.stream()
		.sorted()
		.forEach(n->System.out.print(n+" ")); // 1 1 1 1 3 3 3 4 4 5 5 6 8 
		System.out.println();
		System.out.println("--중복제거 + 정렬--");
		list.stream()
		.distinct()
		.sorted()
		.forEach(n->System.out.print(n+" ")); // 1 3 4 5 6 8 
		System.out.println();
		// 합계 : sum()은 intStream에게만 존재함
		// int s = list.stream().sum()
		int s = list.stream().mapToInt(n -> n.intValue()).sum();
		System.out.println(s);
		// map : 스트림 변환에 사용하는 중간연산
		// mapToInt : 값을 int로 변환하는 역할
		
		// 지금까지는 스트림 객체로 변환하는 것 
		// 스트림 객체 생성하는 방법은?
		System.out.println("--Stream 객체 생성--");
		Stream<Integer> s1 = Stream.of(10,20,30,40,50,60);
		
		int s2 = s1.mapToInt(n->n.intValue()).sum(); // 여기서 사용함
		System.out.println(s2);
		
		// stream has already been operated upon or closed 
		// 이미 소모된 스트림은 다시 사용할 수 없음
		OptionalDouble avg3 = s1.mapToInt(n->n.intValue()).average();
		System.out.println(avg3);

	}

}
