
public class BattleField {
	String [][]state_buttons = new String [6][8]; //pang store kung anong current state ng field niya
	String [][] type = new String[6][8];
	
	public BattleField(){
		for(int i =0; i<6; i++){
			for(int j=0; j<8;j++){
				state_buttons[i][j] = "grass";
				type[i][j] = null;
			}
		}
	}//end of public BattleField
	
	public void changeField(Player player, int[]index_buttons, String structure_name, String struct_type){
		player.field.state_buttons[index_buttons[0]][index_buttons[1]] = structure_name;
		player.field.type[index_buttons[0]][index_buttons[1]] = struct_type;
		player.coins = player.coins-50;
		
	}
	
	public String getStructType(Player player, int[] index_buttons){
		return player.field.type[index_buttons[0]][index_buttons[1]];
	}
}
