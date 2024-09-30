package day04;

public class StudentMain {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동","980421","010-1111-2222",27,"인천");
		s1.print_co();
		s1.setCourse("자바", "6개월");
		s1.setCourse("파이썬", "3개월");
		s1.setCourse("SQLD", "2개월");
		s1.setCourse("정보처리기사", "2개월");
		s1.setCourse("리액트", "2개월");
		s1.setCourse("자바스크립트", "2개월");
		s1.print_st();
		s1.print_ac();		
		s1.print_co();
		
		Student s2 = new Student("신짱구", "950202","010-1111-3333",25,"서울");
		s2.print_st();
		s2.setCourse("자바", "6개월");
		s2.setCourse("리액트", "2개월");
		s2.setCourse("HTML", "2개월");
		s2.print_co();
		
		Student s3 = new Student("신짱아", "951020","010-1111-4444",24,"인천");
		
		Student[] std = new Student[8];
		
		std[0] = s1;
		std[1] = s2;
		std[2] = s3;
		
		std[3] = new Student("박철수", "951020","010-1111-5555",23,"서울");
		std[3].setCourse("자바", "6개월");
		std[3].setCourse("파이썬", "3개월");
		
		std[4] = new Student("한유리", "951020","010-1111-6666",23,"서울");
		std[4].setCourse("파이썬", "3개월");
		std[4].setCourse("리액트", "2개월");
		std[4].setCourse("HTML", "2개월");
		
		std[5] = new Student("이훈이", "951020","010-1111-7777",21,"서울");
		std[5].setCourse("파이썬", "3개월");
		std[5].setCourse("SQLD", "2개월");
		
		std[6] = new Student("맹구", "951020","010-1111-8888",21,"인천");
		std[6].setCourse("C++", "6개월");
		
		std[7] = new Student("신형만", "951020","010-1111-9999",25,"인천");
		
		// 학생 전체 명단 출력(학생정보만)
		System.out.println("-------------------------------------------");
		for(int i=0; i<std.length; i++) {
			std[i].print_st();
		}
		// 홍길동 학생의 학생정보, 학원정보, 수강정보 출력
		System.out.println("-------------------------------------------");
		for(int i=0; i<std.length; i++) {
			if(std[i].getSt_name().equals("홍길동")) {
				std[i].print_st();
				std[i].print_ac();
				std[i].print_co();
			}
		}
		
		// 인천 지점의 학생 명단 출력(학생정보만)
		System.out.println("-------------------------------------------");
		for(int i=0; i<std.length; i++) {
			if(std[i].getAc_branch() != null) {
				if(std[i].getAc_branch().equals("인천")) {
					std[i].print_st();
				}				
			}
		}
		
		// 자바 과목을 수강하는 학생 명단 출력(학생정보, 학원정보, 수강정보 전부 출력)
		System.out.println("-------------------------------------------");
		for(int i=0; i<std.length; i++) {
			boolean contain = false;

			for(int j=0; j<std[i].getIdx(); j++) {
				if(std[i].getCo_name()[j].equals("자바")) {
					contain = true;
				}
			}
			
			if(contain) {					
				std[i].print_st();
				std[i].print_ac();
				std[i].print_co();
				System.out.println();
			}
		}
		
		// 수강하지 않는 학생 명단 출력
		System.out.println("-------------------------------------------");
		for(int i=0; i<std.length; i++) {
			if(std[i].getIdx() == 0) {
				std[i].print_st();
			}
		}
		
		
		
		
		
		
		
		
		
	}
}

