package student;

import java.util.Scanner;

import day05.Product;

public class StudentController implements Program{
	//멤버변수
	private Student[] st_arr = new Student[10];
	private int cnt;
	
	//메서드
	@Override
	public void insertStudent(Scanner scan) {
		if(cnt>=st_arr.length) {
			Student [] newArr = new Student[st_arr.length+10];
			System.arraycopy(st_arr, 0, newArr, 0, cnt);
			
			this.st_arr = newArr;
		}
		System.out.print("학번:");
		String str1 = scan.next();
		System.out.print("이름:");
		String str2 = scan.next();
		System.out.print("나이:");
		int num1 = scan.nextInt();
		System.out.print("전화번호:");
		String str3 = scan.next();
		
		Student s = new Student();
		s.insertSt(str1, str2, num1, str3);
		st_arr[cnt] = s;
		cnt++;
	}

	@Override
	public void printStudent() {
		for(int i=0; i<cnt; i++) {
			System.out.println(st_arr[i].toString());
		}
	}

	@Override
	public void searchStudent(Scanner scan) {
		int num = searchIndex(scan);
		if(num != -1) {
			System.out.println("--학생정보--");
			System.out.println(st_arr[num].toString());
			System.out.println("--수강정보--");
			for(int j=0; j<st_arr[num].getCnt(); j++) {
				System.out.println(st_arr[num].getSb_arr()[j].toString());
			}
		}else {
			System.out.println("일치하는 학생이 없습니다.");			
		}
	}

	@Override
	public void modifyStudent(Scanner scan) {
		int num = searchIndex(scan);
		if(num != -1) {
			System.out.print("학번:");
			String str1 = scan.next();
			System.out.print("이름:");
			String str2 = scan.next();
			System.out.print("나이:");
			int num1 = scan.nextInt();
			System.out.print("전화번호:");
			String str3 = scan.next();
			st_arr[num].insertSt(str1, str2, num1, str3);
			return;
		}else {
			System.out.println("일치하는 학생이 없습니다.");			
		}
	}

	@Override
	public void deleteStudent(Scanner scan) {
		int num = searchIndex(scan);
		
		if(num != -1) {
			int copyCut = st_arr.length - num - 1;
			System.arraycopy(st_arr, num+1, st_arr, num, copyCut);
			
			st_arr[cnt-1] = null;
			cnt--;
			System.out.println("삭제되었습니다.");
		}else {
			System.out.println("일치하는 학생이 없습니다.");			
		}
	}

	@Override
	public void registerSubject(Scanner scan) {
		int num = searchIndex(scan);
		if(num != -1) {
			System.out.print("과목코드:");
			String str1 = scan.next();
			System.out.print("과목명:");
			String str2 = scan.next();
			System.out.print("학점:");
			String str3 = scan.next();
			System.out.print("시수:");
			int num1 = scan.nextInt();
			System.out.print("교수명:");
			String str4 = scan.next();
			System.out.print("시간표:");
			String str5 = scan.next();
			System.out.print("강의실:");
			String str6 = scan.next();
			
			Subject s = new Subject();
			s.insertSb(str1, str2, str3, num1, str4, str5, str6);
			st_arr[num].insertArr(s); //5개 제한 걸어야함
			return;
		}else {
			System.out.println("일치하는 학생이 없습니다.");			
		}
	}


	@Override
	public void deleteSubject(Scanner scan) {
		int num = searchIndex(scan);
		if(num != -1) {
			// 수강 과목이 없다면 반려
			if(st_arr[num].getCnt() == 0) {
				System.out.println("수강하고 있는 과목이 없습니다.");
				return;
			}
			
			// 수강 과목이 있다면 실행될 삭제 프로세스
			System.out.print("과목명:");
			String str2 = scan.next();
			int index = -1;
			// 검색한 과목명의 index 값을 찾아줌
			for(int j=0; j<st_arr[num].getCnt(); j++) {
				if((st_arr[num].getSb_arr()[j].getSb_name()).equals(str2)) {
					index = j;
				}
			}

			// index 값을 가지고 Student 객체 내 Subject 배열에 위치한 값을 찾아 삭제
			if(index != -1) {
				int copyCut = st_arr[num].getSb_arr().length - index - 1;
				System.arraycopy(st_arr[num].getSb_arr(), index+1, st_arr[num].getSb_arr(), index, copyCut);
				
				st_arr[num].getSb_arr()[st_arr[num].getCnt()-1] = null;
				int a = st_arr[num].getCnt() - 1;
				st_arr[num].setCnt(a);
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("일치하는 과목명이 없습니다.");
			}
			return;
		}else {
			System.out.println("일치하는 학생이 없습니다.");			
		}
		
	}

	@Override
	public int searchIndex(Scanner scan) {
		System.out.print("이름:");
		String str = scan.next();
		
		for(int i=0; i<cnt; i++) {
			if((st_arr[i].getSt_name()).equals(str)) {
				return i;
			}
		}
		System.out.println("일치하는 학생이 없습니다.");
		return -1;
	}
	
}
