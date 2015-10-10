import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//FIELD PANEL: panel para doon sa field/grass part
public class Panel extends JPanel implements ActionListener {

	ActionPanel act_panel = new ActionPanel();
	JPanel panel = new JPanel();
	static JButton [][]buttons = new JButton[6][8];
	JButton []troop_button = new JButton[6];
	int [] button_index = new int[2];

	public Panel(){
		//-------------------GUI-------------------------------//
		for(int i =0; i<6;i++){
			for(int j =0; j<8;j++){
				buttons[i][j] = new JButton(new ImageIcon("images/grass.jpg"));
				buttons[i][j].setPreferredSize(new Dimension(80,80));
				buttons[i][j].setBackground(Color.green);
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}//end of for loop*/
		
		panel.setPreferredSize(new Dimension(680,520));
		panel.setVisible(true);
		this.add(panel);
	}//end of public panel
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		BattleField field = new BattleField();
		final Player player1 = new Player("Mary", 50,50,field);	//example lang: instance of a player
		final Player player2 = new Player("Ayel", 50,50,field);	//example lang: instance of a player
		final Player player3 = new Player("Zyrine", 50,50,field);	//example lang: instance of a player
		
		for(int i =0;i<6;i++){
			for(int j =0;j<6;j++){
				if(e.getSource() == buttons[i][j]){ 
					//store sa array iyong index para malaman anong button inaccess
					button_index[0] = i;
					button_index[1] = j;
					act_panel.receiveIndex(button_index);
					
					
					//if may napindot siya sa grass part. lalabas ang ActionWindow
					/*window.setPreferredSize(new Dimension(300,150));
					window.add(act_panel);
					window.setVisible(true);
					window.pack();*/
					final int indexI = i;
					final int indexJ = j;
					final Icon icon = new ImageIcon("images/icons/assembly_icon.png");
					final Icon icon2 = new ImageIcon("images/icons/metal_sword_icon.png");
					final Icon icon3 = new ImageIcon("images/icons/upgrade.png");
					
					final JButton button1 = new JButton("", icon);
					final JButton button2 = new JButton("", icon2);
					final JButton button3 = new JButton("", icon3);
					
					button1.setToolTipText("BUY");
					button2.setToolTipText("ATTACK");
					button3.setToolTipText("UPGRADE");
					
					button1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){
							System.out.println("BUILD");
							//ActionPlayer.build(player1,button_index);
							
							String[] options = {"Army Camp", "Defense", "Resource"};
							int n = JOptionPane.showOptionDialog(null,
							"STRUCTURES",
							"Choose Type:",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[0]);
							
							switch(n){
							case 0: System.out.println("Army Camp");
									final String[] armynames = {"archerqueenaltar", "barbariankingaltar", "barracks1"};
									final JButton[] army = new JButton[3];
									Component[] comp = new Component[3];
									for(int z=0; z<3; z++){
										Icon icn = new ImageIcon("images/structures/army camp/"+armynames[z]+".png");
										final int indexZ = z;
										army[z] = new JButton("", icn);
										army[z].setToolTipText(armynames[z]);
										army[z].addActionListener(new ActionListener(){
											public void actionPerformed(ActionEvent ae0){
												Panel.buttons[indexI][indexJ].setIcon(new ImageIcon("images/structures/army camp/"+armynames[indexZ]+".png"));
												
												player1.field.changeField(player1, button_index, armynames[indexZ], "army camp");
												for(int y=0; y<3; y++){
													army[y].setEnabled(false);
												}
											}
										});
										comp[z] = army[z];
									}
									
									int m = JOptionPane.showOptionDialog(null,
									"Choose Structure",
									"ARMY CAMP:",
									JOptionPane.DEFAULT_OPTION, 
									JOptionPane.QUESTION_MESSAGE,
									null,
									comp,
									null);
									
									break;
							case 1:	System.out.println("Defense");
								
									final String[] defensenames = {"airdefense1", "archertower1","cannon1", "infernotower1", "mortar1", "trapbomb", "trapspring", "wizardtower1", "xbowground1"};
									final JButton[] defense = new JButton[8];
									Component[] comp2 = new Component[8];
									for(int z=0; z<8; z++){
										Icon icn = new ImageIcon("images/structures/defense/"+defensenames[z]+".png");
										final int indexZ = z;
										defense[z] = new JButton("", icn);
										defense[z].setToolTipText(defensenames[z]);
										defense[z].addActionListener(new ActionListener(){
											public void actionPerformed(ActionEvent ae0){
												Panel.buttons[indexI][indexJ].setIcon(new ImageIcon("images/structures/defense/"+defensenames[indexZ]+".png"));
												player1.field.changeField(player1, button_index, defensenames[indexZ], "defense");
												
												for(int y=0; y<8; y++){
													defense[y].setEnabled(false);
												}
											}
										});
										comp2[z] = defense[z];
									}
									
									int o = JOptionPane.showOptionDialog(null,
									"Choose Structure",
									"DEFENSE:",
									JOptionPane.DEFAULT_OPTION, 
									JOptionPane.QUESTION_MESSAGE,
									null,
									comp2,
									null);
									break;
							case 2:	System.out.println("Resource");
									Component[] comp3 = new Component[1];
									Icon icn = new ImageIcon("images/structures/resource/goldstorage1.png");
									final JButton resource = new JButton("", icn);
									resource.setToolTipText("gold storage");
									resource.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent ae0){
											
											Panel.buttons[indexI][indexJ].setIcon(new ImageIcon("images/structures/resource/goldstorage1.png"));
											player1.field.changeField(player1, button_index, "goldstorage1", "resource");
											
											resource.setEnabled(false);
										}
									});
									comp3[0] = resource;
									
									int p = JOptionPane.showOptionDialog(null,
									"Choose Structure",
									"RESOURCE:",
									JOptionPane.DEFAULT_OPTION, 
									JOptionPane.QUESTION_MESSAGE,
									null,
									comp3,
									null);
									break;
							default: break;
							
							}
						}
					});
					
					button2.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){
							System.out.println("ATTACK");
							//ActionPlayer.attack(player2,player3);
							//new EnemyCamp();
							
							JFrame opponents = new JFrame("ENEMY CAMPS");
							opponents.setAlwaysOnTop(true);
							opponents.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							opponents.setVisible(true);
							opponents.setPreferredSize(new Dimension(500,500));
							opponents.pack();
							
						}
					});

					button3.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){
							System.out.println("UPGRADE");
							System.out.println(player1.field.state_buttons[button_index[0]][button_index[1]]);
							String [] struct_temp = player1.field.state_buttons[button_index[0]][button_index[1]].split("[0-9]");
							String [] temp = player1.field.state_buttons[button_index[0]][button_index[1]].split("");
							
							System.out.println(temp[temp.length-1]);
							if(temp[temp.length-1].matches("[1-4]")){
								String structType = player1.field.getStructType(player1, button_index);
								System.out.println(structType);
								if((Integer.parseInt(temp[temp.length-1])+1) < 5){
									player1.field.changeField(player1, button_index, struct_temp[0]+(Integer.parseInt(temp[temp.length-1])+1), structType);
									Panel.buttons[indexI][indexJ].setIcon(new ImageIcon("images/structures/"+structType+"/"+struct_temp[0]+(Integer.parseInt(temp[temp.length-1])+1)+".png"));
									System.out.println(player1.field.state_buttons[button_index[0]][button_index[1]]);
								}
								
								
							}
							
									
						}
					});
					
					JOptionPane.showOptionDialog(null,
					"OPTIONS",
					"What do you want to do?",
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE,
					null,
					new Component[]{
						button1,
						button3,
						button2
					}, null
					);
					
					
					

					
					
				}
			}
		}
		
	}
}//end of class
