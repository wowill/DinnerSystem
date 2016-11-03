package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerSocketThread implements Runnable{			//服务端线程类

	public Socket client;
	
	public ServerSocketThread(Socket client) {
		
		this.client = client;
		init();
	}

	public void init() {
		
		
	}

	@Override
	public void run() {
		
		try {
			PrintStream out = new PrintStream(client.getOutputStream());
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			String str = buf.readLine();
			if(str != null || str != ""){
				
				
			}
			out.close();
			buf.close();
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
