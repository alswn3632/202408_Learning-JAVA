package day11;

public class Singleton02 {
	
	public static void main(String[] args) {
		// Counter 객체를 2개 생성하여 각각 countMethod() 호출
		// 1개의 객체가 공유되기 때문에 1개의 변수만 변화
		
		Counter c1 = Counter.getInstance();
		Counter c2 = Counter.getInstance();
		
		c1.countMethod();
		c2.countMethod();
		
		System.out.println(c1.getCount());
		System.out.println(c2.getCount());
		
		
	}
}

class Counter {
	//생글톤으로 생성
	private int count;
	private static Counter instance;

	private Counter() {}
	
	public static Counter getInstance() {
		if(instance == null) {
			instance = new Counter();
		}
		return instance;
	}
	
	public void countMethod() {
		this.count++;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}