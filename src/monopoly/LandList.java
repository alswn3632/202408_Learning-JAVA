package monopoly;

import java.util.ArrayList;
import java.util.List;

public class LandList {
	private List<Land> landList; 	//Land 객체들 저장
	private HotelList hotelList;
	
	public LandList(HotelList hotelList) {
		this.hotelList = hotelList;
		this.landList = new ArrayList<Land>();
		add();
	}
	
	// 땅(도시, 황금열쇠, 사회복지기금,무인도, 세계여행) 목록 
	private void add() {
		landList.add(new Land(0, "출발지","출발지", null));  //get으로 가져와서 하기.
		landList.add(new Land(1, "도시","타이페이", hotelList.getHotel(1)));
		landList.add(new Land(2, "황금열쇠","황금열쇠1", null));
		landList.add(new Land(3, "도시","마닐라", hotelList.getHotel(3)));
		landList.add(new Land(4, "도시","베이징", hotelList.getHotel(4)));
		landList.add(new Land(5, "무인도","무인도", null));
		landList.add(new Land(6, "도시", "스톡홀름", hotelList.getHotel(6)));
		landList.add(new Land(7, "황금열쇠","황금열쇠2", hotelList.getHotel(7)));
		landList.add(new Land(8, "도시","아테나", hotelList.getHotel(8)));
		landList.add(new Land(9, "사회복지기금","사회복지기금", null));
		landList.add(new Land(10, "도시","로마", hotelList.getHotel(10)));
		landList.add(new Land(11, "도시","파리", hotelList.getHotel(11)));
		landList.add(new Land(12, "황금열쇠","황금열쇠3", null));
		landList.add(new Land(13, "도시","시드니", hotelList.getHotel(13)));
		landList.add(new Land(14, "세계여행","세계여행", null));
		landList.add(new Land(15, "도시","뉴욕", hotelList.getHotel(15)));
		landList.add(new Land(16, "도시","도쿄", hotelList.getHotel(16)));
		landList.add(new Land(17, "도시","서울", hotelList.getHotel(17)));
	}

	@Override
	public String toString() {
	    String result = "--LandList--\n";
	    for (Land land : landList) {
	        result += land.toString()+"\n";
	    }
	    return result;
	}

	public List<Land> getLandList() {
		return landList;
	}

	public void setLandList(List<Land> landList) {
		this.landList = landList;
	}

	public HotelList getHotelList() {
		return hotelList;
	}

	public void setHotelList(HotelList hotelList) {
		this.hotelList = hotelList;
	}
	
	
	
}
