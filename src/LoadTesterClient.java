import java.io.*;
import java.net.*;
 class LoadTesterClient { 
	 static Player player;
	public void tester(String state) throws Exception    {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("192.168.10.3");       
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024]; 
		sendData = state.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);  
		clientSocket.send(sendPacket); 
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);    
		clientSocket.receive(receivePacket);    
		String modifiedSentence = new String(receivePacket.getData());    
		//clientSocket.close();
		} 
	
} 