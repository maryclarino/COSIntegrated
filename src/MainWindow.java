import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class MainWindow extends JFrame {
	//static Panel panel = new Panel();			//panel of the field
	static Panel panel = new Panel();			//panel of the field
	
	static LowPanel low_panel = new LowPanel();	//panel of the troop
	static StatPanel stats_panel = new StatPanel();	//panel of the stat
	static ChatClient client_chat = new ChatClient();

	static JFrame window = new JFrame();
	static JInternalFrame troop = new JInternalFrame("TROOP", true,true,true,true);
	
	public static void main(String[]args) throws IOException{
		//-----------------------------------GUI--------------------------------------------
		JFrame frame = new JFrame("COMBAT OF SOLITARY");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JDesktopPane desktop = new JDesktopPane();
		
		//WINDOW FIELD
		JInternalFrame field = new JInternalFrame("FIELD", true,true,true,true);
		field.add(panel);
		field.setVisible(true);
		field.setBounds(70, 70, 700, 550);
		field.setLocation(300,0);
		
		//TROOP WINDOW
		troop.add(low_panel);
		troop.setVisible(true);
		troop.setBounds(70, 70, 700, 130);
		troop.setLocation(300,550);
		
		//CHAT WINDOW
		JInternalFrame chat = new JInternalFrame("CHAT", true,true,true,true);
		chat.add(client_chat.frame);
		chat.setVisible(true);
		chat.setBounds(70, 70, 300, 480);
		chat.setLocation(0,200);

		//STATS WINDOW
		JInternalFrame stats = new JInternalFrame("STATS", true,true,true,true);
		stats.add(stats_panel);
		stats.setVisible(true);
		stats.setBounds(70, 70, 300, 200);
		stats.setLocation(0,0);
		
		desktop.add(field);
		desktop.add(troop);
		desktop.add(stats);
		desktop.add(chat);
		frame.add(desktop);
		frame.setPreferredSize(new Dimension(1010, 720));
		frame.setVisible(true);
		frame.pack();
		
		//RUN CHAT WINDOW
		client_chat.frame.setLocation(0,230);
		//client_chat.frame.setPreferredSize(new Dimension(300,200));
        client_chat.frame.setVisible(true);
        client_chat.run();
		
	}


}