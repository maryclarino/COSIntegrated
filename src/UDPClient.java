import java.awt.Dimension;
import java.awt.TextArea;
import java.io.*;
import java.net.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
public class UDPClient extends JFrame { 
	 static Player player;
	 public static Panel field;
	 public static String [][] ActualState = new String[6][8];	//parse text
	 static String sentence2;
	 public static TextArea text = new TextArea();
	 public static JFrame frame = new JFrame();
	 public static LowPanel troop = new LowPanel();
	 
	 
	 public static void main(String[]args) throws IOException{
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
			System.out.println("RECEIVED BY USER: " + sentence2);
			Panel.update_buttons(sentence2);
				
			}//end of while loop
			
	 }//end of main function
	 
	 
	public void try1() throws Exception    {
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("192.168.10.7");//MainWindow.stats_panel.server_text.getText());       
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024]; 
		//String sentence = inFromUser.readLine(); 
		//sentence = sentence+player.getName();
		String sentence = player.getName();
		String state = "";
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