package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			PrintStream out = new PrintStream(os);
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			boolean flag = true;
			
			//**********��ʱ������****************
			
			boolean f1 = true;			

			//************************************
			
			//**********�����ַ�������*********
			String str = buf.readLine();
			if(str.equals("String")){
				System.out.println("����˽��յ������ַ���������ʾ��"+str);
				out.println(PCV.sendSB.toString());
				System.out.println("�ַ������ݷ��ͳɹ�");
			}
			//********************************
			
			//**********����ͼƬ����***********
			
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
		System.out.println("�̹߳ر� !");
	}
	
}
