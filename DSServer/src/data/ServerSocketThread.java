package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
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
			
			//**********临时变量区****************
			
			boolean f1 = true;			
			int fileIndex = 0;		
			//************************************
			
			while(flag){
				
				String str = buf.readLine();
				if(str.equals("end")){
					
					flag = false;
				}
				else{										//如果是客户端打开的时候，服务端负责刷新客户端的数据
					
					//**********发送字符串数据*********
					if(f1){
						
						out.println(PCV.sendSB.toString());
						f1 = false;
						

						continue;
					}
					//********************************
					
					//**********发送图片数据*********
					
					if(!f1 && fileIndex < PCV.fileList.size()){
						
						FileInputStream fis = new FileInputStream(PCV.fileList.get(fileIndex));
						fileIndex++;
						
						byte[] bt = new byte[1024];
						int len = 0;
						
						while ((len = fis.read(bt)) != -1)
						{
							out.write(bt,0,len);
						}
					}
					
					//********************************
					
					if(!f1 && fileIndex == PCV.fileList.size()){
						break;
					}
					
//					out.print(PCV.sendSB.toString());
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
