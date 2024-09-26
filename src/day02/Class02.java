package day02;

public class Class02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car("아반떼","블랙","2024");
		c.printCar();
		c.speedUp();
		c.setPower();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.setPower();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.setPower();
	}

}

// Car 클래스 생성
// 멤버변수 : name, color, year, power, speed
// 메서드 : print ex. 소나타(블랙/2024) 출력
// power : 시동 상태를 나타내는 메서드 (true, false)
// speed : 속도 up 메서드, down 메서드

class Car {
	private String name;
	private String color;
	private String year;
	private boolean power = false;
	private int speed;
	
	public Car() {
		
	}
	
	public Car(String name, String color, String year) {
		this.name = name;
		this.color = color;
		this.year = year;
	}
	
	public void printCar() {
		System.out.println(name + "(" + color + "/" + year + ")");
	}
	
	public void setPower() {
		if(speed != 0) {
			System.out.println("자동차를 세우고 시동을 꺼주세요.");
		}else {
			this.power = !this.power;		
			System.out.println(power? "시동이 켜졌습니다!" : "시동이 꺼졌습니다!");
		}
	}
	
	public void speedUp() {
		if(this.power) {
			this.speed++;
			if(this.speed>200) {
				this.speed = 200;
				System.out.println("최고 속도를 넘었습니다.");
			}
			System.out.println("현재 속도: " + speed);
		}else {
			System.out.println("시동이 꺼져있습니다.");
		}
	}
	
	public void speedDown() {
		if(this.power) {
			this.speed--;				
			if(this.speed<0) {
				this.speed = 0;
				System.out.println("더이상 감속은 불가능!");
			}
			System.out.println("현재 속도: " + speed);
		}else {
			System.out.println("시동이 꺼져있습니다.");
		}
	}

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