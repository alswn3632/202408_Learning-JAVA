package day09;

import java.util.HashMap;

public class Lambda02 {

	public static void main(String[] args) {
		// map을 forEach로 출력
		
		HashMap<String ,Integer> map = new HashMap<>();
		map.put("홍길동", 78);
		map.put("신짱구", 68);
		map.put("신짱아", 85);
		map.put("김철수", 38);
		map.put("한유리", 95);
		map.put("이훈이", 60);
		map.put("맹구", 20);
		
		// Consumer : 값이 1개 / BiConsumer : 값이 2개
		map.forEach((x,y) -> {
			System.out.println(x + ": " + y);
		});
		
		Number sum = (a,b) -> { // 함수 구현
			return a+b;
		};
		
		int tot = sum.add(50, 60);
		System.out.println(tot);
	}

}

// 함수형 인터페이스 생성
// 메서드가 1개여야만 함
@FunctionalInterface
interface Number {
	int add(int a, int b);
//	int sub(int a, int b); // 메서드 2개면 에러발생
}