package day08;

import java.util.HashMap;
import java.util.Scanner;

public class WordController {
	
	private HashMap<String, String> map = new HashMap<>();
	
	public void addWord() {
		map.put("apple", "사과");
		map.put("banana", "바나나");
		map.put("kiwi", "키위");
		map.put("orange", "오렌지");
		map.put("dog", "개");
		map.put("cat", "고양이");
	}

	public void insertWord(Scanner scan) {
		// 단어 추가
		System.out.println("단어>");
		String word = scan.next();
		System.out.println("의미>");
		String mean = scan.next();
		
		map.put(word, mean);
		
	}

	public void searchWord(Scanner scan) {
		// 단어검색
		System.out.println("검색할 단어>");
		String word = scan.next();
		if(map.containsKey(word)) {
			System.out.println("--검색된 단어---");
			System.out.println(word+":"+map.get(word));
			System.out.println("--------------");
			return;
		}
		System.out.println("검색결과가 없습니다.");
	}

	public void modifyWord(Scanner scan) {
		// 단어수정 : 키 중복이 안됨.  add => 덮어씀
		// 삭제 후 다시 추가
		System.out.println("수정할 단어>");
		String word = scan.next();
		if(map.remove(word)==null) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
		System.out.println("의미>");
		String mean = scan.next();
		map.put(word, mean);
		System.out.println("수정완료!");
	}

	public void printWord() {
		System.out.println("--단어장--");
		for(String k : map.keySet()) {
			System.out.println(k +":"+map.get(k));
		}
		System.out.println("--------");
	}

	public void removeWord(Scanner scan) {
		// 단어삭제
		System.out.println("삭제할 단어>");
		String word = scan.next();
		String mean = map.remove(word); //삭제 완료
		if(mean==null) {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		System.out.println("삭제완료!");
	}

}