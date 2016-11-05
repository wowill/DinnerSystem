package data;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import javax.imageio.ImageReader;

public class SocketClient {

	public DataProcess DP;
	
	public SocketClient() {
		
		init();
	}
	
    public void init() {  
     
       DP = new DataProcess();
        try {
        	 Socket client = new Socket("127.0.0.1", 8979);  
			client.setSoTimeout(10000);

			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
	        PrintStream out = new PrintStream(os);  
	        BufferedReader buf =  new BufferedReader(new InputStreamReader(is));  
	        DataInputStream dis = new DataInputStream(is);
	        boolean flag = true;  
	        
	        //**********��ʱ������****************
			
			boolean f1 = true;			
			int fileIndex = 0;		
			boolean f2 = true;
			//************************************
			
			
        	PCV.perDetails = new ArrayList<>();
        	
        	
        	out.println("String");				//�ͻ��˷��͸�����˽����ַ������ݵ���ʾ��Ϣ
        	
        	//**************�ӷ���˽����ַ�������****************
        	
    		PCV.strPerDetails = buf.readLine();
    		System.out.println("�ͻ��˽��ճɹ�:PCV.strPerDetails"+PCV.strPerDetails);
    		System.out.println("�ַ������ݽ��ճɹ�");

        	//**************************************************
        	
    		//**********���ݴ������ַ������ݳ�ʼ���ͻ��˵�����**************
    		DP.dataToDiv();
    		//************************************************************
    		
    		
//    		out.println("Image");				//�ͻ��˷��͸�����˽���ͼƬ���ݵ���ʾ��Ϣ
    		//**************�ӷ���˽���ͼƬ����******************
//    		for(int i = 0; i < PCV.imgPath.size(); i++){
//    			System.out.println(PCV.imgPath.get(i));
//    		}
//    		System.out.println("***************");
    		for(int i = 0; i < PCV.imgPath.size(); i++){
    			System.out.println(PCV.imgPath.get(i));
    			
    			FileOutputStream fos = new FileOutputStream(new File(PCV.imgPath.get(i)));
    			byte[] bt = new byte[1024];
        		int len = 0;
        		while ((len = dis.read(bt)) > 0)			
        		{
        			if(new String(bt, 0, len).contains("next")){
        				System.out.println("next+++++++****************************"+ new String(bt, 0, len));
        				fos.flush();
        				fos.close();
        				break;
        			}
    				System.out.println("len " + len);
    				fos.write(bt,0,len);			//�ѽ��յ��ֽ���д��ͼƬ
    				fos.flush();
    				
        		}
    		}
    			
        		
    		
    		//**************************************************
	        
	        if(client != null){  
	            
	            client.close(); 
	        }  
	        if(buf != null){
	        	
	        	buf.close();
	        }
	        if(dis != null){
	        	dis.close();
	        }
	        
        } catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
}  