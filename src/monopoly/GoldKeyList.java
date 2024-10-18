package monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoldKeyList {
	
	private List<GoldKey> list = new ArrayList<>();
	Random random = new Random();
	
	public GoldKeyList() {
		addGoldKey();
	}
	
	public void addGoldKey() {
		list.add(new GoldKey(1, "병원비 지불 : 건강진단을 받았습니다.	",
				"  (병원비 5만원을 은행에 납부합니다.)        "));
		list.add(new GoldKey(2, "복권 당첨 : 복권에 당첨되었습니다.	",
				"  (당첨금 20만원을 은행에서 받습니다.)       "));
		list.add(new GoldKey(3, "우주 여행 초청장 : 우주정류장으로 가세요.	",
				"  (출발지를 지나갈 경우 월급을 받습니다.)	"));
		list.add(new GoldKey(4, "해외 유학 : 학교 등록금을 내세요.		",
				"  (등록금 10만원을 은행에 납부합니다.)	"));
		list.add(new GoldKey(5, "이사 : 앞으로 네 칸 옮기세요.		","  (전진)			"));
		list.add(new GoldKey(6, "고속도로 : 출발지까지 곧바로 가세요.	",
				"  (출발지에서 월급을 받습니다.)	        "));
		list.add(new GoldKey(7, "생일 축하 : 모두에게 생일 축하를 받으세요.",
				"  (전원에게 축하금 5만원씩 받습니다.)        "));
		list.add(new GoldKey(8, "장학금 혜택 : 장학금을 받으세요.		",
				"  (장학금 10만원을 은행에서 받습니다.)	"));
		list.add(new GoldKey(9, "정기 종합소득세 : 건물수대로 지불하세요.	",
				"  (건물수만큼 5만원 지불)	                "));
		list.add(new GoldKey(10, "휴가비 혜택 : 휴가비를 받으세요.		",
				"  (휴가비 15만원을 은행에서 받습니다.)	"));
	}
	
	public GoldKey GoldKeyRandom() {    //램덤출력
    	int randomgk = random.nextInt(list.size());
    	return list.get(randomgk);
    }

	public void GoldKeyListPrint() {
		for(GoldKey temp : list) {
			System.out.println(temp);
		}
	}
	
	

}


// 황금카드 리스트
/* 1. 병원비 지불 : 병원에서 건강진단을 받았습니다. 
 * (병원비 5만원을 은행에 납부합니다.)
 * 2. 복권 당첨 : 축하합니다. 복권에 당첨되었습니다.
 * (당첨금 20만원을 은행에서 받습니다.)
 * 3. 우주 여행 초청장 : 우주정류장으로 가세요 
 * (우주 여행비는 무료이며 출발지를 지나갈 경우 월급을 받습니다.)
 * 4. 해외 유학 : 학교 등록금을 내세요.
 * (등록금 10만원을 은행에 납부합니다.)
 * 5. 이사 : 앞으로 네 칸 옮기세요
 * 6. 고속도로 : 출발지까지 곧바로 가세요.
 * (출발지에서 월급을 받습니다.)
 * 7. 생일 축하 : 모두에게 생일 축하를 받으세요
 * (전원에게 축하금 5만원씩 받습니다.)
 * 8. 장학금 혜택 : 장학금을 받으세요.
 * (장학금 10만원을 은행에서 받습니다.)
 * 9. 정기 종합소득세 : 종합소득세를 건물수대로 지불하세요.
 * (건물수만큼 5만원 지불)
 * 10. 휴가비 혜택 : 휴가비를 받으세요.
 * (휴가비 15만원을 은행에서 받습니다.)
 * */
