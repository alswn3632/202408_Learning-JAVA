package monopoly;

import java.util.HashMap;
import java.util.Map;

public class HotelList {

	Map<Integer, Hotel> m = new HashMap<>();
	
	public HotelList() {
		addHotel();
	}
	
	public void addHotel() {
		m.put(1, new Hotel(1,20,5));
		m.put(3, new Hotel(3,24,7));
		m.put(4, new Hotel(4,29,8));
		m.put(6, new Hotel(6,33,9));
		m.put(8, new Hotel(8,37,11));
		m.put(10, new Hotel(10,43,13));
		m.put(11, new Hotel(11,48,14));
		m.put(13, new Hotel(13,54,16));
		m.put(15, new Hotel(15,61,18));
		m.put(16, new Hotel(16,67,19));
		m.put(17, new Hotel(17,73,20));
	}
	


	public void hotelListPrint() {
		for(Map.Entry<Integer, Hotel> entry : m.entrySet()) {
			System.out.println("호텔 위치 : " + entry.getKey() + entry.getValue());
			System.out.println();
		}
	}
	
	public Hotel getHotel(int hotelPo) {
		return m.get(hotelPo);
	}

	
	
	
}
