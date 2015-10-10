import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ActionPlayer {
		//----------------------BUILD FUNCTION-----------------//
		//parameters: player (includes the coins etc. check Player.java, index_buttons: iyong index naclick na buttons ng user
		public static Player build(Player player,int[]index_buttons, String structure_name){
				player.field.state_buttons[index_buttons[0]][index_buttons[1]] = structure_name;
				player.coins = player.coins-50;
				
				return player; //return player (nabago na iyong field at state niya)
				
			}
		//--------------------ATTACK FUNCTION-----------------//
		public static Player attack(Player player1, Player player2){
			//katulad sa build. bale iaccess natin attributes ng each player and mag increment at decrement na lang based sa actions niya (kung nagdagdag ng troops etc)
				System.out.println("ATTACK!");
				JFrame enemyCamp = new JFrame("ENEMY CAMPS");
				enemyCamp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				enemyCamp.setVisible(true);
				enemyCamp.setPreferredSize(new Dimension(100,100));
				enemyCamp.pack();
				
				return player1;
		}
		//--------------------DEFENSE FUNCTION---------------//
		public static Player defense(Player player1, Player player2){
			//katulad sa build. bale iaccess natin attributes ng each player and mag increment at decrement na lang based sa actions niya (kung nagdagdag ng troops etc)
			
				System.out.println("DEFENSE!");
				return player1;
		}

}
