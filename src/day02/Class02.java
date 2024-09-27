package day02;

public class Class02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성자 : 객체를 생성하기 위해 객체의 초기화를 담당
		// Car c = new Car(); => 클래스 객체명 = new 생성자();
		// 생성자는 여러개 만들 수 있음(생성자 오버로딩)
		// 생성자명은 클래스명과 동일
		// 생성자가 하나도 없는 경우는 기본 생성자를 자동으로 생성 Car()
		// 생성자를 하나라도 생성하면 기본 생성자는 주지 않음
		// 생성자를 사용자 지정으로 생성하려면 기본 생성자도 같이 생성해야함
		// 생성자 오버로딩 조건 (매개변수 개수가 달라야하거나 매개변수 타입이 달라야함)
		// 생성자 호출 가능(생성자 내에서만)
		// this : 내 클래스의 요소라는 것을 나타내는 키워드
		// 객체를 생성할 때 초기값 지정
		// 생성자의 접근제한자는 반드시 public이어야 함
		// 생성자명은 클래스명과 반드시 같아야함
		// 생성자는 메서드와 달리 return 타입이 없음
		
		Car c = new Car("아반떼","블랙","2024");
		// 생성자 호출은 단 한번, 객체 생성 시에만 가능하다.
		c.printCar();
		c.speedUp();
		c.setPower();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.printSet();
		c.setPower();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.setPower();
		c.printSet();
		
		Car c2 = new Car("소나타");
		c2.printCar(); // 소나타(null/null)
		Car c3 = new Car("테라칸", "검정");
		c3.printCar();
		Car c4 = new Car("그랜저", "검정", "2024");
		c4.printCar();
	}

}

// Car 클래스 생성
// 멤버변수 : name, color, year, power, speed
// 메서드 : print ex. 소나타(블랙/2024) 출력
// power : 시동 상태를 나타내는 메서드 (true, false)
// speed : 속도 up 메서드, down 메서드
// 멤버변수 > 생성자 > 메서드 > getter setter

class Car {
	//멤버변수
	private String name;
	private String color;
	private String year;
	private boolean power = false;
	private int speed;
	
	//생성자
	public Car() {
		
	}
	
	public Car(String name) {
		this.name = name;
		
	}
	
	public Car(String name, String color) {
		this.name = name;
		this.color = color;
		
	}
	
//	public Car(String name, String year) {
//		// 위의 생성자와 타입과 개수가 동일해 오버로딩할 수 없음
//	}
	
	//생성자 호출 : 생성자 내에 다른 생성자의 값과 완전히 동일한 값이 있을 경우 사용 가능 
	public Car(String name, String color, String year) {
//		this.name = name;
//		this.color = color;
		this(name,color); // 반드시 첫 줄에서 호출
		this.year = year;
	}
	
	//자동 완성 가능! 
	public Car(String name, String color, String year, boolean power, int speed) {
//		super();
		// 오브젝트의 기본생성자, 생략가능
		this(name, color, year); // 생성자 호출, super와 같이 쓸 수 없네?
		this.power = power;
		this.speed = speed;
	}
	
	//메서드
	//출력
	public void printCar() {
		System.out.println(name + "(" + color + "/" + year + ")");
	}	

	//시동
	public void setPower() {
		if(speed != 0) {
			System.out.println("자동차를 세우고 시동을 꺼주세요.");
		}else {
			this.power = !this.power;		
			System.out.println(power? "시동이 켜졌습니다!" : "시동이 꺼졌습니다!");
		}
	}
	
	//속도1
	public void speedUp() {
		if(this.power) {
			this.speed += 50;
			if(this.speed>200) {
				this.speed = 200;
				System.out.println("최고 속도를 넘었습니다.");
			}
		}else {
			System.out.println("속도 조작 불가능 : 시동 OFF");
		}
	}
	
	//속도2
	public void speedDown() {
		if(this.power) {
			this.speed -= 50;				
			if(this.speed<0) {
				this.speed = 0;
				System.out.println("더 이상 감속할 수 없습니다.");
			}
		}else {
			System.out.println("속도 조작 불가능 : 시동 OFF");
		}
	}
	
	//상태 출력
	public void printSet() {
		String str = power? "ON" : "OFF";
		System.out.printf("-----------------\n시동 %s\n속도 %d\n", str, speed);
	}

	//Getters And Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}