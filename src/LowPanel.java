import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class LowPanel extends JPanel implements ActionListener{
	JPanel panel = new JPanel();
	JButton [] troop_button = new JButton[6];
	String [] image_path = new String[6];
	String[][] state = new String[6][8];
	int index_troop;
	public LowPanel(){
		
			image_path[0] = new String("images/troops/barbarian2.png");
			image_path[1] = new String("images/troops/archer1.png");
			image_path[2] = new String("images/troops/giant1.png");
			image_path[3] = new String("images/troops/wallbreaker1.png");
			image_path[4] = new String("images/troops/wizard1.png");
			image_path[5] = new String("images/troops/dragon1.png");
			
		//image_path[0] = "images\troops\archer1.png";
		
		for(int i=0; i<6;i++){
			troop_button[i] = new JButton(new ImageIcon(image_path[i]));
			troop_button[i].setPreferredSize(new Dimension(100,80));
			troop_button[i].setBackground(Color.black);
			troop_button[i].addActionListener(this);
			panel.add(troop_button[i]);
		}
		
		panel.setPreferredSize(new Dimension(680,100));
		panel.setBackground(Color.black);
		panel.setVisible(true);
		this.add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i =0; i<6;i++){
			if(e.getSource() == troop_button[i]){	//i = index of troop
			//		troop_button[i].setEnabled(false);
					Attack.eval(i);
					
					
					
			}
		}
	}
		
	//end of function
	
	
	
}
