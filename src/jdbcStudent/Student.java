package jdbcStudent;

public class Student {
	//멤버변수
	private int st_id;
	private String st_num;
	private String st_name;
	private String st_birth;
	private String st_phone;
	private String st_addr;
	private String st_regdate;
	
	//생성자
	public Student() {
		
	}

	public Student(String st_num, String st_name, String st_birth, String st_phone, String st_addr) {
		// (1) 학생 등록에서 사용
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_birth = st_birth;
		this.st_phone = st_phone;
		this.st_addr = st_addr;
	}

	public Student(int st_id, String st_num, String st_name, String st_phone) {
		// (2) 학생 목록에서 사용
		this.st_id = st_id;
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_phone = st_phone;
	}

	public Student(int st_id, String st_num, String st_name, String st_birth, String st_phone, String st_addr, String st_regdate) {
		// (3) 학생 검색에서 사용 
		this.st_id = st_id;
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_birth = st_birth;
		this.st_phone = st_phone;
		this.st_addr = st_addr;
		this.st_regdate = st_regdate;
	} 
		
	public Student(int st_id, String st_phone, String st_addr) {
		// (4) 학생 정보 수정에서 사용 
		this.st_id = st_id;
		this.st_phone = st_phone;
		this.st_addr = st_addr;
	}

	//메서드
	public void printList() {
		// (2) 학생 목록에서 사용
		System.out.println(st_id + ". " + st_name+"("+st_num+")"+" / "+st_phone);
	}
	
	public void printStudent() {
		// (3) 학생 검색에서 사용 
		
		System.out.println("[" + st_name + "]");
		System.out.println("학   번: " + st_num);
		System.out.println("생년월일: " + st_birth);
		System.out.println("전화번호: " + st_phone);
		System.out.println("주   소: " + st_addr);
	}


	@Override
	public String toString() {
		return "Student [st_id=" + st_id + ", st_num=" + st_num + ", st_name=" + st_name + ", st_birth=" + st_birth
				+ ", st_phone=" + st_phone + ", st_addr=" + st_addr + ", st_regdate=" + st_regdate + "]";
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public String getSt_num() {
		return st_num;
	}

	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}

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

	public String getSt_addr() {
		return st_addr;
	}

	public void setSt_addr(String st_addr) {
		this.st_addr = st_addr;
	}

	public String getSt_regdate() {
		return st_regdate;
	}

	public void setSt_regdate(String st_regdate) {
		this.st_regdate = st_regdate;
	}

}
