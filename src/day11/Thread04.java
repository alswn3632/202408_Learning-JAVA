package day11;

public class Thread04 {
	// 계좌 생성 : 공유 영역에 생성
	public static Bank myBank = new Bank();
	
	
	public static void main(String[] args) {
		/* critical section (임계영역)은 두 개 이상의 thread가
		 * 동시에 접근할 수 있는 영역 ( >> 공유영역 )
		 * 동시에 여러개의 thread가 접근하여 공유영역을 가지려고 하면 문제가 발생할 수 있음
		 * >> 교착 상태 (deadlock)가 발생
		 * 한 순간에는 하나의 thread만 사용 가능하도록 >> 세마포어(semaphore)
		 * 세마포어를 얻은 스레드만 접근이 가능 / 나머지는 대기상태가 됨
		 * 
		 * 동기화(순서화) : synchronized
		 * 동기화가 필요한 메서드 앞에 선언
		 */
		
		/* bank 클래스 생성
		 * 계좌 1개 생성 => 공유 영역 (static)
		 * hong / hongwife
		 * 두 사람이 하나의 공유된 계정에서 돈을 인출한다면?
		 * 잔액 : 10000원 
		 * 동시에 10000원 인출하도록 유도해봄
		 */
		
		Hong h = new Hong();
		HongWife hw = new HongWife();
		
		hw.start();
		h.start();
		
		
		
	}

}

class Hong extends Thread{

	@Override
	public void run() {
		System.out.println("홍길동이 입금을 시작!");
		Thread04.myBank.saveMoney(10000);
		System.out.println("saveMoney(10000) 후 잔액 > " + Thread04.myBank.getMoney());
	}
	
}

class HongWife extends Thread{
	
	@Override
	public void run() {
		System.out.println("와이프가 출금을 시작!");
		Thread04.myBank.minusMoney(5000);
		System.out.println("mimnusMoney(5000) 후 잔액 > " + Thread04.myBank.getMoney());
	}
	
}

class Bank {
	private int money = 20000;
	
	// 입금 : synchronized 동기화 (순차접근)
	public synchronized void saveMoney(int save) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.money = m + save;
		// 1초 기다렸다가 저장해둔 값에 누적한 후 money에 적용
	}
	// 출금
	public synchronized void minusMoney(int minus) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.money = m - minus;
	}
	
	@Override
	public String toString() {
		return "Bank [money=" + money + "]";
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}