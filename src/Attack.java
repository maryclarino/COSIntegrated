import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Attack {
	static String[][]state = new String[6][8];
	static int troop_life=0;
	static int struct_life=0;
	static int troop_attack=0;
	static int struct_attack=0;
	static int[]index = new int[3];
	static int valid = -1,cnt = 0;
	static int troop_index;
	static LowPanel p = new LowPanel();
	static String []gif = {"images/troops/barbarian_attack.gif","images/troops/archer_attack.gif","images/troops/giant_attack.gif","images/troops/wallbreaker_attack.gif","images/troops/wizard_attack.gif","images/troops/dragon_attack.gif"};
	
	
	public static void getData(String[][]ActualState){
	//	System.out.println("HELLO");
		for(int i=0;i<6;i++){
			for(int j=0; j<8;j++){
				state[i][j] = ActualState[i][j];
			}
		}
	}//end of function

public static void eval(int i){
	
	troop_index = i;
	troop_life = BattleField.troop_life_span[troop_index];
	troop_attack = BattleField.troop_attack_span[troop_index];
	index = select_struct(state);
	
	cnt = 0;
	while(valid == -1){
		//System.out.println(valid);
		//System.out.println(cnt);
		valid = init();
		cnt++;
		
		if(cnt == 47)
			break;
	
	}
	Icon struct_icon = UDPServer.field.buttons[index[0]][index[1]].getIcon();
	
	cnt = 0;
	JOptionPane.showMessageDialog(null, "BATTLE ON GOING...");
	
	
	while(troop_life>0 || struct_life >0){
		struct_life = Attack.AttackStruct(struct_life, troop_attack);
		troop_life = Attack.AttackTroop(troop_life, struct_attack);
		
		try {
			Thread.sleep(50);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cnt++;
	}
	if(troop_life>struct_life){
		
		JOptionPane.showMessageDialog(null, "TROOP SURVIVES!!!");
		state[index[0]][index[1]] = "grass";
		System.out.println("state["+index[0]+"]["+index[1]+"]="+state[index[0]][index[1]]);
		UDPServer.field.buttons[index[0]][index[1]].setEnabled(true);
		UDPServer.field.buttons[index[0]][index[1]].setIcon(new ImageIcon("images/grass.png"));
		//UDPServer.field.buttons[index[0]][index[1]].setIcon(new ImageIcon(gif[troop_index]));
		UDPServer.field.buttons[index[0]][index[1]].setEnabled(false);
		UDPServer.field.buttons[index[0]][index[1]].setDisabledIcon(UDPServer.field.buttons[index[0]][index[1]].getIcon());
		
		try{
			Thread.sleep(10);
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			UDPServer.update(state);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(check_state(state)==1){
			JOptionPane.showMessageDialog(null, "CONGRATULATIONS!!! YOU WIN!!!");
			
		/*	for(int cnt=0;cnt<6 ;cnt++){
				UDPServer.troop.troop_button[cnt].setEnabled(false);
			}*///end of for loop
		}
		
	}
	else{
		JOptionPane.showMessageDialog(null, "STRUCTURE SURVIVES!!!");
		//System.out.println("TROOP_INDEX:"+troop_index);
		UDPServer.troop.troop_button[troop_index].setEnabled(false);
		UDPServer.field.buttons[index[0]][index[1]].setEnabled(true);
		UDPServer.field.buttons[index[0]][index[1]].setIcon(struct_icon);
		UDPServer.field.buttons[index[0]][index[1]].setEnabled(false);
		UDPServer.field.buttons[index[0]][index[1]].setDisabledIcon(UDPServer.field.buttons[index[0]][index[1]].getIcon());
		try {
			UDPServer.update(state);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*try {
		UDPServer.update(state);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
}//end of eval function

public static int init(){
	index = select_struct(state);
	if(index[0] == -1){
		return -1;
	}
	else{
		struct_life = BattleField.struct_life_span[index[2]];
		struct_attack = BattleField.struct_attack_span[index[2]];
		return 0;
	}
}

public static int[] select_struct(String[][]state){
	int[]index = new int[3];
	for(int l=0; l<6;l++){
		for(int j=0; j<8;j++){
			for(int k=0; k<11;k++){
		  		if(state[l][j].equals(BattleField.state_path[k])){ //k = index of structure
		  			index[0] = l;
		  			index[1] = j;
		  			index[2] = k;
		  			return index;
		  		}
		  		else{
		  			index[0] = -1;
		  			index[1] = -1;
		  			index[2] = -1;
		  		}
			}
		}
	}
	
	return index;
}
public static int check_state(String [][]state){
	int cnt = 0;
	for(int i =0;i<6;i++){
		for(int j=0;j<8;j++){
			if(state[i][j].equals("grass")||state[i][j].equals("structures/resource/goldstorage1")){
				cnt++;
			}
		}
	}
	System.out.println(cnt);
	if(cnt == 42){
		return 1;
	}
	else{
		return 0;
	}
	
}

public static int AttackStruct(int struct_life,int troop_attack){
			return struct_life-troop_attack;
}

public static int AttackTroop(int troop_life,int struct_attack){
		 return troop_life-struct_attack;
}

}


