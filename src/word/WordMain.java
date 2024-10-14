package word;

import java.io.IOException;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) throws IOException {
		/* 단어장 프로그램
		 * 1. 단어 등록 2. 단어 검색 3. 단어 수정 4. 단
		 * 어 출력 5. 단어 삭제 6. 단어파일로출력 7. 종료
		 * Word class 생성
		 * - 단어, 뜻 (뜻에 List<String>)
		 * 
		 * Word (equals 사용) : 단어가 같으면 같은 객체 > 검색, 수정, 삭제
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		WordController wc = new WordController();
		wc.addWord();
		
		System.out.println(
				"\r\n"
				+ " ██╗    ██╗ ██████╗ ██████╗ ██████╗  \r\n"
				+ " ██║    ██║██╔═══██╗██╔══██╗██╔══██╗ \r\n"
				+ " ██║ █╗ ██║██║   ██║██████╔╝██║  ██║ \r\n"
				+ " ██║███╗██║██║   ██║██╔══██╗██║  ██║ \r\n"
				+ " ╚███╔███╔╝╚██████╔╝██║  ██║██████╔╝ \r\n"
				+ "  ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝  \r\n"
				+ "                                     "
				);
		System.out.println("                         ANSI Shadow");
		int menu = -1;
		do {
			System.out.println("1.단어등록|2.단어검색|3.단어수정|4.단어출력|5.단어삭제|6.파일로내보내기|7.종료");
			System.out.print("menu: ");
			menu = scan.nextInt();
			switch(menu) {
			case 1: wc.registerWord(scan); break;
			case 2: wc.searchWord(scan); break;
			case 3: wc.modifyWord(scan); break;
			case 4: wc.printWord(); break;
			case 5: wc.deleteWord(scan); break;
			case 6: wc.makeFile(); break;
			case 7: System.out.println("종료하겠습니다."); break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 7);
		scan.close();
	}

}
