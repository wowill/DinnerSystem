package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

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
	        boolean flag = true;  
	        while(flag){  
	
	            String str = "";
	            //�������ݵ������    
//	            out.println(str);  
	            if("end".equals(str)){  
	                flag = false;  
	            }else{  
	            	//�ӷ���˽�������
                    String echo = buf.readLine();  
                    System.out.println(echo);  
                    
	            }  
	        }  
	
	        if(client != null){  
	            
	            client.close(); 
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