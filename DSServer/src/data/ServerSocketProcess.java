package data;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLData;

import ui.MyPanelLeft;
import ui.MyPanelMidBottom;
import ui.MyPanelMidKindArray;

public class ServerSocketProcess {

	public ServerSocket server;
	public Socket client;
	public DataProcess DP;
	public MyPanelLeft mpl;
	
	public ServerSocketProcess(MyPanelLeft mpl,DataProcess DP) {
		
		this.mpl = mpl;
		this.DP = DP;
		init();
	}

	public void init() {
		
		try {
			server = new ServerSocket(8979);
			
			boolean flag = true;
			while(flag){
				
				client = server.accept();
				System.out.println("与客户端连接成功！");
				new Thread(new ServerSocketThread(mpl,client, DP)).start();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
