package monopoly;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
	
    private String name;
    private int money;
    private int playerPo;
    private int playerId;
    private List<Hotel> hotelList = new ArrayList<>(); //**
    
    public Player(String name, int playerId) {
        this.name = name;
        this.playerId = playerId;
        this.money = 100;  // 초기 자본금
        this.playerPo = 0;  // 초기 위치
    }
    
    public void sortList() { //**
    	hotelList = hotelList.stream()
    		    .sorted(Comparator.comparingInt(Hotel::getSale)) 
    		    .collect(Collectors.toList()); 
    }
    
	public List<Hotel> getHotelList() { //**
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) { //**
		this.hotelList = hotelList;
	}

	@Override
	public String toString() {
		return "Player " + playerId + ") " + name + " | 재산 : " + money + " | 현재 위치 : " + playerPo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPlayerPo() {
		return playerPo;
	}
	public void setPlayerPo(int playerPo) {
		this.playerPo = playerPo;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
}