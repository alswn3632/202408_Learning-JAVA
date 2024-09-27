package day03;

public class Class03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t = new Tv("LG");
		t.print();
		t.power();
		t.power();
		t.chDown();
		t.power();
		t.volUp();
		t.volUp();
		t.chUp();
		t.chUp();
		t.chUp();
		t.chDown();
		t.chDown();
		t.chDown();
		t.chDown();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volMute();
		t.volMute();
		t.power();
		t.power();
		t.volUp();
	}

}

// Tv 클래스 생성
/* 멤버변수 : brand, power, channel, volume
 * 메서드 : power(), chUp(), chDown(), volUp(), volDown(), 음소거버튼? (채널은 순환, 볼륨은 한계)
 */

/* final : 변경할 수 없는 값을 지정, 대문자 표기가 원칙, 초기값을 지정해줌 >> 생성자 setter 다 막힘
 * 
 */

class Tv {
	//멤버변수
//	private final String BRAND = "LG";
	private String brand;
	private boolean power = false;
	private int channel = 1;
	private int volume;
	private int preVol = -1;
	
	//생성자
	public Tv() {
		this.volume =  3;
	}
	
	public Tv(String brand) {
		this.brand = brand;
		this.volume =  3;
	}
	
	//메서드
	public void print() {
		System.out.println("티비 정보: " + this.brand);
	}
	
	public void power() {
		this.power = !this.power;
		System.out.println(power? "전원이 켜졌습니다." : "전원이 꺼졌습니다.");
	}
	
	public void chUp() {
		if(power) {
			this.channel++;
			if(this.channel > 20) {
				this.channel = 1;
			}
			System.out.println("채널: " + this.channel);
		}else {
			System.out.println("(전원이 꺼져있습니다.)");
		}
	}
	
	public void chDown() {
		if(power) {
			this.channel--;
			if(this.channel < 1) {
				this.channel = 20;
			}
			System.out.println("채널: " + this.channel);
		}else {
			System.out.println("(전원이 꺼져있습니다.)");
		}
	}
	
	public void volUp() {
		if(power) {
			this.volume++;
			if(this.volume > 20) {
				this.volume = 20;
			}
			System.out.println("볼륨: " + this.volume);
		}else {
			System.out.println("(전원이 꺼져있습니다.)");
		}
	}
	
	public void volDown() {
		if(power) {
			this.volume--;
			if(this.volume < 0) {
				this.volume = 0;
			}
			System.out.println(this.volume == 0? "음소거" : "볼륨: " + this.volume);
		}else {
			System.out.println("(전원이 꺼져있습니다.)");
		}
	}
	
	public void volMute() {
		if(power) {
			if(preVol == -1) {
				this.preVol = this.volume;
				this.volume = 0;				
			}else {
				this.volume = this.preVol;
				this.preVol = -1;
			}
			System.out.println(preVol == -1? "음소거 OFF" + "\n볼륨: " + this.volume : "음소거 ON");
		}else {
			System.out.println("(전원이 꺼져있습니다.)");
		}
	}
	
	//Getters and Setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPreVol() {
		return preVol;
	}

	public void setPreVol(int preVol) {
		this.preVol = preVol;
	}
	
}
