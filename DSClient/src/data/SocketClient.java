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
	        
	        //**********临时变量区****************
			
			boolean f1 = true;			
			int fileIndex = 0;		
			boolean f2 = true;
			//************************************
			
			
        	PCV.perDetails = new ArrayList<>();
        	
        	
        	out.println("String");				//客户端发送给服务端接收字符串数据的提示消息
        	
        	//**************从服务端接收字符串数据****************
        	
    		PCV.strPerDetails = buf.readLine();
    		System.out.println("客户端接收成功:PCV.strPerDetails"+PCV.strPerDetails);
    		System.out.println("字符串数据接收成功");

        	//**************************************************
        	
    		//**********根据传来的字符串数据初始化客户端的数据**************
    		DP.dataToDiv();
    		//************************************************************
    		
    		
//    		out.println("Image");				//客户端发送给服务端接收图片数据的提示消息
    		//**************从服务端接收图片数据******************
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
    				fos.write(bt,0,len);			//把接收的字节流写入图片
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