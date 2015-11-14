import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

//stat panel: UI para mapakita level, coins, experience ng user
public class StatPanel extends JPanel {
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea(10,10);
	public StatPanel(){
		panel.setPreferredSize(new Dimension(100,100));
		panel.add(text);
		panel.setVisible(true);
		this.add(panel);
	}//end of class
}
