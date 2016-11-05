package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			PrintStream out = new PrintStream(os);
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			boolean flag = true;
			
			//**********临时变量区****************
			
			boolean f1 = true;			

			//************************************
			
			//**********发送字符串数据*********
			String str = buf.readLine();
			if(str.equals("String")){
				System.out.println("服务端接收到传授字符串数据提示："+str);
				out.println(PCV.sendSB.toString());
				System.out.println("字符串数据发送成功");
			}
			//********************************
			
			//**********发送图片数据***********
			
			for(int i = 0; i < PCV.fileList.size(); i++){

				System.out.println( "index "+i);
				FileInputStream fis = new FileInputStream(PCV.fileList.get(i));
			
				byte[] bt = new byte[1024];
				int len = 0;
				
				while((len = fis.read(bt)) != -1)
				{
					out.write(bt,0,len);
					out.flush();
				}
			
				fis.close();
				out.write("next".getBytes());
				out.flush();
			}
			
			//********************************
			
			if(out != null){
				out.close();
			}
			if(buf != null){
				buf.close();
			}
			if(client != null){
				client.close();
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("线程关闭 !");
	}
	
}
