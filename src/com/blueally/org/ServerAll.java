package com.blueally.org;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAll implements Runnable{

	

		private Socket connection;

		ServerAll(Socket s) {
		    this.connection = s;
		}

		public static void main(String[] args) {
		    int port1 = 7777;
		    int port2 = 8888;
		    int port3 = 9999;
		    int count = 0;
		    try{
		        ServerSocket server1 = new ServerSocket(port1);
		        ServerSocket server2 = new ServerSocket(port2);
		        ServerSocket server3 = new ServerSocket(port3);

		        System.out.println("Server Initialized");
		        while (true) {
		        Socket con1 = server1.accept();
		        Runnable runnable1 = new ServerAll(con1);
		        Thread thread1 = new Thread(runnable1);
		        thread1.start();

		        Socket con2 = server2.accept();
		        Runnable runnable2 = new ServerAll(con2);
		        Thread thread2 = new Thread(runnable2);
		        thread2.start();

		        Socket con3 = server3.accept();
		        Runnable runnable3 = new ServerAll(con3);
		        Thread thread3 = new Thread(runnable3);
		        thread3.start();
		        }
		    }
		    catch (Exception e) {}
		}

		public void run() {
		    try {
		        DataInputStream in = new DataInputStream(connection.getInputStream());
		        String clientMsg = in.readUTF();
		        String replyMsg = null;

		        if(clientMsg.equalsIgnoreCase("1")){
		            String msg = "Server Reply on 1";
		            replyMsg=msg;
		        }

		        if(clientMsg.equalsIgnoreCase("2")){
		            String msg = "Server Reply on 2";
		            replyMsg=msg;
		        }

		        if(clientMsg.equalsIgnoreCase("3")){
		            String msg = "Server Reply on 3";
		            replyMsg=msg;
		        }

		        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		        out.writeUTF(replyMsg);
		    }
		    catch (Exception e) {
		        System.out.println(e);
		    }
		    finally {
		        try {
		            connection.close();
		        }
		        catch (IOException e){}
		    }}
}