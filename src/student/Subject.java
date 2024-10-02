package student;

public class Subject {
	//멤버변수
	private String sb_code;
	private String sb_name;
	private String sb_credit;
	private int sb_time;
	private String sb_professor;
	private String sb_timetable;
	private String sb_classroom;
	
	//메서드
	public void insertSb(String sb_code, String sb_name, String sb_credit, int sb_time, String sb_professor, String sb_timetable, String sb_classroom) {
		this.sb_code = sb_code;
		this.sb_name = sb_name;
		this.sb_credit = sb_credit;
		this.sb_time = sb_time;
		this.sb_professor = sb_professor;
		this.sb_timetable = sb_timetable;
		this.sb_classroom = sb_classroom;
	}
	
	@Override
	public String toString() {
		return "[과목코드=" + sb_code + ", 과목명=" + sb_name + ", 학점=" + sb_credit + ", 시수="
				+ sb_time + ", 교수명=" + sb_professor + ", 시간표=" + sb_timetable + ", 강의실="
				+ sb_classroom + "]";
	}



	public String getSb_code() {
		return sb_code;
	}

	public void setSb_code(String sb_code) {
		this.sb_code = sb_code;
	}

	public String getSb_name() {
		return sb_name;
	}

	public void setSb_name(String sb_name) {
		this.sb_name = sb_name;
	}

	public String getSb_credit() {
		return sb_credit;
	}

	public void setSb_credit(String sb_credit) {
		this.sb_credit = sb_credit;
	}

	public int getSb_time() {
		return sb_time;
	}

	public void setSb_time(int sb_time) {
		this.sb_time = sb_time;
	}

	public String getSb_professor() {
		return sb_professor;
	}

	public void setSb_professor(String sb_professor) {
		this.sb_professor = sb_professor;
	}

	public String getSb_timetable() {
		return sb_timetable;
	}

	public void setSb_timetable(String sb_timetable) {
		this.sb_timetable = sb_timetable;
	}

	public String getSb_classroom() {
		return sb_classroom;
	}

	public void setSb_classroom(String sb_classroom) {
		this.sb_classroom = sb_classroom;
	}
	
	
	

}
