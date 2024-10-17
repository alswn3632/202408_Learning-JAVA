package monopoly;

import java.util.Objects;

public class Land {
	private int landPo;	//땅의 위치
	private String landType;	// 땅의 타입(출발지, 도시, 무인도, 황금열쇠, 사회복지기금, 세계여행)
	private Hotel hotel = null; 
	private String toggle = "off";// 호텔의 상태에 대한 on/off불리언. 데이터상에 있긴 하지만 off 상태. off되어있던걸 on으로만 바꿔서 하면 됨. 호텔을 넣고 빼고 하는 작업 필요 X
	private String landName;
	
	public Land() {}
	
	// 생성자 => 포지션, 타입, 통행료
	public Land(int landPo, String landType, String landName, Hotel hotel) {
		this.landPo = landPo;
        this.landType = landType;
        this.hotel = hotel; 
        this.landName = landName;
	}
	
	// 통행료 지불 메서드
	public int getToll() {
		if(hotel!=null && toggle.equals("on")) {
			return hotel.getToll();
		}
		else {
			return 0;
		}
    }

	// 호텔 상태를 토글
    public void toggleHotel() {
        if (toggle.equals("off")) {
            toggle = "on"; 
        } else {
            toggle = "off"; 
        }
    }

	public int getLandPo() {
		return landPo;
	}

	public void setLandPo(int landPo) {
		this.landPo = landPo;
	}

	public String getLandType() {
		return landType;
	}

	public void setLandType(String landType) {
		this.landType = landType;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getToggle() {
		return toggle;
	}

	public void setToggle(String toggle) {
		this.toggle = toggle;
	}


	public String getLandName() {
		return landName;
	}

	public void setLandName(String landName) {
		this.landName = landName;
	}

	@Override
	public String toString() {
		return "Land [landPo=" + landPo + ", landType=" + landType + ", hotel=" + hotel + ", toggle=" + toggle
				+ ", landName=" + landName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hotel, landName, landPo, landType, toggle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Land other = (Land) obj;
		return Objects.equals(landName, other.landName);
	}

	
	
	
}
