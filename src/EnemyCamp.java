import javax.swing.*;
import java.awt.*;

public class EnemyCamp{

	private JFrame frame = new JFrame("ENEMY CAMP");
	
	public EnemyCamp(){
		System.out.println("ATTAAAACK");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(200,200));
		frame.setVisible(true);
		frame.pack();
	}
	
}
