import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//Panel para doon sa options kung mag build, attack or defense ba siya
public class ActionPanel extends JPanel implements ActionListener {
	JPanel panel = new JPanel();
	JButton attack = new JButton(new ImageIcon("images/icons/metal_sword_icon.png"));
	JButton build = new JButton(new ImageIcon("images/icons/assembly_icon.png"));
	Panel panel2;
	BattleField field = new BattleField();
	
	Player player1 = new Player("Mary", 50,50,field);	//example lang: instance of a player
	Player player2 = new Player("Ayel", 50,50,field);	//example lang: instance of a player
	Player player3 = new Player("Zyrine", 50,50,field);	//example lang: instance of a player
	
	int []button_index = new int[2];
	
	int action;
	public ActionPanel(){
		//--------------------------------GUI-------------------------//
		build.setPreferredSize(new Dimension(80,80));
		attack.setPreferredSize(new Dimension(80,80));
		
		build.addActionListener(this);
		attack.addActionListener(this);
		
		build.setToolTipText("BUILD");
		attack.setToolTipText("ATTACK");
		
		panel.setPreferredSize(new Dimension(300,300));
		panel.setVisible(true);
		panel.add(build);
		panel.add(attack);
		
		this.add(panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == build){ //if pinili niyang magbuild go to class ActionPlayer
			//ActionPlayer.build(player1,getIndex());
		}//end of build
		
		if(e.getSource() == attack){ //if pinili niyang magattack
			ActionPlayer.attack(player2,player3);
		}//end of attack
		
		
	}
	
	public int getAction(){
		return action;
	}
	
	
	public void receiveIndex(int []index){
		button_index[0] = index[0];	//row number
		button_index[1] = index[1]; //column number
	}
	
	public int[] getIndex(){
		return button_index;
	}
}
