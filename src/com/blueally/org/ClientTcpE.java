package com.blueally.org;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTcpE {
	public static void main(String[] args) {
	    String host = "localhost";
	    int port = 7777;
	    System.out.println("SocketClient initialized");
	    try {
	        InetAddress address = InetAddress.getByName(host);
	        Socket client = new Socket(address, port);
	        System.out.println("Just connected to "+ client.getRemoteSocketAddress());
	        OutputStream outToServer = client.getOutputStream();
	        DataOutputStream out = new DataOutputStream(outToServer);
	        out.writeUTF("1");
	        System.out.println("Just sent msg to server");

	        InputStream inFromServer = client.getInputStream();
	        DataInputStream in = new DataInputStream(inFromServer);
	        String serverMsg = in.readUTF();

	        System.out.println("server says : "+serverMsg);
	        client.close();
	    }catch(IOException e){
	        e.printStackTrace();
	    }   
	}

}
