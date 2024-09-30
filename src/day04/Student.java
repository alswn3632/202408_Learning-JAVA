package day04;

// 학생 정보를 관리하기 위한 클래스
/* 멤버변수
 * - 학생 기본 정보 : 이름, 생년월일, 전화번호, 나이
 * - 학원 정보 : 학원명="EZEN" (final static), 지점
 * - 수강 정보 : 수강 과목, 기간
 * => 여러과목을 들을 수 있음(여러 과목을 수강하기 위해서는 배열로 처리 5과목까지 가능)
 * ex) 홍길동(980101) 010-1111-1111 / 25 >> 학생 정보
 * 	   EZEN(인천) >> 학원 정보
 *     자바6개월, 파이썬 1개월, SQLD 1개월 ... >> 수강 정보 
 * 기능(메서드)
 * - 학생의 기본 정보를 출력하는 기능
 * - 학원 정보를 출력하는 기능
 * - 수강 정보를 출력하는 기능
 * - 수강 정보를 추가하는 기능
 *     
 */
public class Student {
	//멤버변수
	private String st_name;
	private String st_birth;
	private String st_phone;
	private int st_age;
	private static final String AC_NAME = "EZEN";
	private String ac_branch;
	private String [] co_name = new String[5];
	private String [] co_term = new String[5];
	private int idx;
	
	//생성자
	public Student(){
		
	}

	public Student(String st_name, String st_birth, String st_phone, int st_age) {
		//학생정보: 이름, 생년월일, 전화번호, 나이
		this.st_name = st_name;
		this.st_birth = st_birth;
		this.st_phone = st_phone;
		this.st_age = st_age;
	}
	
	public Student(String st_name, String st_phone, String ac_branch) {
		//이름, 전화번호, 지점
		this.st_name = st_name;
		this.st_phone = st_phone;
		this.ac_branch = ac_branch;
	}
	
	public Student(String st_name, String st_birth, String st_phone, int st_age, String ac_branch) {
		//수강정보 제외 전부
		this.st_name = st_name;
		this.st_birth = st_birth;
		this.st_phone = st_phone;
		this.st_age = st_age;
		this.ac_branch = ac_branch;
	}
	
	//메서드
	public void print_st() {
		System.out.printf("%s(%s) %s / %d\n", st_name, st_birth, st_phone, st_age);
	}
	
	public void print_ac() {
		System.out.printf("%s(%s)\n", AC_NAME, ac_branch);
	}
	
	public void print_co() {
		if(co_name.length == 0 || idx == 0) {
			System.out.println("수강과목이 없습니다.");
			return;
		}else {
			for(int i=0; i<idx; i++) {
				if(i == idx-1) {
					System.out.printf("%s %s\n", co_name[i], co_term[i]);						
				}else {
					System.out.printf("%s %s, ", co_name[i], co_term[i]);										
				}
			}			
		}
	}
	
	public void setCourse(String name, String term) {
		if(idx == 5) {
			System.out.println("더이상 추가할 수 없습니다.");
			//배열을 늘려서 더 많은 수강을 받을 수 도 있음. (배열복사*)
		}else {
			co_name[idx] = name;
			co_term[idx] = term;
			idx++;			
		}
	}

	//Getters and Setters
	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_birth() {
		return st_birth;
	}

	public void setSt_birth(String st_birth) {
		this.st_birth = st_birth;
	}

	public String getSt_phone() {
		return st_phone;
	}

	public void setSt_phone(String st_phone) {
		this.st_phone = st_phone;
	}

	public int getSt_age() {
		return st_age;
	}

	public void setSt_age(int st_age) {
		this.st_age = st_age;
	}

	public String getAc_name() {
		return AC_NAME;
	}

	public String getAc_branch() {
		return ac_branch;
	}

	public void setAc_branch(String ac_branch) {
		this.ac_branch = ac_branch;
	}

	public String[] getCo_name() {
		return co_name;
	}

	public void setCo_name(String[] co_name) {
		this.co_name = co_name;
	}

	public String[] getCo_term() {
		return co_term;
	}

	public void setCo_term(String[] co_term) {
		this.co_term = co_term;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	
	
}
