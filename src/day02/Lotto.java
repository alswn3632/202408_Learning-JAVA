package day02;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 로또 만들기
		 */
		Lotto l = new Lotto();
		String result = "";
		long cnt = 0;
		int lotto[] = new int[7]; // 당첨 번호
		l.generator(lotto);
		
		while(!(result.equals("1등"))) {
			cnt++;
			
			int user[] = new int[6]; // 사용자 번호
			
			l.generator(user);
			l.printLotto(user);
			result = l.result(user, lotto);
		
		}
		
		l.printLotto(lotto);
		System.out.println(cnt);

	}
	/* 배열을 매개변수로 받아서 1~45까지의 랜덤 수를 채워서 생성(중복불가능-메서드 호출로 구현)
	 * 리턴할 필요가 없음. main에 있는 배열을 채우기.
	 */
	public void generator(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			int num = (int)(Math.random()*45)+1;
			Lotto l = new Lotto();
			if(l.verification(arr,num)) {
				i--;
			}else {
				arr[i] = num;				
			}
		}
	}
	
	/* 배열과 값을 주고 같은지 비교하는 메서드
	 * 배열에 값이 있으면 true, 없으면 false
	 */
	public boolean verification(int arr[], int num) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	/* 배열의(매개변수)의 값을 출력하는 메서드
	 * 로또번호 : 1 2 3 4 5 6 [7]
	 * 사용자번호 : 1 2 3 4 5 6
	 */
	public void printLotto(int arr[]) {
		if(arr.length == 6) {
			// 보너스 x
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}else if(arr.length == 7) {
			// 보너스 o
			for(int i=0; i<arr.length; i++) {
				if(i<6) {
					System.out.print(arr[i] + " ");					
				}else if(i == 6) {					
					System.out.print("[" + arr[i] + "]" + " ");					
				}
			}
			System.out.println();
		}
	}
	
	/* 등수 확인 메서드
	 * 당첨기준
	 * user 번호를 기준으로
	 * 6개 일치 - 1등, 5개 일치+보너스번호 - 2등, 5개일치+보너스X - 3등, 4개일치 - 4등, 3개일치 - 5등, 나머지 - 꽝
	 */
	public String result(int user[], int lotto[]) {
		
		if(user.length >= lotto.length) {
			System.out.println("사용자 번호, 로또 번호 순서대로 파라미터를 기입해주세요.");
			return "오류";
		}else {
			
			int cnt = 0;
			boolean bonus = false;
			
			for(int i=0; i<user.length; i++) {
				for(int j=0; j<lotto.length; j++) {
					if(user[i] == lotto[j]) {
						if(j == 6) { bonus = !bonus; }
						else { cnt++; }
					}
				}
			}
			
			String str = "";
			
			if(bonus && cnt == 4) {
				str = "2등";
			}else {
				switch(cnt) {
				case 6:
					str = "1등";
					break;
				case 5:
					str = "3등";
					break;
				case 4:
					str = "4등";
					break;
				case 3:
					str = "5등";
					break;
				default: 
					str = "꽝";
				}
			}
			
			System.out.println(str);
			return str;
		}
	}
}
