package day01;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] fileName = {"spring.java", "python.py", "react.jsx", "css.css", "String.java", "component.jsx", "text.txt"};
		
		// 검색어를 입력받아 fileName 배열에 검색어가 존재하면 해당 파일 이름을 출력
		Scanner scan = new Scanner(System.in);
		System.out.print("검색어를 입력해주세요: ");
		String sh = scan.nextLine();
		int cnt = 0;
		for(int i=0; i<fileName.length; i++) {
			
			if((fileName[i].toLowerCase()).contains(sh.toLowerCase())){
				System.out.println((cnt+1) + "." + fileName[i]);
				cnt++;
			}
		}
		if(cnt == 0) {System.out.println("검색 결과가 없습니다.");}
		
		scan.close();
		
	}

}
