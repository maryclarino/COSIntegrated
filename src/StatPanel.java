import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//stat panel: UI para mapakita level, coins, experience ng user
public class StatPanel extends JPanel {
	JPanel panel = new JPanel();
	
	public StatPanel(){
		panel.setPreferredSize(new Dimension(100,100));
		panel.setVisible(true);
		this.add(panel);
	}//end of class
}
