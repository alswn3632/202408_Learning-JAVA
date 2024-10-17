package monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
	//멤버변수
	int turn = 1;
	boolean isStop = false;
	boolean isMoney;
	Player winner;
	int num;
	List<Player> playerList = new ArrayList<>(); 
	LandList l = new LandList(new HotelList());
	List<Land> landList = l.getLandList();
	Scanner scan = new Scanner(System.in);
	List<Player> isIsland = new ArrayList<>();
	
	//메서드
	// (메인)게임 스타터 : 플레이어 이름을 받음(객체 생성하여 리스트에 저장), 진행 순서를 정함
	public boolean gameStarter() {
		// 플레이어 수 받기
		System.out.print("플레이어 수: ");
		num = scan.nextInt();
		
		// 플레이어 이름 받기
		for(int i=0; i<num; i++) {
			System.out.print("플레이어" + (i+1) + "의 이름을 정해주세요: ");
			String name = scan.next();
			Player p = new Player(name, (i+1));
			playerList.add(p);
		}
		
		// 게임 진행 순서 결정
		System.out.println("\n게임 순서를 정하겠습니다.");
		Map<Player, Integer> seq = new HashMap<>();
		for(int i=0; i<num; i++) {
			System.out.print(playerList.get(i).getName() + "님주사위 굴리는중... ");
			int dice1 = roll();
			int dice2 = roll();			
			seq.put(playerList.get(i), dice1+dice2);
			System.out.println(dice1 + "+" + dice2 + ">> " + (dice1+dice2) + "!!");
		}
		
		playerList.clear();
		
		playerList = seq.entrySet()
				.stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) 
				.map(Map.Entry::getKey) 
				.collect(Collectors.toList()); 
		
		// 준비 완료 + 출력
		System.out.println("\n게임 준비가 완료되었습니다.");
		System.out.println("[플레이어 리스트]");
		for (Player p : playerList) {
			System.out.println(p.toString());
		}	
		System.out.println("--------------------------------------------------------------------------");
		return true;
	}
	
	// (메인)게임 진행
	public void gamePlay() {
		while(turn != 50) {
			System.out.println("\n[현재 턴수: " + turn + "]");
			
			for(int i=0; i<playerList.size(); i++) {
				System.out.println(playerList.get(i).toString());
			}
			System.out.println("--------------------------------------------------------------------------");

			// 각각의 플레이어가 주사위를 굴림
			for(int i=0; i<num; i++) {
				if(isStop) {
					System.out.println("게임이 끝났습니다.");
					System.out.println("우승자는 " + playerList.get(0).getName() + "님 입니다!!!");
				}
				System.out.println(playerList.get(i).getName() + "님 차례입니다! (아무거나입력)");
				System.out.print("선택: ");
				
				// 플레이어의 위치가 무인도인지 검사
				if(isIsland.contains(playerList.get(i))) {
					System.out.println("\n\n무인도에서 나갈 수 없네용ㅋ\n");
					isIsland.remove(playerList.get(i));
					continue;
				}
				
				// 주사위 굴려서 칸 이동 + 한바퀴 돌았을 때 처리
				scan.next();
				System.out.println("주사위를 굴립니다...");
				int dice = roll();
				System.out.println(dice + "칸 이동합니다.");
				System.out.println();
				int position = playerList.get(i).getPlayerPo() + dice;
				playerList.get(i).setPlayerPo(position);
				if(position > 17) {
					eventStartPass(playerList.get(i));
				}
				
				// 이동한 위치의 땅의 타입을 가져와서 이벤트 발생
				gameEvent(playerList.get(i));
				System.out.println("--------------------------------------------------------------------------");
			}
			turn++;
		}
		
		// 모든 턴이 끝났을 때 남아있는 플레이어의 자산 집계 후 1등 산출
		Map<Player, Integer> win = new HashMap<>();
		for(int i=0; i<playerList.size(); i++) {
			int money = checkMoney(playerList.get(i));
			win.put(playerList.get(i), money);
		}
		
		playerList.clear();
		
		playerList = win.entrySet()
				.stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) 
				.map(Map.Entry::getKey) 
				.collect(Collectors.toList()); 
		
		System.out.println("게임이 끝났습니다!!!");
		System.out.println("[게임 결과]");
		for(int i=0; i<playerList.size(); i++) {
			System.out.println(playerList.get(i).toString());
		}
		System.out.println("우승자는 " + playerList.get(0).getName() + "님 입니다!!!");
		
	}
	
	// (메인) 이벤트 발생 실행 메서드
	private void gameEvent(Player p) {
		int position = p.getPlayerPo();
		Land a = landList.get(position);
		String type= a.getLandType();
		switch(type) {
		case "출발지" : 
			eventStart(p);
			break;
		case "도시" :
			eventCity(p, position);
			break;
		case "무인도" :
			eventIsland(p);
			break;
		case "황금열쇠" :
			eventGoldenKey();
			break;
		case "세계여행" :
			eventTravel(p);
			break;
		case "사회복지기금" :
			eventFund(p);
			break;
		default : 
			System.out.println("error!!");
		}
		
	}
	//----------------------------------------------------------------------------------------------------------
	// (기본)주사위 굴리기
	public int roll() {
		return (int)(Math.random()*6)+1;
	}
	
	// (기본)자산 검사 
	public int checkMoney(Player p) {
		int money = p.getMoney();
		for(int j=0; j<p.getHotelList().size(); j++) {
			money += p.getHotelList().get(j).getSale();
		}
		
		return money;
	}
	
	// (기본)돈 걷기 - 검사, 매각, 파산처리 전부 포함함
	public int charge(Player p, int pay) {
		// 너 돈 낼수 있니? > 있다면 뺏기 > 없다면 매각 or 파산처리
		if(canCharge(p, pay)) {
			// 돈 낼 수 있다? -> 유저에게 돈 빼기
			p.setMoney(p.getMoney()-pay);	
			return pay;
		}else {
			// 돈 낼 수 없다? -> 유저 파산처리
			return setBankruptcy(p);
		}
	}
	
	// (기본)너 돈 낼수 있니?
	public boolean canCharge(Player p, int pay) {
		// true = 돈 낼 수 있음 false = 돈 낼 수 없음
		if(p.getMoney() > pay) {
			return true;
		} else {
			// 유저가 가지고있는 호텔을 팔아서 나올 수 있는 돈의 총합 계산
			int hotelMoney = 0;
			for(int i=0; i<p.getHotelList().size(); i++) {
				hotelMoney += p.getHotelList().get(i).getSale();
			}
			
			// 총합을 가지고 돈 낼 수 있는지 검사
			if(p.getMoney() + hotelMoney <= pay) {
				System.out.println("너 돈 없어 파산해..");
				return false;
			}else {
				System.out.println("건물을 팔아서 지불할 수 있습니다. 진행하시겠습니까? 1. 매각 2. 파산");
				System.out.print("선택: ");
				int menu = scan.nextInt();
				switch(menu) {
				case 1 : 
					sellHotel(p, pay);
					return true;
				case 2 :
					return false;
				default : 
					System.out.println("안돼 에러난다...");
					return false;
				}
			}

			
		}
		
	}
	
	// (기본)호텔 매각처리
	public void sellHotel(Player p, int pay) {
		// 플레이어 보유 자산이랑 호텔 팔아서 매꾼 돈이 pay를 넘길 때 까지 매각 진행
		// 가장 싼 선물부터 매각하기 시작
		System.out.println("가장 싼 호텔부터 매각하기 시작합니다.");
		int money = p.getMoney();
		while(money > pay) {
			// 맨 앞의 값을 계속해서 뺌
			System.out.println(landList.get(p.getHotelList().get(0).getHotelPo()).getLandName()+ "의 호텔을 판배합니다. ");
			// 매각한 돈 누적하기
			money += p.getHotelList().get(0).getSale();
			// 랜드리스트에서 호텔 소유 정보 제거
			landList.get(p.getHotelList().get(0).getHotelPo()).toggleHotel();
			landList.get(p.getHotelList().get(0).getHotelPo()).getHotel().setOwner("");
			// 플레이어리스트에서 호텔 소유 정보 제거
			p.getHotelList().remove(0);
		}
		System.out.println("매각을 완료했습니다.");
		p.setMoney(money);
	}
	
	// (기본)유저 파산처리
	public int setBankruptcy(Player p) {
		int money = p.getMoney();
		while(p.getHotelList().size() != 0) {
			System.out.println(landList.get(p.getHotelList().get(0).getHotelPo()).getLandName()+ "의 호텔을 판배합니다. ");
			// 매각한 돈 누적하기
			money += p.getHotelList().get(0).getSale();
			// 랜드리스트에서 호텔 소유 정보 제거
			landList.get(p.getHotelList().get(0).getHotelPo()).toggleHotel();
			landList.get(p.getHotelList().get(0).getHotelPo()).getHotel().setOwner("");
			// 플레이어리스트에서 호텔 소유 정보 제거
			p.getHotelList().remove(0);
		}
		
		// 호텔 정보 전부 제거하고 유저 삭제
		playerList.remove(p);
		
		gameResult();
		
		return money;
	}
	
	// (기본)승패 결정하기
	public void gameResult() {
		if(playerList.size() == 1) {
			isStop = true;
		}
	}
	
	//----------------------------------------------------------------------------------------------------------
	// (위치이동이벤트)출발지 이벤트
	private void eventStart(Player p) {
		// 출력문구
		System.out.println("출발지에 도착했습니다!");
		// 이벤트 내용 - 20만원 증정
		int money = p.getMoney();
		p.setMoney(money + 25);
	}
	
	// (위치이동이벤트)출발지 경유!! 이벤트 - 출발지를 지나갈 때 돈 받는거
	private void eventStartPass(Player p) {
		// 출력문구
		System.out.println("한바퀴 돌았어요!");
		// 이벤트 내용 - 20만원 증정
		int position = p.getPlayerPo();
		p.setPlayerPo(position - 17);
		int money = p.getMoney();
		p.setMoney(money + 25);
	}

	// (위치이동이벤트)도시 이벤트 *****
	private void eventCity(Player p, int position) {
		// 출력문구
		System.out.println(landList.get(position).getLandName() + "에 도착했습니다!");
		// 이벤트 내용 - 1. 소유X 2. 소유O 
		// 1-1. 땅을 살 것인지 
		// 2-1. 내땅인지 아닌지 -> 내 땅이 아니라면 땅 주인에게 통행료 지불
		// 2-2. 인수하겠습니까?
		
		boolean isTrap = (landList.get(position).getToggle()).equals("on")? true : false;
		int trapPrice = landList.get(position).getHotel().getPrice();
		String trapOwner = landList.get(position).getHotel().getOwner();
		int trapOwnerId = 0;
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).getName().equals(trapOwner)) {
				trapOwnerId = playerList.get(i).getPlayerId();
			}
		}
		int trapToll = landList.get(position).getHotel().getToll();
		
		if(isTrap && !(trapOwner.equals(p.getName()))) {
			// 소유주가 있는 땅 + 그 소유주가 내가 아님
			System.out.println("이런, 주인이 있는 땅이네요!");
			int a = charge(p, trapToll);
			playerList.get(trapOwnerId-1).setMoney(playerList.get(trapOwnerId-1).getMoney()+a);
			System.out.println(trapOwner + "님에게 " + a + "만원 지불합니다.");
		}else if(isTrap && (trapOwner.equals(p.getName()))) {
			// 소유주가 있는 땅 + 그런데 내 땅
			// 아무일도 일어나지 않음
		}else if(!isTrap) {
			// 소유주가 없는 땅
			if(p.getMoney() > trapPrice) {
				System.out.println(landList.get(position).getHotel().toString());
				System.out.println("땅을 구매하시겠습니까? 1.구매 2.패스");
				System.out.print("선택: ");
				// 유저의 돈을 확인하고 넘어가는 것이기 때문에 charge에서 땅을 매각할 일이 없음
				int menu = scan.nextInt();
				switch(menu) {
				case 1 :
					// 유저에게 돈을 받고
					charge(p, trapPrice);
					// 호텔을 팔고
					landList.get(position).toggleHotel();
					landList.get(position).getHotel().setOwner(p.getName());
					// 출력
					System.out.println(trapPrice + "만원을 지불하고 호텔을 지었습니다!");
					break;
				case 2 :
					// 아무일도 일어나지 않음
					break;
				default : 
					System.out.println("에러난다고...");
				}
			}else {
				System.out.println("자산이 부족해 땅을 살 수 없네요!");
			}
			
		}
	}

	// (위치이동이벤트)무인도 이벤트
	private void eventIsland(Player p) {
		// 출력문구
		System.out.println("이런, 무인도에 도착했습니다!");
		System.out.println("한 턴동안 움직일 수 없습니다!");
		// 이벤트 내용 
		isIsland.add(p);
	}

	// (위치이동이벤트)황금열쇠 이벤트 *****
	private void eventGoldenKey() {
		// 출력문구
		System.out.println("황금열쇠를 뽑을 수 있어요!");
		// 이벤트 내용 - 황금열쇠 뽑기
		
	}

	// (위치이동이벤트)세계여행 이벤트 *****
	private void eventTravel(Player p) {
		// 출력문구
		System.out.println("세계여행을 시작합니다!");
		// 이벤트 내용
		// (1) 여행지 입력받기
		int position = p.getPlayerPo(); // 객체의 위치
		int moving = 0; // 이동거리
		
		System.out.println("어디로 가시겠습니까? (땅 이름 입력)");
		System.out.println("선택: ");
		String destination = scan.next();
		int dtNum = 0; // 도착 위치
		for(int i=0; i<landList.size(); i++) {
			if(landList.get(i).getLandName().equals(destination)) {
				dtNum = landList.get(i).getLandPo();
			}
		}
		
		// (2) 이동 거리 계산
		if(dtNum < position) {
			moving = 17 - position + dtNum;
		}else if(dtNum > position) {
			moving = dtNum - position;
		}
		
		// (3) 여행지 이동 - 출발지 경유 검사
		p.setPlayerPo(position + moving);
		if(p.getPlayerPo() > 17) {
			eventStartPass(p);
		}
		System.out.println();
		// (4) 이동한 여행지의 이벤트 발생
		gameEvent(p);
		
	}

	// (위치이동이벤트)사회복지기금 이벤트
	private void eventFund(Player p) {
		// 출력문구
		System.out.println("사회복지기금을 받을 수 있어요!");
		// 이벤트 내용
		int expense = 10; // 뜯을 돈
		int totalExpenses = 0;
		// (1) 땅을 밟은 사람 제외하고 돈 가져오기 - 파산 검사
		for(int i=0; i<playerList.size(); i++) {
			if(!playerList.get(i).getName().equals(p.getName())) {
				int a = charge(playerList.get(i), expense);
				// 돈을 낼 수 있었다 > 파산 x > expense만큼 지불함
				// 돈을 낼 수 없었다 > 파산 o > 그 사람의 전재산을 가져옴
				totalExpenses += a;
			}
		}
		System.out.println(p.getName() + "님에게 " + totalExpenses + "원 증정!!!");
		p.setMoney(p.getMoney()+totalExpenses);
	}

}
