import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//stat panel: UI para mapakita level, coins, experience ng user
public class StatPanel extends JPanel {
	JPanel panel = new JPanel();
	JLabel server_label = new JLabel("SERVER: ");
	JTextArea server_text = new JTextArea();
	
	public StatPanel(){
//		panel.setPreferredSize(new Dimension(150,150));
//		server_text.setPreferredSize(new Dimension(120,30));
//		panel.add(server_label);
//		panel.add(server_text);
		
		panel.setVisible(true);
		this.add(panel);
	}//end of class
}
