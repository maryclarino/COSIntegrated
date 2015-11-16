import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*; 

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class UDPServer extends JFrame { 
	public static String sentence2;
	public static TextArea text = new TextArea();
	public static JFrame frame = new JFrame();
	public static LowPanel troop = new LowPanel();
	public static String [][] ActualState = new String[6][8];	//parse text
	public static Panel field;
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
	System.out.println("RECEIVED: " + sentence2);
	Panel.h = sentence2;
	text.setText(sentence2);
	
	runWindow();
	
	}
}

public static void runWindow(){
	//SHOW THE STATE OF THE PLAYER
		JButton [][] buttons = new JButton[6][8];
		String[] state_text;
		int cnt = 0;
		field = new Panel();
		state_text = text.getText().split(" ");
		for(int i =0; i<state_text.length; i++){
			if(i-1>=0){
				field.buttons[(i-1)/8][(i-1)%8].setIcon(new ImageIcon("images/"+state_text[i]+".png"));
				ActualState[(i-1)/8][(i-1)%8] = state_text[i];
			}
		}
		for(int i=0; i<6;i++){
				field.buttons[i][7].setIcon(new ImageIcon("images/grass.png"));
				ActionListener l = null;
				troop.troop_button[i].addActionListener(l);
			
		}
		Attack.getData(ActualState);
		field.add(troop);
		frame.add(field);
		frame.setPreferredSize(new Dimension(700,700));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		
}




}
 