
public class BattleField {
	String [][]state_buttons = new String [6][8]; //pang store kung anong current state ng field niya
	String [][] type = new String[6][8];
	int [] troop = new int[6];
	int [] states = new int[11];
	//barbarian,archer,giant,wallbreaker,wizard,dragon
	static int[] troop_life_span = {200,200,300,150,250,200};
	static int[] troop_attack_span = {20,20,30,15,25,30};
	//archerqueenaltar,barbarianqueenaltar,barrakcs,airdefense,archertower,cannon,infernotower,mortar,trapbomb,trapspring,wizardtower
	static int[] struct_life_span = {1000,1000,1000,1000,1000,1000,1000,1000,0,0,1000};
	static int[] struct_attack_span ={10,10,10,10,10,10,10,10,30,30,10};
	
	static String [] state_path ={"structures/armycamp/archerqueenaltar","structures/armycamp/barbariankingaltar","structures/armycamp/barracks1",
		"structures/defense/airdefense1","structures/defense/airsweeper1","structures/defense/archertower1","structures/defense/cannon1",
		"structures/defense/infernotower1","structures/defense/mortar1","structures/defense/trapbomb","structures/defense/trapspring","structures/defense/wizardtower1",
		"structures/defense/xbowground1"};
	public BattleField(){
		for(int i =0; i<6; i++){
			for(int j=0; j<8;j++){
				state_buttons[i][j] = "grass";
				type[i][j] = null;
			}
			troop[i] = 1;
		}
		
		for(int i=0; i<11;i++){
			states[0] = 0;
		}
		
	}//end of public BattleField
	
	public Player changeField(Player player, int[]index_buttons, String structure_name, String struct_type){
		player.field.state_buttons[index_buttons[0]][index_buttons[1]] = structure_name;
		player.field.type[index_buttons[0]][index_buttons[1]] = struct_type;
		player.coins = player.coins-50;
		
		return player;
		
	}
	
	public Player setState(Player player, int index){
		player.field.states[index] = player.field.states[index]+1;
		return player;
	}
	
	public String getStructType(Player player, int[] index_buttons){
		return player.field.type[index_buttons[0]][index_buttons[1]];
	}
	

}
