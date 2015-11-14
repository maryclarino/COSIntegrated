import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;




public class LoadTesterUI extends JPanel implements ActionListener {
	JButton send_v = new JButton("SEND VALID");
	JButton send_i = new JButton("SEND INVALID");
	LoadTesterClient c = new LoadTesterClient();
	JPanel p = new JPanel();
	static String []invalid = {"grass grass", "HDGSADGAJGHJA", "HELLO THERE!", "grass grass grass grass", "NYAHAHAHA!", "NYAHAHAHA!"};
	String []valid = new String [5];
	String []struct = {"structures/armycamp/barracks1", "structures/defense/airdefense1", "structures/resource/goldstorage1", "structures/defense/mortar1", "structures/defense/cannon1"};
	Random rand;
	int random_num = 0;
	public LoadTesterUI(){
		String state = "";
		for(int k = 0; k<5; k++){
			state = "";
			for(int i=0;i<6;i++){
				for(int j=0;j<8;j++){
						if(j%2 == 0){
							state = state + " " + struct[k];
						}
						else{
							state = state + " " +"grass";
						}
				}
				state = state + "\n";
			}
			valid[k] = state;
		}
		
		send_v.addActionListener(this);
		send_i.addActionListener(this);
		p.setPreferredSize(new Dimension(300,300));
		p.add(send_v);
		p.add(send_i);
		this.add(p);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == send_v){
			 random_num = (int) (Math.random() * ( 4 - 0 ));
			 System.out.println(random_num);
			try {
				c.tester(valid[random_num]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}//end of if send_v
		
		if(e.getSource() == send_i){
			 random_num = (int) (Math.random() * ( 4 - 0 ));
			
			try {
				String state = invalid[random_num];
				System.out.println(state);
				c.tester(state);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
