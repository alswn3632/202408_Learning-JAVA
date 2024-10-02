package student;

import java.util.Arrays;

public class Student {
	//멤버변수
	private String st_num;
	private String st_name;
	private int st_age;
	private String st_phone;
	private Subject[] sb_arr = new Subject[10];
	private int cnt;
		
	//메서드
	@Override
	public String toString() {
		return "[학번=" + st_num + ", 이름=" + st_name + ", 나이=" + st_age + ", 전화번호=" + st_phone+ "]";
	}
	
	public void insertSt(String st_num, String st_name, int st_age, String st_phone) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_age = st_age;
		this.st_phone = st_phone;
	}	

	public void insertArr(Subject a) {
		if(cnt>=sb_arr.length) {
			Subject [] newArr = new Subject[sb_arr.length+10];
			System.arraycopy(sb_arr, 0, newArr, 0, cnt);
			
			this.sb_arr = newArr;
		}
		sb_arr[cnt] = a;
		cnt++;
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

	public int getSt_age() {
		return st_age;
	}

	public void setSt_age(int st_age) {
		this.st_age = st_age;
	}

	public String getSt_phone() {
		return st_phone;
	}

	public void setSt_phone(String st_phone) {
		this.st_phone = st_phone;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Subject[] getSb_arr() {
		return sb_arr;
	}

	public void setSb_arr(Subject[] sb_arr) {
		this.sb_arr = sb_arr;
	}
}
