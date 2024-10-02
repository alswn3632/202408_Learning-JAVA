package student;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// 메뉴처리
		// 1. 학생등록 2. 학생리스트출력 3. 학생검색(학생정보,수강정보) 
		// 4. 학생정보수정 5. 학생삭제 6. 수강신청 7. 수강철회 6. 종료
		// interface로 7개 메뉴의 메서드 정리
		// StudentController가 구현 - Student class 배열처리
		// Student class : 학생 정보 (학번,이름,나이,전화번호,주소,수강과목s)
		//  - 수강과목은 subject class를 배열로 처리
		// Subject class : 과목 정보 (과목코드,과목명,학점,시수,교수명,시간표,강의장)
		
		StudentController sc = new StudentController();
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		do {
			System.out.print("menu: ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1 :
				sc.insertStudent(scan);
				break;
			case 2 : 
				sc.printStudent();
				break;
			case 3 : 
				sc.searchStudent(scan);
				break;
			case 4 : 
				sc.modifyStudent(scan);
				break;
			case 5 : 
				sc.deleteStudent(scan);
				break;
			case 6 : 
				sc.registerSubject(scan);
				break;
			case 7 : 
				sc.deleteSubject(scan);
				break;
			case 8 :
				System.out.println("종료합니다.");
				break;
			default : 
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu != 8);
		
		
		scan.close();
	}

}
