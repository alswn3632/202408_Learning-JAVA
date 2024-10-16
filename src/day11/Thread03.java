package day11;

public class Thread03 {

	public static void main(String[] args) {
		// 1~50, 51~100까지의 합을 구하는 두 개의 Thread를 생성
		// 그 결과를 확인
		
		// 두 개의 Thread가 실행되고 난 후 
		// Thread-0 1~50까지의 합계 출력
		// Thread-1 51~100까지의 합계 출력
		// main에서 두 개의 Thread의 합계를 출력(마지막에)
		
		// Thread.sleep() : 기다렸다가 실행
		// millisecond 단위 1초 = 1000
		
		JoinTest jt1 = new JoinTest(1,50);
		JoinTest jt2 = new JoinTest(51,100);
		
		System.out.println("--------준비~ 시작");
		long a = System.currentTimeMillis();
		jt1.start();
		try {
			jt1.join();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("중간점검 1~50 >> " + jt1.total);
		
		jt2.start();
		try {
			jt2.join();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("중간점검 51~100 >> " + jt2.total);
		
		System.out.println("--------땡 끝!" + (jt1.total + jt2.total));
		long b = System.currentTimeMillis();
		System.out.println(((b-a)/1000)+"초");
	}

}

class JoinTest extends Thread{
	int start;
	int end;
	int total;
	
	public JoinTest() {
		
	}
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			System.out.println(i);
			this.total += i;
		}
	}
	
}