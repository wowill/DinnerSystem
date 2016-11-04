package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerSocketThread implements Runnable{			//������߳���

	public Socket client;
	
	public ServerSocketThread(Socket client) {
		
		this.client = client;
		init();
	}

	public void init() {
		
		
	}

	@Override
	public void run() {
		
		System.out.println("���߳�...");
		try {
			
			PrintStream out = new PrintStream(client.getOutputStream());
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean flag = true;
			while(flag){
				
				String str = buf.readLine();
				if(str != null || str != ""){
					
					flag = false;
				}
				else if(str.equals("openInit")){			//����ǿͻ��˴򿪵�ʱ�򣬷���˸���ˢ�¿ͻ��˵�����
					
					//**********�����ַ�������*********
					
					
					//********************************
					
					//**********����ͼƬ����*********
					
					
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
		System.out.println("�̹߳ر� !");
	}
	
}
