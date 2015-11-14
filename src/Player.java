//CLASS FOR PLAYER
public class Player {
	//PORT, NAME, COINS, EXPERIENCE, BATTLE FIELD
	String name;
	int coins = 50, experience = 50, level = 0;
	BattleField field;
	
	public Player(String name, int coins, int experience, BattleField field){
		this.name = name;
		this.coins = coins;
		this.experience = experience;
		this.field = field;
	}
	
	public String getName(){
		return name;
	}
	
	
}
