package day07;

class PasswordTest{
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		// Exception 처리
		if(password == null) {
			throw new PasswordException("비밀번호는 null일 수 없습니다.");
		}else if(password.length() < 5){
			throw new PasswordException("비밀번호는 5자 이상이어야 합니다.");			
		}else if(password.matches("[a-zA-z]+")){
			throw new PasswordException("비밀번호는 숫자나 특수문자를 포함해야 합니다.");			
		}
		this.password = password;
	}
	
	
}


public class ExceptionEx02 {

	public static void main(String[] args) {
		/* 사용자 정의 Exception!!
		 * 사용자가 직접 Exception 클래스 생성 시 
		 * IllegalArgumentException 클래스 상속
		 * 메서드의 부적절한 인수를 사용자가 결정
		 * 
		 * passwordException
		 * - 비밀번호는 null일 수 없다.
		 * - 비밀번호의 길이는 5자 이상
		 * - 비밀번호는 문자로만 이루어지면 안됨(숫+문, 문+특+숫)
		 * 
		 */
		
		PasswordTest pt = new PasswordTest();
//		String password = null;
//		String password = "abc";
//		String password = "abcdef";
		String password = "abcdef01";
		
		try {
			pt.setPassword(password);
			System.out.println(pt.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
