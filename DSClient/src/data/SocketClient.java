package data;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
import javax.swing.JOptionPane;

public class SocketClient {

	public DataProcess DP;
	
	public SocketClient() {
		
		DP = new DataProcess();
		
		init();
	}
	
	public DataProcess retDP(){
		return this.DP;
	}
	
	public void updataData(){			//发送给服务端确认购买的数据，并接受服务端返回的数据					
		PCV.buyList = new ArrayList<>();
		try{
	    	Socket client = new Socket(PCV.remoteAddr, 8979);  
			client.setSoTimeout(10000);
	
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
	        DataInputStream dis = new DataInputStream(is);
	        
	        dos.writeUTF("UpdateData");				//客户端发送给服务端接收字符串数据的提示消息
        	dos.writeUTF(PCV.sendStrFC);
	        
        	PCV.recvStat = dis.readUTF();
        	if(PCV.recvStat.equals("T")){
        		recvData(dis, dos);					//用封装函数接收从服务端返回的字符串数据和图片数据
        		int n = JOptionPane.showConfirmDialog(null, "小二正在上菜啦，请稍等...","提交成功",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE);
        	}
        	else{
        		int n = JOptionPane.showConfirmDialog(null, "货源不足！","提交失败",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE);
        	}
	        
        	PCV.buyList = new ArrayList<>();
	        
		}catch(IOException ex){
			
		}
	}
	
    public void init() {  				
       
        try {
        	
        	
        	Socket client = new Socket(PCV.remoteAddr, 8979);  
			client.setSoTimeout(10000);

			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
	        DataInputStream dis = new DataInputStream(is);
	        boolean flag = true;  
	        
	        //**********临时变量区****************
			
			boolean f1 = true;			
			int fileIndex = 0;		
			boolean f2 = true;
			//************************************
			
			
        	PCV.perDetails = new ArrayList<>();
        	
        	
        	dos.writeUTF("String");				//客户端发送给服务端接收字符串数据的提示消息
        	recvData(dis, dos);					//用封装函数接收从服务端返回的字符串数据和图片数据
        	
        	
	        if(client != null){  
	            
	            client.close(); 
	        }  
	        if(dos != null){
	        	
	        	dos.close();
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
    
    public void recvData(DataInputStream dis, DataOutputStream dos) throws IOException{			//接收从服务端返回的数据
    	//**************从服务端接收字符串数据****************
    	
		
    	PCV.strPerDetails = dis.readUTF();
		
//		System.out.println("客户端接收成功:PCV.strPerDetails"+PCV.strPerDetails);
//		System.out.println("字符串数据接收成功");

    	//**************************************************
    	
		//**********根据传来的字符串数据初始化客户端的数据**************
		DP.dataToDiv();
		//************************************************************
		
		
//		out.println("Image");				//客户端发送给服务端接收图片数据的提示消息
		//**************从服务端接收图片数据******************
//		for(int i = 0; i < PCV.imgPath.size(); i++){
//			System.out.println(PCV.imgPath.get(i));
//		}
//		System.out.println("***************");
		for(int i = 0; i < PCV.imgPath.size(); i++){
//			System.out.println(PCV.imgPath.get(i));
			
			FileOutputStream fos = new FileOutputStream(new File(PCV.imgPath.get(i)));
			byte[] bt = new byte[1024];
    		int len = 0;
    		int k = 0;
    		long picLeng = dis.readLong();
//    		System.out.println(picLeng + "*****************");
    		while (picLeng > 0
                    && (len = dis.read(bt, 0,
                    picLeng < bt.length ? (int) picLeng
                            : bt.length)) != -1)			
    		{
    			k++;
    			if((new String(bt, 0, len)).contains("IEND")){
//    				System.out.println("keb "+len);
//    				System.out.println("next+++++++****************************"+ new String(bt, 0, len));
    				fos.write(bt,0,len);			
    				picLeng -= len;
//    				System.out.println("len " + len+"          ||           " +picLeng);
    				fos.flush();
    				fos.close();
    				break;
    			}
				
				fos.write(bt,0,len);			
				picLeng -= len;
//				System.out.println("len " + len+"          ||           " +picLeng);
    		}
    		
    		System.out.println();
    		fos.flush();
		}
			
		//**************************************************
    }
}  