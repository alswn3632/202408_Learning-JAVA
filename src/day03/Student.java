package day03;

// 학생 클래스 생성
/* 멤버변수 : 지점, 이름, 과정, 전화번호
 * 생성자 : 
 * - 지점과 이름만 받는 생성자
 * - 지점, 이름, 과정, 전화번호를 받는 생성자(생성자 호출 이용)
 * 메서드 : 해당 내용을 출력하는 메서드 print(), getter/setter
 * 
 */
public class Student {
	//멤버변수
	private String branch;
	private String name;
	private String course;
	private String phoneNum;
	
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

