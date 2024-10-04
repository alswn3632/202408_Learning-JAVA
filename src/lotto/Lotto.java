package lotto;

public class Lotto {
	//멤버변수
	protected int lottoArr [] = new int [6];
	protected int round;
	
	//생성자
	public Lotto() { }
	
	//메서드
	public int[] createLotto() { //로또생성 (자동)
		int [] tmp = new int[6];
		for(int i=0; i<tmp.length; i++) {
			int num = (int)(Math.random()*45)+1;
			if(verifyOver(tmp,num)) {
				i--;
			}else {
				tmp[i] = num;				
			}
		}
		return tmp;
	}
	
	public int[] createLotto(int ...arr) { //로또생성 (수동)
		int [] tmp = new int[6];
		int a = -1;
		
		for(int i=0; i<arr.length; i++) {
			tmp[i] = arr[i];
			a = i+1;
		}
		
		for(int i=a; i<tmp.length; i++) {
			int num = (int)(Math.random()*45)+1;
			if(verifyOver(tmp,num)) {
				i--;
			}else {
				tmp[i] = num;				
			}
		}

		return tmp;
	}
	
	public boolean verifyOver(int arr[]) { //중복검사 배열 내부
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean verifyOver(int arr[], int num) { //중복검사 배열과 특정한 숫자
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public void printLotto() { //출력
		System.out.print("[" + round + "회차] ");
		for(int i=0; i<lottoArr.length; i++) {
			System.out.print(lottoArr[i] + " ");
		}
	}

	//Getters and Setters
	public int[] getLottoArr() {
		return lottoArr;
	}

	public void setLottoArr(int[] lottoArr) {
		this.lottoArr = lottoArr;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
}
