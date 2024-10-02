package student;

import java.util.Scanner;

public interface Program {
	// 1. 학생등록 2. 학생리스트출력 3. 학생검색(학생정보,수강정보) 
	// 4. 학생정보수정 5. 학생삭제 6. 수강신청 7. 수강철회 6. 종료
	
	void insertStudent(Scanner scan);
	
	void printStudent();
	
	void searchStudent(Scanner scan);
	
	void modifyStudent(Scanner scan);
	
	void deleteStudent(Scanner scan);
	
	void registerSubject(Scanner scan);
	
	void deleteSubject(Scanner scan);
}
