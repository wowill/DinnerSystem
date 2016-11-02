package ui;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public void MyFrame() {
		
		init();
	}
	
	public void init(){			//主窗口初始化函数
		
		setSize(300, 300);
		
		setTitle("点餐系统客户端");
		setVisible(true);
	}
	
	
}
