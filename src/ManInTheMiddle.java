import java.awt.Dimension;
import java.awt.TextArea;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;


public class ManInTheMiddle extends JFrame {
	public static String sentence2;
	public static TextArea text = new TextArea();
	public static JFrame frame = new JFrame();
	
	public static void main(String args[]) throws Exception      { 
		DatagramSocket clientSocket = new DatagramSocket();
		DatagramSocket serverSocket = new DatagramSocket(9876);  
		InetAddress IPAddress2 = InetAddress.getByName("10.0.4.185");
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
		System.out.println(sentence2);
		DatagramPacket sendPacket1 = new DatagramPacket(sendData, sendData.length, IPAddress2, 9876);  
		clientSocket.send(sendPacket1); 
		DatagramPacket receivePacket1 = new DatagramPacket(receiveData, receiveData.length);    
		clientSocket.receive(receivePacket1);    
		String modifiedSentence = new String(receivePacket1.getData());    
		//clientSocket.close();
		runTextWindow(sentence2,IPAddress,IPAddress2);
		
		}
		
		  
		
	}
	public static void runTextWindow(String sentence2,InetAddress IPAddress, InetAddress IPAddress2){
		text.setEditable(false);
		text.setPreferredSize(new Dimension(500,500));
		text.append("RECEIVED FROM: "+IPAddress);
		text.append("\nSTATE:"+sentence2);
		text.append("SEND TO:"+IPAddress2);
		frame.add(text);
		frame.setPreferredSize(new Dimension(500,500));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
	}
}
