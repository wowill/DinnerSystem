package data;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			boolean flag = true;
			
			//**********��ʱ������****************
			
			boolean f1 = true;			

			//************************************
			
			//**********�����ַ�������*********
			String str = dis.readUTF();
			if(str.equals("String")){
				System.out.println("����˽��յ������ַ���������ʾ��"+str);
				dos.writeUTF(PCV.sendSB.toString());
				System.out.println("�ַ������ݷ��ͳɹ�");
			}
			//********************************
			
			//**********����ͼƬ����***********
			
			for(int i = 0; i < PCV.fileList.size(); i++){

				System.out.println( "index "+i);
				FileInputStream fis = new FileInputStream(PCV.fileList.get(i));
			
				byte[] bt = new byte[1024];
				int len = 0;
				int k = 0;
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int picLeng = 0;
				
				while((len = fis.read(bt,0,bt.length)) != -1)
				{
					k++;
					bos.write(bt,0,len);
					bos.flush();
					picLeng += len;
					
				}
				
				bos.flush();
				dos.writeLong(picLeng);
				dos.write(bos.toByteArray(), 0, picLeng);
				System.out.println("picLeng "+picLeng);
				System.out.println("������ "+k);
//				dos.write("mext_picture".getBytes(),0,"mext_picture".getBytes().length);
//				System.out.println("mext_picture".getBytes());
				dos.flush();
				dos.flush();
			}
			
			//********************************
			
			if(dos != null){
				dos.close();
			}
			if(dis != null){
				dis.close();
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
