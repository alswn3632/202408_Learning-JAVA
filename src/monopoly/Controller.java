package monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
	//멤버변수
	Scanner scan = new Scanner(System.in);
	// 게임종료에 관여하는 변수
	int turn = 1;
	boolean isStop = false;
	
	// 게임진행에 필요한 준비물
	List<Player> playerList = new ArrayList<>(); 
	LandList l = new LandList(new HotelList());  // ** 추가! 보드 객체 선언
	List<Land> landList = l.getLandList();
	List<Player> isIsland = new ArrayList<>();
	GoldKeyList g = new GoldKeyList();
	int DesPoint = 0; // 📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌
	
	Board board; // ** 추가! 보드 객체 선언
	
	//생성자
	public Controller() {
		board = new Board(l, playerList, turn); // 보드를 한 번만 생성
	}
	//메서드
	// (메인)게임 스타터 : 플레이어 이름을 받음(객체 생성하여 리스트에 저장), 진행 순서를 정함
	public boolean gameStarter() {
		// 플레이어 수 받기
		System.out.println("[시스템] 플레이어 수를 입력해주세요!");
		System.out.print("선택: ");
		int num = setInput();
		
		// 플레이어 이름 받기
		List<String> isDupl = new ArrayList<>();
		for(int i=0; i<num; i++) {
			System.out.println("[시스템] 플레이어" + (i+1) + "의 이름을 정해주세요!");
			System.out.print("선택: ");
			String name = scan.next();
			if(isDupl.contains(name)) {
				System.out.println("[에러] 중복된 이름은 사용이 불가능해요.");
				i--;
			}else {
				isDupl.add(name);
				Player p = new Player(name, (i+1));
				playerList.add(p);				
			}
		}
		
		// 게임 진행 순서 결정
		System.out.println();
		System.out.println("[시스템] 게임 순서를 정하겠습니다!");
		Map<Player, Integer> seq = new HashMap<>();
		for(int i=0; i<num; i++) {
			System.out.println(playerList.get(i).getName() + "님이 주사위를 굴리는 중이에요!");
			int dice1 = roll();
			int dice2 = roll();			
			printRoll(dice1);
			printRoll(dice2);
			seq.put(playerList.get(i), dice1+dice2);
		}
		
		playerList.clear();
		
		playerList = seq.entrySet()
				.stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) 
				.map(Map.Entry::getKey) 
				.collect(Collectors.toList()); 
		
		// 준비 완료 + 출력
		System.out.println();
		System.out.println("[시스템] 게임 준비가 완료되었습니다!");
		// ** 추가! 보드 생성
		board.setBoard(l, playerList, turn);
		board.createBoard();
		return true;
	}
	
	// (메인)게임 진행
	public void gamePlay() {
		while(turn != 30) {
			// 현재 턴수
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("[시스템] Round " + turn + "!!");
			
			for(int i=0; i<playerList.size(); i++) {
				System.out.println("[시스템] " + playerList.get(i).getName() + "님 보유자산: " 
						+ playerList.get(i).getMoney() + "/" + checkMoney(playerList.get(i)) + "만원");
			}
			System.out.println("---------------------------------------------------------------------------------------------");

			// 각각의 플레이어가 주사위를 굴림
			int size = playerList.size();
			for(int i=0; i<size; i++) {
				
				// 파산한 사람이 있다면 있을 때 구조 수정
				if(playerList.size() != size && i != size) {
					size = playerList.size();
					i--;
				}
				
				if(playerList.size() != size && i == size) {
					continue;
				}
				
				// 한 턴 지날 때 마다 isStop으로 승패결정 유무 확인
				if(isStop) {
					System.out.println("[시스템] 게임이 끝났습니다!");
					System.out.println("[시스템] 우승자는 " + playerList.get(0).getName() + "님 입니다!");
					turn = 100;
					break;
				}
				
				// 주사위 굴리는 중
				System.out.println();
				System.out.println("[시스템] " + playerList.get(i).getName() + "님 차례입니다!");
				System.out.print("선택: ");
				
				// 플레이어 위치가 세계여행인지 검사 // 📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌
				if(playerList.get(i).getPlayerPo() == 14) {
					System.out.println("\n[시스템] " + playerList.get(i).getName() + "님이 세계여행을 시작했어요!");
					int moving = 0;
					int position = playerList.get(i).getPlayerPo();
					// (2) 이동 거리 계산
					if(DesPoint < position) {
						moving = 18 - position + DesPoint;
					}else if(DesPoint > position) {
						moving = DesPoint - position;
					}
					
					// (3) 여행지 이동 - 출발지 경유 검사
					playerList.get(i).setPlayerPo(position + moving);
					if(playerList.get(i).getPlayerPo() > 17) {
						eventStartPass(playerList.get(i));
					}
					System.out.println();
					// (4) 이동한 여행지의 이벤트 발생
					gameEvent(playerList.get(i));
					board.setBoard(l, playerList, turn);
					board.createBoard();
					continue;
				} // 📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌
				
				// 플레이어의 위치가 무인도인지 검사
				if(isIsland.contains(playerList.get(i))) {
					System.out.println("\n[시스템] 무인도에서 나갈 방법을 찾고있습니다! 다음 턴에 탈출 가능!");
					isIsland.remove(playerList.get(i));
					continue;
				}
				
				// 주사위 굴려서 칸 이동 + 한바퀴 돌았을 때 처리
				scan.next();
				System.out.println("[시스템] 주사위를 굴립니다...");
				int dice = roll();
				System.out.println("[시스템] " + dice + "칸 이동합니다.");
				printRoll(dice);
				System.out.println();
				int position = playerList.get(i).getPlayerPo() + dice;
				playerList.get(i).setPlayerPo(position);
				if(position > 17) {
					eventStartPass(playerList.get(i));
				}
				// ** 추가! 보드 생성
				board.setBoard(l, playerList, turn);
				board.createBoard();
				
				// 이동한 위치의 땅의 타입을 가져와서 이벤트 발생
				gameEvent(playerList.get(i));
				System.out.println("---------------------------------------------------------------------------------------------");
			}
			turn++;
		}
		
		// 모든 턴이 끝났을 때 남아있는 플레이어의 자산 집계 후 1등 산출
		Map<Player, Integer> win = new HashMap<>();
		for(int i=0; i<playerList.size(); i++) {
			int totalMoney = checkMoney(playerList.get(i));
			win.put(playerList.get(i), totalMoney);
		}
		playerList.clear();
		
		playerList = win.entrySet()
				.stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) 
				.map(Map.Entry::getKey) 
				.collect(Collectors.toList()); 
		
		System.out.println("[시스템] 게임이 끝났습니다!");
		System.out.println("[시스템] 전체 랭킹");
		for(int i=0; i<playerList.size(); i++) {
			System.out.println((i+1) + "등 " + playerList.get(i).getName() + "님 보유자산: " + checkMoney(playerList.get(i)) + "만원");
		}
		
		System.out.println("[시스템] 우승자는 " + playerList.get(0).getName() + "님 입니다!");
		
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
			eventCity(p);
			break;
		case "무인도" :
			eventIsland(p);
			break;
		case "황금열쇠" :
			eventGoldenKey(p);
			break;
		case "세계여행" :
			eventTravel(p);
			break;
		case "사회복지기금" :
			eventFund(p);
			break;
		default : 
			System.out.println("[에러] 잘못된 접근입니다.");
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
			int num = setBankruptcy(p);
			return num;
		}
	}
	
	// (기본)너 돈 낼수 있니?
	public boolean canCharge(Player p, int pay) {
		// true = 돈 낼 수 있음 false = 돈 낼 수 없음
		if(p.getMoney() > pay) {
			return true;
		} else {
			// 총합을 가지고 돈 낼 수 있는지 검사
			if(checkMoney(p) <= pay) {
				return false;
			}else {
				System.err.println("[시스템] 건물을 팔아서 지불할 수 있습니다. 진행하시겠습니까? 1. 매각 2. 파산");
				System.out.print("선택: ");
				int menu = setInput();
				switch(menu) {
				case 1 : 
					sellHotel(p, pay);
					return true;
				case 2 :
					return false;
				default : 
					System.out.println("[에러] 잘못된 입력입니다. 파산하겠습니다.");
					return false;
				}
			}

			
		}
		
	}
	
	// (기본)호텔 매각처리
	public void sellHotel(Player p, int pay) {
		// 플레이어 보유 자산이랑 호텔 팔아서 매꾼 돈이 pay를 넘길 때 까지 매각 진행
		// 가장 싼 선물부터 매각하기 시작
		System.out.println("[시스템] " + p.getName() + "님의 호텔 매각을 시작합니다.");
		int money = p.getMoney();
		while(money <= pay) {
			// 맨 앞의 값을 계속해서 뺌
			System.err.println("[시스템]" + landList.get(p.getHotelList().get(0).getHotelPo()).getLandName()+ "의 호텔 매각완료!");
			// 매각할 호텔의 돈 누적하기
			money += p.getHotelList().get(0).getSale();
//			System.out.println(p.getHotelList().get(0).getSale());
			// 랜드리스트에서 호텔 소유 정보 제거
			landList.get(p.getHotelList().get(0).getHotelPo()).toggleHotel();
			landList.get(p.getHotelList().get(0).getHotelPo()).getHotel().setOwner("");
			// 플레이어리스트에서 호텔 소유 정보 제거
			p.getHotelList().remove(0);
		}
//		System.out.println("땅 팔아서 이만큼 벌었어요!" + money);
		// ** 추가! 보드 생성
		board.setBoard(l, playerList, turn);
		board.createBoard();
		System.out.println("[시스템] 호텔 매각을 완료했습니다.");
		p.setMoney(money);
	}
	
	// (기본)유저 파산처리
	public int setBankruptcy(Player p) {
		System.out.println("[시스템]" + p.getName() + "님이 파산하였습니다!");
		System.out.println(p.getName() + "님이 파산하였습니다.....!!!!\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣸⣷⣀⣀⣀⣀⣀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡿⡿⡻⣻⢻⡻⣻⢻⡻⣻⢻⡻⡿⣷⣴⣾⢿⡻⡿⣿⣶⣄⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⢤⣦⡳⡝⣎⢯⡪⣇⢯⡪⣇⢯⡪⡧⡳⡹⣽⣿⡳⡕⡧⡳⣕⢯⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢀⣿⣗⢵⢝⣜⢮⢺⢜⢮⢺⢜⢮⢺⢜⡝⡮⢮⢺⢜⢮⢳⡹⣜⢽⡹⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢀⣤⣿⣗⢵⢳⡱⡳⣹⢪⡳⣹⢪⡳⣹⢪⡺⣪⡳⡝⣎⢗⢵⢝⣜⢮⢯⣿⣷⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠈⢙⣿⡗⣝⢮⡪⣏⢮⡣⣏⢮⡣⣏⢮⣳⣹⢜⣜⢞⢼⡱⣝⢮⣚⢮⣳⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠠⣿⡯⡺⡜⣾⣮⣾⣮⣾⣮⣾⣾⣷⣿⣿⣿⣮⣷⣷⣽⣼⣮⡎⣗⡵⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠐⣿⡯⣪⡫⣿⡏⢉⣩⣩⣩⣵⡿⢟⣽⡿⠀⡈⠉⡉⡉⢹⣿⡕⣗⡽⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢈⣿⡯⡪⡮⣿⡏⠘⢋⠛⠙⢉⠀⠟⠏⡁⠂⡀⢂⠐⠠⢹⣿⢝⡼⣺⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⣠⣿⡯⡺⡪⣿⣏⠐⠀⠂⣿⡇⠐⡀⠂⡐⢘⣾⡂⠨⠐⢸⣿⣣⡻⣪⣿⡟⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⣽⣾⣿⡇⠄⢁⠁⡈⡀⠁⠄⠂⠠⠐⠈⡀⠌⠨⢸⣿⣾⣾⡿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠁⢻⣯⠐⠀⢂⠠⢀⢡⣠⣁⣂⠈⠄⠠⠈⠔⢸⡿⠈⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣆⠡⠀⠄⠂⠟⠛⡙⠻⠃⠠⠁⠌⣌⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣘⣿⣷⣄⠨⠀⠌⠠⠐⠀⠌⠠⣡⣺⣾⣏⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⡻⠩⡙⡻⣿⣶⣬⣴⣬⣴⣵⡿⡟⠏⡝⡝⣿⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⠿⣷⣬⢊⠢⡑⠔⢌⠍⠭⡩⡩⡑⡌⢜⠨⠢⡑⢕⢝⣿⣆⠀⠀⢀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠃⠀⠉⢻⣷⡕⢌⠪⠢⡑⠕⢌⠢⡺⡿⡡⡑⠕⢌⢊⢲⠸⣿⣷⡿⠟⡟⠿⣶⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠂⠁⢐⣿⣧⣥⡑⠕⢌⠪⠢⡑⢅⢒⣌⢌⠪⡨⠢⡱⣱⣿⠃⢠⣾⣿⠆⠈⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠐⣿⡅⠀⠂⠠⣽⣿⣽⡩⢌⢊⠆⡣⢱⣸⣺⣿⣟⢅⠕⢌⠪⡰⢽⣟⠀⡈⣝⢿⣶⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢈⣿⣾⣾⣶⢿⢟⠕⢍⠪⡐⢅⢊⠢⡱⣿⠿⡏⢕⠔⢅⠕⡡⢊⡚⣿⣧⣈⠻⠿⢃⣰⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠠⣿⡇⠢⡊⡌⡢⣡⡅⢕⢬⣢⢑⡑⢌⠪⡨⢌⠢⣑⣅⢪⠨⡂⡇⡇⣿⡿⠿⠿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠐⣿⡇⠕⢌⠢⡊⣿⣏⠢⠫⡛⢅⢊⢢⠱⠨⠢⡑⢜⣿⡑⣌⣆⣇⣧⣿⣇⣀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢈⣿⡎⡊⡢⡑⢌⣿⡧⡑⠕⢌⠢⡑⠔⡅⣽⣮⠌⣺⣿⢕⣿⡛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⢿⣏⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠠⣿⡇⠪⡰⢘⢐⣿⣗⢘⠌⢆⠣⡑⡑⡌⢍⠢⡑⢜⣿⡪⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⡇⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠐⣿⣷⣷⣾⣾⣶⣿⣷⣷⣷⠅⠱⣾⣶⣾⣶⣷⣷⣿⣿⣶⣿⣿⣷⣶⣶⣶⣶⣶⣶⣶⣶⣾⠿⠛⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		
		int money = p.getMoney();
		while(p.getHotelList().size() != 0) {
			System.err.println("[시스템]" + landList.get(p.getHotelList().get(0).getHotelPo()).getLandName()+ "의 호텔 자동매각!");
			// 매각한 돈 누적하기
			money += p.getHotelList().get(0).getSale();
			// 랜드리스트에서 호텔 소유 정보 제거
			landList.get(p.getHotelList().get(0).getHotelPo()).setToggle("off");
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
		System.out.println("[시스템] 출발지에 도착했습니다!");
		System.out.println("[시스템] 25만원을 드립니다!");
		System.out.println();
		// 이벤트 내용 - 20만원 증정
		int money = p.getMoney();
		p.setMoney(money + 25);
	}
	
	// (위치이동이벤트)출발지 경유!! 이벤트 - 출발지를 지나갈 때 돈 받는거
	private void eventStartPass(Player p) {
		if(p.getPlayerPo() == 18) {
			int position = p.getPlayerPo();
			p.setPlayerPo(position - 18);
			return;
		}
		// 출력문구
		System.out.println("[시스템] 축하합니다! 한바퀴 돌았어요!");
		System.out.println("[시스템] 25만원을 드립니다!");
		// 이벤트 내용 - 20만원 증정
		int position = p.getPlayerPo();
		p.setPlayerPo(position - 18);
		int money = p.getMoney();
		p.setMoney(money + 25);
	}

	// (위치이동이벤트)도시 이벤트 *****
	private void eventCity(Player p) {
		// 출력문구
		System.out.println("[시스템] " + landList.get(p.getPlayerPo()).getLandName() + "에 도착했습니다!");
		// 이벤트 내용 - 1. 소유X 2. 소유O 
		// 1-1. 땅을 살 것인지 
		// 2-1. 내땅인지 아닌지 -> 내 땅이 아니라면 땅 주인에게 통행료 지불
		// 2-2. 인수하겠습니까?
		
		boolean isTrap = (landList.get(p.getPlayerPo()).getToggle()).equals("on")? true : false;
		int trapPrice = landList.get(p.getPlayerPo()).getHotel().getPrice();
		String trapOwner = landList.get(p.getPlayerPo()).getHotel().getOwner();
		int trapOwnerId = -1;
		for(int i=0; i<playerList.size(); i++) {
			if((playerList.get(i).getName()).equals(trapOwner)) {
				trapOwnerId = playerList.get(i).getPlayerId();
			}
		}

		int trapToll = landList.get(p.getPlayerPo()).getHotel().getToll();
		int size = playerList.size();
		
		if(isTrap && !(trapOwner.equals(p.getName()))) {
			// 소유주가 있는 땅 + 그 소유주가 내가 아님
			System.out.println("[시스템] 이런! " + trapOwner + "님의 호텔에 요금을 내야해요!");
			int a = charge(p, trapToll);
			if(playerList.size() != size) {
				for(int i=0; i<playerList.size(); i++) {
					if((playerList.get(i).getName()).equals(trapOwner)) {
						trapOwnerId = playerList.get(i).getPlayerId();
					}
				}
			}

			for(int i=0; i<playerList.size(); i++) {
				if(playerList.get(i).getPlayerId() == trapOwnerId) {
					playerList.get(i).setMoney(playerList.get(i).getMoney()+a);
				}
			}
			
			System.out.println("[시스템] " + trapOwner + "님에게 " + a + "만원 지불합니다!");
		}else if(isTrap && (trapOwner.equals(p.getName()))) {
			// 소유주가 있는 땅 + 그런데 내 땅
			// 아무일도 일어나지 않음
		}else if(!isTrap) {
			// 소유주가 없는 땅
			if(p.getMoney() > trapPrice) {
				System.out.println(landList.get(p.getPlayerPo()).getHotel().toString());
				System.out.println();
				System.out.println("[시스템] 호텔을 구매하시겠습니까? 1.구매 2.패스");
				System.out.print("선택: ");
				// 유저의 돈을 확인하고 넘어가는 것이기 때문에 charge에서 땅을 매각할 일이 없음
				int menu = setInput();
				switch(menu) {
				case 1 :
					// 유저에게 돈을 받고
					charge(p, trapPrice);
					// 땅에 소유주 정보 입력
					landList.get(p.getPlayerPo()).toggleHotel();
					landList.get(p.getPlayerPo()).getHotel().setOwner(p.getName());
					// 플레이어에게 호텔 객체 넘겨주기 - 매각처리용
					for(int i=0; i<playerList.size(); i++) {
						if(playerList.get(i).getPlayerId() == p.getPlayerId()) {
							playerList.get(i).getHotelList().add(landList.get(p.getPlayerPo()).getHotel());
							playerList.get(i).sortList();
						}
					}
					// ** 추가! 보드 생성
					board.setBoard(l, playerList, turn);
					board.createBoard();
					// 출력
					System.out.println("[시스템] " + trapPrice + "만원을 지불하고 호텔을 지었습니다!");
					break;
				case 2 :
					// 아무일도 일어나지 않음
					break;
				default : 
					System.out.println("[에러] 잘못된 접근입니다.");
				}
			}else {
				System.out.println("[시스템] 아쉽네요! 자산이 부족해 땅을 살 수 없습니다.");
			}
			
		}
	}

	// (위치이동이벤트)무인도 이벤트
	private void eventIsland(Player p) {
		// 출력문구
		System.out.println("[시스템] 이런! 무인도에 도착했습니다!");
		System.out.println("[시스템] 한 턴동안 움직일 수 없습니다!");
		// 이벤트 내용 
		isIsland.add(p);
	}

	// (위치이동이벤트)황금열쇠 이벤트 *****
		private void eventGoldenKey(Player p) {
			// 출력문구
			System.out.println("[시스템] 축하합니다! 황금열쇠를 뽑을 수 있어요!");
			// 이벤트 내용 - 황금열쇠 뽑기
			GoldKey keyRandom = g.GoldKeyRandom();
			int keySelect = keyRandom.getGkId();
			
			int position = p.getPlayerPo();
			int money = p.getMoney();
			
	    	System.out.println(keyRandom);
			
			switch(keySelect) {
			case 1: charge(p, 5);
				System.out.println("[시스템] " + p.getName()+"의 병원비로 지갑에서 5만원이 털렸습니다.");
				break;
			case 2: p.setMoney(money + 20);
				System.out.println("[시스템] " + p.getName()+"님이 20만원 복권에 당첨됐습니다. 저도 되고싶습니다.");
				break;
			case 3: movePosition(p, 14);
				System.out.println("[시스템] " + p.getName()+"는 세계여행에 당첨되었습니다.");
				eventTravel(p);	
				break;
			case 4: charge(p, 10);
				System.out.println("[시스템] " + p.getName()+"이(가) 호그와트로 유학을 떠납니다. 입학비 10만원 납부하세요.");
				break;
			case 5: p.setPlayerPo(position + 4);
				System.out.println("[시스템] " + p.getName()+"는 4칸 앞으로 전진!!");
				break;
			case 6: movePosition(p, 0);
				System.out.println("[시스템] " + p.getName()+"는 고속도로를 타고 집으로 갑니다. 저도 데러가주세요...");
				break;
			case 7: eventBrith(p);
				break;
			case 8: p.setMoney(money + 10);
				System.out.println("[시스템] " + p.getName()+"님, 교장 덤블도어에게 포상 10만원을 받았습니다. ");
				break;
			case 9: charge(p, p.getHotelList().size()*5);
				System.out.println("[시스템] " + p.getName()+"건물주님, 세금 내셔야죠. "+p.getHotelList().size()+"채 : 5만원씩 걷겠습니다.");
				break;
			case 10: p.setMoney(money + 15);
				System.out.println("[시스템] " + p.getName()+"님, 휴가비 15만원 받아가세요.");
				break;
			default: System.out.println("황금열쇠가 아닙니다.");
			}
			
			
		}
		
		// 황금열쇠 위치이동 이벤트
		private void movePosition(Player p, int dtNum) {
			// 플레이어 위치 확인
			int position = p.getPlayerPo(); //객체의 위치
			int moving = 0;  //이동거리
			
			// 이동 거리 계산
			if(dtNum < position) {
				moving  = 18 - position + dtNum;
			} else if(dtNum > position) {
				moving = dtNum - position;
			}
			
			// 세계여행지로 이동 - 출발지 경유 검사
			p.setPlayerPo(position + moving);
			if(p.getPlayerPo() > 17) {
				eventStartPass(p);
			}
			System.out.println();
		}
		
		// 황금열쇠 생일축하 이벤트
		private void eventBrith(Player p) {
			// 출력
			System.out.println("[시스템] " + p.getName()+"님의 생일입니다.");
			System.out.println("[시스템] 당신은 다른플레이들에게 생일빵을 맞고 치료비로 5만원씩 받았습니다. ");
			// 이벤트 내용
			int expense = 5; // 뜯을 돈
			int totalExpenses = 0;
			// (1) 땅을 밟은 사람 제외하고 돈 가져오기 - 파산 검사
			for(int i=0; i<playerList.size(); i++) {
				if(playerList.get(i).getPlayerId() != p.getPlayerId()) {
					int a = charge(playerList.get(i), expense);
					// 돈을 낼 수 있었다 > 파산 x > expense만큼 지불함
					// 돈을 낼 수 없었다 > 파산 o > 그 사람의 전재산을 가져옴
					totalExpenses += a;
				}
			}
			System.out.println("[시스템] " + p.getName() + "님에게 " + totalExpenses + "만원 증정!!!");
			p.setMoney(p.getMoney()+totalExpenses);
		}

	// (위치이동이벤트)세계여행 이벤트
	private void eventTravel(Player p) {
		// 출력문구
		System.out.println("[시스템] " + "세계여행을 시작합니다!");
		// 이벤트 내용
		// (1) 여행지 입력받기
//		int position = p.getPlayerPo(); // 객체의 위치
//		int moving = 0; // 이동거리
		
		System.out.println("[시스템] 어디로 가시겠습니까? 도시 이름을 입력해주세요!");
		System.out.print("선택: ");
		String destination = scan.next();
//		int DesPoint = 0; // 도착 위치
		for(int i=0; i<landList.size(); i++) {
			if(landList.get(i).getLandName().equals(destination)) {
				DesPoint = landList.get(i).getLandPo();
			}
		}
		
		if(DesPoint == 14) { // 📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌
			System.out.println("[시스템] 세계여행 지정 불가능해요! 출발지로 보내드릴게요!");
			DesPoint = 0;
		}// 📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌
		System.out.println("[시스템] 입력받았습니다! 다음 턴에 이동하겠습니다!");
//		// (2) 이동 거리 계산
//		if(dtNum < position) {
//			moving = 17 - position + dtNum;
//		}else if(dtNum > position) {
//			moving = dtNum - position;
//		}
//		
//		// (3) 여행지 이동 - 출발지 경유 검사
//		p.setPlayerPo(position + moving);
//		if(p.getPlayerPo() > 17) {
//			eventStartPass(p);
//		}
//		System.out.println();
//		// (4) 이동한 여행지의 이벤트 발생
//		gameEvent(p);
		
	}

	// (위치이동이벤트)사회복지기금 이벤트
	private void eventFund(Player p) {
		// 출력문구
		System.out.println("[시스템] 사회복지기금을 받을 수 있어요!");
		// 이벤트 내용
		int expense = 10; // 뜯을 돈
		int totalExpenses = 0;
		// (1) 땅을 밟은 사람 제외하고 돈 가져오기 - 파산 검사
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).getPlayerId() != p.getPlayerId()) {
				int a = charge(playerList.get(i), expense);
				// 돈을 낼 수 있었다 > 파산 x > expense만큼 지불함
				// 돈을 낼 수 없었다 > 파산 o > 그 사람의 전재산을 가져옴
				totalExpenses += a;
			}
		}
		System.out.println("[시스템] " + p.getName() + "님에게 " + totalExpenses + "만원 증정!!!");
		p.setMoney(p.getMoney()+totalExpenses);
	}
	
	// (예외처리)nextInt()로 String이 들어갈 경우
	public int setInput() {
		while(true) {
			try {
				int num = scan.nextInt();
				return num;
			}catch(Exception e) {
				scan.nextLine();
				System.out.println("[시스템] " + "숫자만 입력 가능해요! 다시 입력해주세요!");
			}
		}
	}
	
	// (기본)주사위 출력
	public void printRoll(int num) {
		switch(num) {
		case 1 :
			System.out.println("┌───────────┐");
		    System.out.println("│　　　　   │");
		    System.out.println("│　　　　   │");
		    System.out.println("│　　 ●　   │");
		    System.out.println("│　　　  　 │");
		    System.out.println("│　　　  　 │");
		    System.out.println("└───────────┘");
			break;
		case 2 :
			System.out.println("┌───────────┐");
			System.out.println("│　　　　   │");
			System.out.println("│　　　　   │");
			System.out.println("│　 ●   ●   │");
			System.out.println("│　　　  　 │");
			System.out.println("│　　　  　 │");
			System.out.println("└───────────┘");
			break;
		case 3 :
		    System.out.println("┌───────────┐");
		    System.out.println("│　　　　   │");
		    System.out.println("│　　　　   │");
		    System.out.println("│　 ● ● ●   │");
		    System.out.println("│　　　  　 │");
		    System.out.println("│　　　  　 │");
		    System.out.println("└───────────┘");
			break;
		case 4 :
		    System.out.println("┌───────────┐");
		    System.out.println("│　　　　   │");
		    System.out.println("│　 ●   ●   │");
		    System.out.println("│　         │");
		    System.out.println("│　 ●   ●   │");
		    System.out.println("│　　　  　 │");
		    System.out.println("└───────────┘");
			break;
		case 5 :
		    System.out.println("┌───────────┐");
		    System.out.println("│　　　　   │");
		    System.out.println("│　 ●   ●   │");
		    System.out.println("│　   ●     │");
		    System.out.println("│　 ●   ●   │");
		    System.out.println("│　　　  　 │");
		    System.out.println("└───────────┘");
			break;
		case 6 :
		    System.out.println("┌───────────┐");
		    System.out.println("│　　　　   │");
		    System.out.println("│　 ●   ●   │");
		    System.out.println("│　 ●   ●   │");
		    System.out.println("│　 ●   ●   │");
		    System.out.println("│　　　  　 │");
		    System.out.println("└───────────┘");
			break;
		
		}
	}


}
