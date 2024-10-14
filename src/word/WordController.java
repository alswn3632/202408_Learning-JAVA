package word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import day09.Customer;

public class WordController {
	private List<Word> list = new ArrayList<Word>();
	
	public void addWord() {
		list.add(new Word("take","잡다"));
		list.get(0).addMean("지니다");
		list.get(0).addMean("소유하다");
		list.get(0).addMean("점령하다");
		list.add(new Word("fruit","과일"));
		list.get(1).addMean("열매");
		list.get(1).addMean("과일이 생기다");
		list.add(new Word("move","이동하다"));
		list.get(2).addMean("옮다");
		list.get(2).addMean("흔들리다");
		list.add(new Word("go","가다"));
		list.get(3).addMean("떠나가다");
		list.get(3).addMean("죽다");
		list.add(new Word("apple","사과"));
		list.add(new Word("banana","바나나"));
		list.add(new Word("sun","해"));
	}
	
	
	public void registerWord(Scanner scan) {
		System.out.print("단어: ");
		String word = scan.next();
		Word w = new Word(word);
		while(true){
			System.out.print("의미: ");
			String mean = scan.next();
			w.addMean(mean);
			
			System.out.println("더 추가하시겠습니까? 0 입력시 종료");
			int op = scan.nextInt();
			
			if(op == 0) {
				break;
			}
		}
		list.add(w);
	}

	public void searchWord(Scanner scan) {
		System.out.print("검색할 단어: ");
		String word = scan.next();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(new Word(word))) {
				list.get(i).print();
				return;
			}
		}
		System.out.println("검색 결과 없음.");
	}

	public void modifyWord(Scanner scan) {
		System.out.print("검색할 단어: ");
		String word = scan.next();
		int index = -1;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(new Word(word))) {
				index = i;
			}
		}
		
		if(index != -1) {
			list.get(index).printMean();
			System.out.print("수정할 번호 선택 (0 선택시 의미 추가): ");
			int m = scan.nextInt();
			System.out.println("의미: ");
			String n = scan.next();
			if(m == 0) {
				list.get(index).getMean().add(n);
			}else {
				list.get(index).getMean().set(m-1, n);				
			}
		}else {
			System.out.println("검색 결과 없음.");			
		}
		
	}

	public void printWord() {
		list.stream().sorted(new Comparator<Word>() {

			@Override
			public int compare(Word o1, Word o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
			
		}).forEach(n -> n.print());;
	}

	public void deleteWord(Scanner scan) {
		System.out.print("삭제할 단어: ");
		String word = scan.next();
		
		boolean op = list.remove(new Word(word));
		if(op) {
			System.out.println("삭제 완료");
		}else {			
			System.out.println("검색 결과 없음.");			
		}
	}

	public void makeFile() throws IOException {
//		FileWriter fw = new FileWriter("vocabulary note.txt");
//		for(int i=0; i<list.size(); i++) {
//			String data = list.get(i).toString() + "\r\n";
//			fw.write(data);
//		}
//		fw.close();
		
		// StringBuffer 객체 사용
		// .append : 기존 String 객체에 데이터 추가
		FileWriter fw = new FileWriter("vocabulary note.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuffer sb = new StringBuffer();
		String data = null;
		sb.append("--단어장--\r\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i).toString() + "\r\n");
		}
		data = sb.toString();
		bw.write(data);
		bw.close(); //버퍼 먼저 닫아주기
		fw.close();
	}


	public List<Word> getList() {
		return list;
	}


	public void setList(List<Word> list) {
		this.list = list;
	}

	
	
}
