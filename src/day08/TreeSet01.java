package day08;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet01 {

	public static void main(String[] args) {
		// 정렬이 가능한 Set
		// 중앙 노드를 기준으로 작은 값이 들어오면 left, 큰값이 들어오면 right
		//TreeSet을 이용하여 Lotto 번호 6개를 랜덤으로 넣기
		
		TreeSet<Integer> set = new TreeSet<>();
		Set<Integer> set2 = new HashSet<>();
		for(int i=0; set.size()<6 ; i++) {
			int num = new Random().nextInt(45)+1;
			set.add(num);
			set2.add(num);
		}
		System.out.println("--TreeSet--");
		System.out.println(set);
		System.out.println("--HashSet--");
		System.out.println(set2);
		
		//first() / last()  : TreeSet의 가장 앞에있는 값 / 가장 뒤에 있는 값 추출
		System.out.println(set.first());
//		System.out.println(set2.first()); //error  없음.
		System.out.println(set.last());

	}

}