package data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class SocketClient {

	public SocketClient() {
		
		init();
	}
	
    public void init() {  
     
       
        try {
        	 Socket client = new Socket("127.0.0.1", 20006);  
			client.setSoTimeout(10000);

	        PrintStream out = new PrintStream(client.getOutputStream());  
	        BufferedReader buf =  new BufferedReader(new InputStreamReader(client.getInputStream()));  
	        InputStream in = client.getInputStream();
	        boolean flag = true;  
	        
	        //**********��ʱ������****************
			
			boolean f1 = true;			
			int fileIndex = 0;		
			//************************************
			
			
        	PCV.perDetails = new ArrayList<>();
        	
        	
        	
	        while(flag){  
	
	            String str = "";
	            //�������ݵ������    
//	            out.println(str);  
	            if("end".equals(str)){  
	                flag = false;  
	                
	                out.print("end");
	            }
	            else{
	            	
//                    String echo = buf.readLine();  
	            	//**************�ӷ���˽����ַ�������****************
	            	if(f1){
	            		PCV.strPerDetails = buf.readLine();
	            		f1 = false;
	            		System.out.println("�ͻ��˽��ճɹ�:PCV.strPerDetails"+PCV.strPerDetails);
	            		out.println("goon");
	            	}
	            	
	            	//**************************************************
	            	
	            	
	            	//**************�ӷ���˽���ͼƬ����******************
	            	if(!f1){

		            	FileOutputStream fos = new FileOutputStream("server.png");
		        		byte[] bt = new byte[1024];
		        		int len = 0;
		        		//���ֽ�����дͼƬ����
		        		while ((len = in.read(bt)) != -1)
		        		{
		        			fos.write(bt,0,len);
		        		}
		        		
		        		out.println("goon");
	            	}
	            	
	            	
	            	//**************************************************
                    
	            }  
	        }  
	
	        if(client != null){  
	            
	            client.close(); 
	        }  
	        if(buf != null){
	        	
	        	buf.close();
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