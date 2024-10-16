package jdbcStudent;

import java.util.List;
import java.util.Scanner;

public class StudentController {
	
	private Scanner scan;
	private Service svc;
	private int menu = 0;
	
	public StudentController() {
		scan = new Scanner(System.in);
		svc = new StudentServiceImpl();
	}

	public void printMenu() {       
		System.out.println("--------------------------------------------------------");
		System.out.println("              _             _            _          \r\n"
				         + "             | |           | |          | |         \r\n"
			           	 + "          ___| |_ _   _  __| | ___ _ __ | |_        \r\n"
				         + "         / __| __| | | |/ _` |/ _ \\ '_ \\| __|     \r\n"
				         + "         \\__ \\ |_| |_| | (_| |  __/ | | | |_      \r\n"
				         + "         |___/\\__|\\__,_|\\__,_|\\___|_| |_|\\__|  \r\n"
				         + "                                                        ");
		System.out.println("--------------------------------------------------------");
		while(menu != 6) {
			System.out.println("--------------------------------------------------------");
			System.out.println("(1)학생등록 (2)학생목록 (3)학생검색 (4)정보수정 (5)정보삭제 (6)종료");
			System.out.print("선택: ");
			menu = scan.nextInt();
			System.out.println("--------------------------------------------------------");

			
			switch(menu) {
			case 1 : register(); break;
			case 2 : printList(); break;
			case 3 : search(); break;
			case 4 : modify(); break;
			case 5 : remove(); break;
			case 6 : System.out.println("종료합니다."); break;
			default : System.out.println("올바른 메뉴를 선택해주세요.");
			}
		}
	}

	// (1) 학생 등록
	private void register() {
		// 화면에서 받은 정보 처리해 객체로 생성        
		System.out.println("학생 등록을 시작합니다.\n");
		System.out.print("이   름: ");
		String name = scan.next();
		System.out.print("학   번: ");
		String num = scan.next();
		System.out.print("생년월일: ");
		String birth = scan.next();
		System.out.print("전화번호: ");
		String phone = scan.next();
		scan.nextLine();
		System.out.print("주   소: ");
		String addr = scan.nextLine();
		
		Student s = new Student(num, name, birth, phone, addr);
		
		// Service로 전달(파라미터로 Student 객체를 담아서)
		int isOk = svc.insert(s);
		System.out.println(isOk>0? "학생 정보가 입력되었습니다." : "학생 정보 입력이 실패했습니다.");
		
	}
	
	// (2) 학생 목록
	private void printList() {
		System.out.println();

		// Service로 전달
		List<Student> list = svc.getList();
		
		// 받은 데이터를 바탕으로 출력
		for(Student s : list) {
			s.printList();
		}
		
	}
	
	// (3) 학생 검색
	private void search() {
		// 화면에서 받은 정보 처리해 객체로 생성        
		System.out.println("학생 검색을 시작합니다.");
		System.out.print("이름: ");
		String name = scan.next();
		System.out.println();
		
		// Service로 전달
		// **List 처리한 이유 : 동명이인이 있을 수 있기 때문에
		List<Student> list = svc.getStudent(name);
		
		// 받은 데이터를 바탕으로 출력
		if(list.size() == 0) {
			System.out.println("해당 이름의 학생 정보가 없습니다.\n");
		}else {
			for(Student s : list) {
				s.printStudent();
				System.out.println();
			}
		}

	}
	
	// (4) 학생 정보 수정
	private void modify() {
		// 화면에서 받은 정보 처리해 객체로 생성
		System.out.println("다음 목록에서 수정할 학생을 골라주세요.\n");
		printList();
		System.out.print("선택: ");
		int num = scan.nextInt();
		
		System.out.println("해당 학생의 정보를 수정합니다.\n");
		System.out.print("전화번호: ");
		String phone = scan.next();
		System.out.print("주   소: ");
		scan.nextLine();
		String addr = scan.nextLine();
		
		Student s = new Student(num, phone, addr);
		
		// Service로 전달(파라미터로 객체를 담아서)
		int isOk = svc.update(s);
		System.out.println(isOk>0? "학생 정보가 수정되었습니다." : "학생 정보 수정에 실패했습니다.");
		
	}
	
	// (5) 학생 정보 삭제
	private void remove() {
		System.out.println("다음 목록에서 삭제할 학생을 골라주세요.\n");
		printList();
		System.out.print("선택: ");
		int num = scan.nextInt();
		
		// Service로 전달(파라미터로 객체를 담아서)
		int isOk = svc.delete(num);
		System.out.println(isOk>0? "학생 정보가 삭제되었습니다." : "학생 정보 삭제에 실패했습니다.");
	}
	
	
}
