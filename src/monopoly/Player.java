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
  private List<Hotel> hotelList = new ArrayList<>();
  
  public Player(String name, int playerId) {
    this.name = name;
    this.playerId = playerId;
    this.money = 125;  // 초기 자본금
    this.playerPo = 0;  // 초기 위치
  }
  
  public String getPlayerSymbol(int playerId) {
    switch (playerId) {
      case 1: return "★";
      case 2: return "♬"; 
      case 3: return "♥";  
      case 4: return "◆";  
      default: return "";
    }
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
    return playerId + ". " + name + "님" + ", 현재 재산 : " + money;
  }
  // getter/setter
  public String getName() {
    return name;
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