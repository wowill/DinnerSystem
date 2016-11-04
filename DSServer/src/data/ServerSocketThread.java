package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
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
			
			//**********��ʱ������****************
			
			boolean f1 = true;			
			int fileIndex = 0;		
			//************************************
			
			while(flag){
				
				String str = buf.readLine();
				if(str.equals("end")){
					
					flag = false;
				}
				else{										//����ǿͻ��˴򿪵�ʱ�򣬷���˸���ˢ�¿ͻ��˵�����
					
					//**********�����ַ�������*********
					if(f1){
						
						out.println(PCV.sendSB.toString());
						f1 = false;
						

						continue;
					}
					//********************************
					
					//**********����ͼƬ����*********
					
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
		System.out.println("�̹߳ر� !");
	}
	
}
