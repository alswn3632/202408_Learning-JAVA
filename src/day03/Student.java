package day03;

// 학생 클래스 생성
/* 멤버변수 : 지점, 이름, 과정, 전화번호
 * 생성자 : 
 * - 지점과 이름만 받는 생성자
 * - 지점, 이름, 과정, 전화번호를 받는 생성자(생성자 호출 이용)
 * 메서드 : 해당 내용을 출력하는 메서드 print(), getter/setter
 */

/* 객체를 생성할 때 값을 초기화 하는 방법
 * 1. 기본값 : 기본적으로 지정되는 값 int = 0, String = null
 * 2. 명시적 초기값 : 사용자가 멤버변수를 선언함과 동시에 값을 지정
 * ex. private String branch = "인천";
 * 3. 초기화 블럭 : { } 멤버변수들의 초기화
 * 4. 생성자 
 * 
 * 우선순위 : 기본값 < 명시적 초기값 < 초기화 블럭 < 생성자
 */

/* 객체의 내용을 출력하는 메서드 
 * toString 자동 생성 가능!
 */
public class Student {
	//멤버변수
	private String branch;
	private String name;
	private String course;
	private String phoneNum;
	{
		// 초기화 블럭 예시
		branch = "인천";
		course = "AWS";
		phoneNum = "010-1111-1111";
	}
	
	//생성자
	public Student() {
		
	}

	public Student(String branch, String name) {
		this.branch = branch;
		this.name = name;
	}

	public Student(String branch, String name, String course, String phoneNum) {
		this(branch, name);
		this.course = course;
		this.phoneNum = phoneNum;
	}
	
	//메서드
	public void print() {
		System.out.printf("%s지점, %s과정, %s학생(%s)", branch,course,name,phoneNum);
	}

	//toString
	//@Override : 어노테이션(애너테이션) 
	//override(오버라이드) : 부모의 메서드를 자식이 가져와서 재정의 하는 기능
	@Override
	public String toString() {
		return "Student [branch=" + branch + ", name=" + name + ", course=" + course + ", phoneNum=" + phoneNum + "]";
	}

	//Getters and Setters
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}

