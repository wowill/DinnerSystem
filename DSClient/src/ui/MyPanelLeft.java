package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelLeft extends JPanel{

	public JButton[] btnA;				//左边列表按钮数组
	public JLabel[] labA;				//左边列表按钮名称标签数组
	public boolean haveRecL = false;	//判断是否需要刷新左边列表
	public ArrayList<String> recLL;		//接收服务端的
	GridBagLayout gbLayout;				//设置布局方式
	GridBagConstraints s;				//设置布局方式
	
	public MyPanelLeft() {
		
		init();
	}

	public void init() {
			
		//************设置布局方式*****************
		gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		s = new GridBagConstraints();
		
		//****************************************

		haveRecL = true;			//暂时将判断条件设为true
		checkFlushL();
		setBackground(Color.red);
	}
	
	public void checkFlushL(){
		
		if(haveRecL){
			dataReceive();
			flushdata();
		}
	}
	
	public void dataReceive(){			//从服务端获得左边列表的数据
		
		recLL = new ArrayList<>();
		
		for(int i = 0; i < 10; i++){
			
			recLL.add("测试菜单 "+i);
		}

		btnA = new JButton[recLL.size()];
		
		for(int i = 0; i < recLL.size(); i++){
			
			btnA[i] = new JButton();
			btnA[i].setText(recLL.get(i));
			btnA[i].setFont(new Font("微软雅黑", 1, 14));
			s.fill = GridBagConstraints.HORIZONTAL;
			s.gridx = 0;
			s.gridy = i;
			s.ipadx = 10;
			s.ipady = 10;
			s.weightx = 1;
			s.gridwidth = 1;
			s.gridheight = 1;
			add(btnA[i], s);
		}
	}
	
	public void flushdata(){			//刷新左侧列表数据
		
		updateUI();
	}
	
}
