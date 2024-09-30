package day03;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 여기서 Student 클래스 테스트
		Student s1 = new Student("인천", "신짱구", "AWS", "010-1234-1111");
		s1.print();
		System.out.println();
		Student s0 = new Student("인천", "신짱아");
		s0.print();
		System.out.println();
		System.out.println(s1);
		System.out.println("--------------------------------------------------------------------");
		// toString이 없으면 객체의 주소가 출력됨
		Student s2 = new Student("인천", "박철수", "JAVA", "010-1234-2222");
		Student s3 = new Student("서울", "이훈이", "AWS", "010-1234-3333");
		Student s4 = new Student("인천", "한유리", "AWS", "010-1234-4444");
		Student s5 = new Student("서울", "맹구", "JAVA", "010-1234-5555");
		Student [] studentArr = new Student[6];
		studentArr[0] = s0;
		studentArr[1] = s1;
		studentArr[2] = s2;
		studentArr[3] = s3;
		studentArr[4] = s4;
		studentArr[5] = s5;
		
		// 전체 학생 명단 출력
		for(int i=0; i<studentArr.length; i++) {
			System.out.println(studentArr[i]);
		}
		
		// 신짱아 정보 출력
		System.out.println("--------------------------------------------------------------------");
		String searchName = "신짱아";
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i].getName().equals(searchName)) {
				System.out.println(studentArr[i]);
			}
		}
		
		// 인천 지점 학생들 명단 출력
		// 학생이 없다면 명단이 없습니다. 출력
		System.out.println("--------------------------------------------------------------------");
		String searchBranch = "서울";
		int cntB = 0;
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i].getBranch().equals(searchBranch)) {
				System.out.println(studentArr[i]);
				cntB++;
			}
		}
		if(cntB == 0) {System.out.println("명단이 없습니다.");}
		
		// 신짱아의 course을 AWS에서 JAVA로 변경 후 출력
		System.out.println("--------------------------------------------------------------------");
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i].getName().equals(searchName)) {
				studentArr[i].setCourse("JAVA");
				System.out.println(studentArr[i]);
			}
		}
	
	}

}
