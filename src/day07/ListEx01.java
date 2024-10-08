package day07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListEx01 {

	public static void main(String[] args) {
		/* 하루 일과를 저장하는 list 생성
		 * 출력을 for/향상된for/Iterator 출력
		 * 
		 * 
		 */
		
		List<String> daily = new ArrayList<String>();
		
		daily.add("학원 다녀오기");
		daily.add("블로그 작성하기");
		daily.add("물 2L 마시기");
		daily.add("문제집 100p 풀기");
		daily.add("솜이 산책시키기");
		daily.add("저녁밥 다같이 먹기");
		
		// 1. for문
		for(int i=0; i<daily.size(); i++) {
			System.out.println((i+1) + ". " + daily.get(i));
		}
		System.out.println("-----------------------");
		// 2. 향상된 for문
		int j = 0;
		for(String tmp : daily) {
			System.out.println((j+1) + ". " + tmp);
			j++;
		}
		// 3. Iterator
		System.out.println("-----------------------");
		Iterator<String> it = daily.iterator();
		j = 0;
		while(it.hasNext()) {
			String tmp = it.next(); // 다음 요소 가져오기
			System.out.println((j+1) + ". " + tmp);
			j++;
		}
		
		// 정렬
		System.out.println("-----------------------");
		daily.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		for(int i=0; i<daily.size(); i++) {
			System.out.println((i+1) + ". " + daily.get(i));
		}
		
		
	}

}
