package monopoly;

import java.util.List;

public class Board {
	private LandList landList;
	private List<Player> players;
	private int con;

	// 생성자
	public Board(LandList landList, List<Player> players, int turn) {
		this.landList = landList;
		this.players = players;
		this.con = turn;
	}

	// 파라미터 똑같이 생성해서 가져와서 내꺼 업데이트
	public void setBoard(LandList newLandList, List<Player> newPlayers, int newTurn) {
		this.landList = newLandList;
		this.players = newPlayers;
		this.con = newTurn;
	}

	// 플레이어가 있는 위치에 이모티콘을 출력하는 메서드
	private String PlayerPiece(int landPosition) {
		StringBuilder pieces = new StringBuilder();
		// 플레이어 리스트에서 해당 위치에 있는 플레이어의 심볼을 추가
		for (Player player : players) {
			if (player.getPlayerPo() == landPosition) {
				pieces.append
				(player.getPlayerSymbol(player.getPlayerId())).append(" ");
			}
		}
		return pieces.toString().trim();
	}

	// 땅의 이름과 소유자 정보를 표시하는 메서드
	private String getLandDisplay(int landIndex) {
		Land land = landList.getLandList().get(landIndex);
		String landName = land.getLandName();
		// 호텔이 있고, 소유주가 있을 때만 집 모양과 소유자 심볼을 표시
		if (land.getHotel() != null && land.getHotel().getOwner() 
				!= null && !land.getHotel().getOwner().isEmpty()) {
			String ownerSymbol = "";
			// 소유주 심볼 찾기
			for (Player player : players) {
				if (player.getName().equals(land.getHotel().getOwner())) {
					ownerSymbol = player.getPlayerSymbol(player.getPlayerId());
					break;
				}
			}
			// 호텔과 소유주 심볼 출력
			return landName + "🏠" + ownerSymbol;
		} else {
			// 소유주가 없으면 땅 이름만 반환
			return landName;
		}
	}
	
	// 인수 비용이 있는 값은 나타내기, 없으면 공백
	private String getPrice(int landIndex) {
		Land land = landList.getLandList().get(landIndex);
		if (land.getHotel() != null) {
			return "(" + land.getHotel().getPrice() + "만원)";
		} else {
			return " ";
		}
	}

	// 보드 출력 메서드 (players가 null인지 체크)
	public void createBoard() {
		if (players == null || players.isEmpty()) {
			System.out.println("플레이어가 아직 설정되지 않았습니다.");
			return;
		}
		// 첫 번째 줄
		System.out.println();
		System.out.println(
				" ┌──────────────┬──────────────┬──────────────┬──────────────┬──────────────┬──────────────┐");
		System.out.printf(" │ %-1s │ %-10s │ %-10s │ %-8s │ %-9s │ %-8s │%n",
				getLandDisplay(9), // 사회복지금
				getLandDisplay(10), // 로마
				getLandDisplay(11), // 파리
				getLandDisplay(12), // 황금열쇠3
				getLandDisplay(13), // 시드니
				getLandDisplay(14)); // 세계여행
		
		System.out.printf(" │ %-12s │ %-12s │ %-12s │ %-12s │ %-12s │ %-12s │%n",
				PlayerPiece(9),
				PlayerPiece(10),
				PlayerPiece(11),
				PlayerPiece(12),
				PlayerPiece(13),
				PlayerPiece(14));
		
		// 가격 표시
		System.out.printf(" │ %-12s │ %-10s │ %-10s │ %-12s │ %-10s │ %-12s │%n",
				" ",
				getPrice(10),
				getPrice(11),
				" ",
				getPrice(13),
				" ");
		
		System.out.println(
				" ├──────────────┼──────────────┴──────────────┴──────────────┴──────────────┼──────────────┤");
		
		// 두 번째 줄 - 플레이어 수에 따라 출력(너무 길어서 메서드로 만듦..)
		if (players.size() == 2) {
			printTwoPlayers();
		} else if (players.size() == 3) {
			printThreePlayers();
		} else if (players.size() == 4) {
			printFourPlayers();
		}
		
		// 세 번째 줄
		System.out.printf(" │ %-8s │ %-57s │ %-10s │%n",
				getLandDisplay(7), // 황금열쇠2
				" ",
				getLandDisplay(16)); // 도쿄
		
		System.out.printf(" │ %-12s │ %-57s │ %-12s │%n",
				PlayerPiece(7),
				" ",
				PlayerPiece(16));
		
		System.out.printf(" │ %-12s │ %-57s │ %-10s │%n",
				" ", " ", getPrice(16));
		
		System.out.printf(" %-10s  %-55s  %-10s %n",
				"├──────────────┤", " ", "├──────────────┤");
		
		// 네 번째 줄
		System.out.printf(" │ %-8s │ %-57s │ %-10s │%n",
				getLandDisplay(6), // 스톡홀름
				" ",
				getLandDisplay(17)); // 서울
		
		System.out.printf(" │ %-12s │ %-57s │ %-12s │%n",
				PlayerPiece(6),
				" ",
				" ",
				PlayerPiece(17));
		
		System.out.printf(" │ %-10s │ %-42s  %-2s │ %-10s │%n",
				getPrice(6),
				" ",
				"현재 턴 수: " + con, getPrice(17));
		
		System.out.println(
				" ├──────────────┼──────────────┬──────────────┬──────────────┬──────────────┼──────────────┤");
		
		// 다섯 번째 줄 - 각 칸의 자리 숫자에 맞춰 처리
		System.out.printf(" │ %-9s │ %-9s │ %-9s │ %-8s │ %-8s │ %-9s │%n",
				getLandDisplay(5), // 무인도
				getLandDisplay(4), // 베이징
				getLandDisplay(3), // 마닐라
				getLandDisplay(2), // 황금열쇠1
				getLandDisplay(1), // 타이페이
				getLandDisplay(0)); // 출발지
		
		System.out.printf(" │ %-12s │ %-12s │ %-12s │ %-12s │ %-12s │ %-12s │%n",
				PlayerPiece(5),
				PlayerPiece(4),
				PlayerPiece(3),
				PlayerPiece(2),
				PlayerPiece(1),
				PlayerPiece(0));
		
		System.out.printf(" │ %-12s │ %-10s │ %-10s │ %-12s │ %-10s │ %-12s │%n",
				" ",
				getPrice(4),
				getPrice(3),
				" ",
				getPrice(1),
				" ");
		
		System.out.println(
				" └──────────────┴──────────────┴──────────────┴──────────────┴──────────────┴──────────────┘");
	}

