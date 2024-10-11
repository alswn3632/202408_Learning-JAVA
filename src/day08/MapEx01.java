package day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MapEx01 {

	public static void main(String[] args) {
		/* 단어장
		 * 단어 5개를 입력받아 콘솔에 출력하는 기능
		 * --단어장--
		 * hello : 안녕
		 * apple : 사과
		 * orange : 오렌지
		 * map 저장 후 출력
		 * */
		
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		int size = 5;
		
		while(map.size() < size) {
			System.out.println("단어:");
			//공백허용 scan.nextLine(); 
			//enter 콘솔입력시 완료
			// nextLine() : enter값으로 인지하는 케이스는 
			// 다른 입력값 -> nextLine() 이 오는 케이스
			String word = scan.nextLine();
			System.out.println("의미:");
			String mean = scan.next();
			scan.nextLine();  // 완료의 enter 처리할수있는 값
			System.out.println("test : ");
			String test = scan.nextLine();
			
			map.put(word, mean);
		}
		System.out.println(map);
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+":"+map.get(key));
		}
		scan.close();
	}

}