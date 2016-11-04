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
		
		System.out.println("新线程...");
		try {
			
			PrintStream out = new PrintStream(client.getOutputStream());
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean flag = true;
			while(flag){
				
				String str = buf.readLine();
				if(str != null || str != ""){
					
					flag = false;
				}
				else if(str.equals("openInit")){			//如果是客户端打开的时候，服务端负责刷新客户端的数据
					
					//**********发送字符串数据*********
					
					
					//********************************
					
					//**********发送图片数据*********
					
					
					//********************************
					
					
					out.print(PCV.sendSB.toString());
				}
			}
			
			out.close();
			buf.close();
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程关闭 !");
	}
	
}
