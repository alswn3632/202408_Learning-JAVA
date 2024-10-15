package day11;

public class Thread02 {

	public static void main(String[] args) {
		// 2. runnable 구현하는 방법
		System.out.println(Thread.currentThread().getName()); // main
		System.out.println(Thread.currentThread().getId()); // 1
		System.out.println(Thread.currentThread().getPriority()); // 5 (우선순위)
		
		System.out.println("Main Thread Start!!");
		
		MyThread2 mt = new MyThread2();
		Thread th1 = new Thread(mt);
		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Thread End!!");
		// 원래는 순차처리하던 것을 병렬처리함 >> Start, end, Thread0/1병렬처리
		// 동시에 여러 개의 Thread가 실행될 때 다른 Thread의 결과를 참조하여 실행되어야할 경우
		// >> join() 메서드 사용 (try~catch 필요)
		
		
	}

}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		// 0부터 500까지 반복해서 실행하는 구문 수행
		for(int i=0; i<=500; i++) {
			System.out.println(i+"번째 Thread >>"+Thread.currentThread().getName());
			// Runnable 인터페이스를 구현한 것이라 getName을 가져올 수 없음!!
		}
		
	}
	
}