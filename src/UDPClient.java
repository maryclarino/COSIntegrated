import java.io.*;
import java.net.*;
 class UDPClient { 
	 static Player player;
	public void try1() throws Exception    {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");       
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
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);    
		clientSocket.receive(receivePacket);    
		String modifiedSentence = new String(receivePacket.getData());    
		//clientSocket.close();
		} 
	public void receivePlayer(Player player1){
		player = player1;
		
	}
} 