	// 두 명일 때 출력 형식
	private void printTwoPlayers() {
		System.out.printf(" │ %-9s │ %-49s │ %-10s │%n", getLandDisplay(8), // 아테나
				players.get(0).getPlayerSymbol(players.get(0).getPlayerId()) + " " +
				players.get(0).getName() +
				"님의 보유 재산: " + players.get(0).getMoney() + "만원", // player1 보유금액
				landList.getLandList().get(15).getLandName()); // 뉴욕
		
		System.out.printf(" │ %-12s │ %-49s │ %-12s │%n", PlayerPiece(8),
				players.get(1).getPlayerSymbol(players.get(1).getPlayerId()) +
				" " + players.get(1).getName()
				+ "님의 보유 재산: " + players.get(1).getMoney() + "만원", // player2 보유금액
				PlayerPiece(15));
		
		System.out.printf(" │ %-10s │ %-57s │ %-10s │%n",
				getPrice(8), " ", getPrice(15));
		
		System.out.printf(" %-10s  %-52s %-10s %n",
				"├──────────────┤", "　　　　 ", "├──────────────┤");
	}

	// 세 명일 때 출력 형식
	private void printThreePlayers() {
		System.out.printf(" │ %-9s │ %-49s │ %-10s │%n", getLandDisplay(8), // 아테나
				players.get(0).getPlayerSymbol(players.get(0).getPlayerId()) + " " + players.get(0).getName()
				+ "님의 보유 재산: " + players.get(0).getMoney() + "만원", // player1 보유금액
				getLandDisplay(15)); // 뉴욕
		
		System.out.printf(" │ %-12s │ %-49s │ %-12s │%n", PlayerPiece(8),
				players.get(1).getPlayerSymbol(players.get(1).getPlayerId()) + " " + players.get(1).getName()
				+ "님의 보유 재산: " + players.get(1).getMoney() + "만원", // player2 보유금액
				PlayerPiece(15));
		
		System.out.printf(" │ %-10s │ %-49s │ %-10s │%n", getPrice(8), // 아테네 인수 금액
				players.get(2).getPlayerSymbol(players.get(2).getPlayerId()) + " " + players.get(2).getName()
				+ "님의 보유 재산: " + players.get(2).getMoney() + "만원", // player3 보유금액
				getPrice(15)); // 뉴욕 인수 금액
		
		System.out.printf(" %-10s  %-52s %-10s %n",
				"├──────────────┤", "　　　　 ", "├──────────────┤");
	}

	// 네 명일 때 출력 형식
	private void printFourPlayers() {
		System.out.printf(" │ %-9s │ %-49s │ %-10s │%n", getLandDisplay(8), // 아테나
				players.get(0).getPlayerSymbol(players.get(0).getPlayerId()) + " " + players.get(0).getName()
				+ "님의 보유 재산: " + players.get(0).getMoney() + "만원", // player1 보유금액
				getLandDisplay(15)); // 뉴욕
		
		System.out.printf(" │ %-12s │ %-49s │ %-12s │%n", PlayerPiece(8),
				players.get(1).getPlayerSymbol(players.get(1).getPlayerId()) + " " + players.get(1).getName()
				+ "님의 보유 재산: " + players.get(1).getMoney() + "만원", // player2 보유금액
				PlayerPiece(15));
		
		System.out.printf(" │ %-10s │ %-49s │ %-10s │%n", getPrice(8), // 아테네 인수 금액
				players.get(2).getPlayerSymbol(players.get(2).getPlayerId()) + " " + players.get(2).getName()
				+ "님의 보유 재산: " + players.get(2).getMoney() + "만원", // player3 보유금액
				getPrice(15)); // 뉴욕 인수 금액
		
		System.out.printf(" %-10s %-49s %-10s %n",
				"├──────────────┤",
				players.get(3).getPlayerSymbol(players.get(3).getPlayerId()) + " " + players.get(3).getName()
				+ "님의 보유 재산: " + players.get(3).getMoney() + "만원", // player4 보유금액
				"├──────────────┤");
	}
}