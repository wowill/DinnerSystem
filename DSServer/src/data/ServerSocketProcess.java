package data;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketProcess {

	public ServerSocket server;
	public Socket client;
	public ServerSocketProcess() {
		
		init();
	}

	public void init() {
		
		try {
			server = new ServerSocket(8979);
			client = server.accept();
			
			System.out.println("与客户端连接成功！");
			new Thread(new ServerSocketThread(client)).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
