import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*; 

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class UDPServer extends JFrame { 
	static Player player;
	public static String sentence2;
	public static TextArea text = new TextArea();
	public static JFrame frame = new JFrame();
	public static LowPanel troop = new LowPanel();
	public static String [][] ActualState = new String[6][8];	//parse text
	public static Panel field;
	
//-------------------------ACCEPT----------------------------------//	
public static void main(String args[]) throws Exception      { 
	DatagramSocket serverSocket = new DatagramSocket(9876);         
    byte[] receiveData = new byte[1024];             
	byte[] sendData = new byte[1024];
	while(true){
	DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
	serverSocket.receive(receivePacket);
	sentence2= new String( receivePacket.getData());
	InetAddress IPAddress = receivePacket.getAddress();
	int port = receivePacket.getPort();
	String capitalizedSentence = sentence2.toUpperCase();
	sendData = capitalizedSentence.getBytes();       
	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);                   
	serverSocket.send(sendPacket); 
	System.out.println("RECEIVED BY SERVER: " + sentence2);
	String[]sp = sentence2.split("_");
	sentence2 = sp[1];
	/*Panel.h = sentence2;
	text.setText(sentence2);
	*/
	if(sp[0].equals("T")){
		runWindow(sentence2);
	}else{
		Panel.getSentence(sentence2);
		
	}
	}
}//end Main

//----------------------------------RUN WINDOW-----------------------------------//
public static void runWindow(String sentence2){
	//SHOW THE STATE OF THE PLAYER
		JButton [][] buttons = new JButton[6][8];
		String[] state_text;
		int cnt = 0;
		field = new Panel();
		state_text = sentence2.split(" ");
		
		for(int i =0; i<state_text.length; i++){
			//System.out.println(state_text[i]+" \n");
			if(i-1>=0){
				if((((i-1)/8)<=5) && ((i-1)%8)<=7){
				field.buttons[(i-1)/8][(i-1)%8].setIcon(new ImageIcon("images/"+state_text[i]+".png"));
				ActualState[(i-1)/8][(i-1)%8] = state_text[i];
				}
			}
		}
		for(int i=0; i<6;i++){
				field.buttons[i][7].setIcon(new ImageIcon("images/grass.png"));
		}
		

		for(int i=0; i<6; i++){
			for(int j=0; j<8; j++){
				Icon icon = field.buttons[i][j].getIcon();
				field.buttons[i][j].setEnabled(false);
				field.buttons[i][j].setDisabledIcon(icon);
			}
		}
		Attack.getData(ActualState);
		field.add(troop);
		frame.add(field);
		frame.setPreferredSize(new Dimension(700,700));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
}//end of run Window

//---------------------------------THROW UPDATED STATE------------------------------------//
public static void update(String[][]state_array) throws IOException{
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       
	DatagramSocket clientSocket = new DatagramSocket();
	InetAddress IPAddress = InetAddress.getByName("10.0.5.47");//MainWindow.stats_panel.server_text.getText());       
	byte[] sendData = new byte[1024];
	byte[] receiveData = new byte[1024]; 
	//String sentence = inFromUser.readLine(); 
	//sentence = sentence+player.getName();
	String state = "U_";
	//GET THE STATE OF THE PLAYER FOR IMAGES SAKE
	for(int i=0;i<6;i++){
		for(int j=0;j<8;j++){
				state = state + " " +state_array[i][j];
		}
		state = state + "\n";
	}
	
	sendData = state.getBytes();
	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);  
	clientSocket.send(sendPacket); 
	
}//end of udpate function

//---------------------------------THROW STATE------------------------------------//
public void try1() throws Exception    {
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       
	DatagramSocket clientSocket = new DatagramSocket();
	InetAddress IPAddress = InetAddress.getByName("10.0.5.47");//MainWindow.stats_panel.server_text.getText());       
	byte[] sendData = new byte[1024];
	byte[] receiveData = new byte[1024]; 
	//String sentence = inFromUser.readLine(); 
	//sentence = sentence+player.getName();
	String state = "T_";
	//GET THE STATE OF THE PLAYER FOR IMAGES SAKE
	for(int i=0;i<6;i++){
		for(int j=0;j<8;j++){
			if(player.field.state_buttons[i][j].equals("grass")){
				state = state + " " +player.field.state_buttons[i][j];
				
			}
			else{
				state = state + " " + "structures/"+player.field.type[i][j]+"/"+player.field.state_buttons[i][j];
				
			}
		}
		state = state + "\n";
	}
	
	sendData = state.getBytes();
	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);  
	clientSocket.send(sendPacket); 
	
}//end of try1 function
public void receivePlayer(Player player1){
	player = player1;
}//end of receivePlayer
}
 