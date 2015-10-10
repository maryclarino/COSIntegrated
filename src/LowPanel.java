import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class LowPanel extends JPanel {
	JPanel panel = new JPanel();
	JButton [] troop_button = new JButton[6];
	String [] image_path = new String[6];
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
			panel.add(troop_button[i]);
		}
		
		panel.setPreferredSize(new Dimension(680,100));
		panel.setBackground(Color.black);
		panel.setVisible(true);
		this.add(panel);
	}
}
