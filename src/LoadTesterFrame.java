import java.awt.Dimension;

import javax.swing.JFrame;


public class LoadTesterFrame extends JFrame {
	static LoadTesterUI ui = new LoadTesterUI();
	static JFrame frame = new JFrame();
	
	public static void main(String []args){
		frame.add(ui);
		frame.setPreferredSize(new Dimension(300, 200));
		frame.setVisible(true);
		frame.pack();
	}
}
