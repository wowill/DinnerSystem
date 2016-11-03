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

	public int curLabNo;				//当前选中左侧列表的序号
	public LeftItemPanel[] Lip;			//左边列表按钮数组
	public JLabel[] labA;				//左边列表按钮名称标签数组
	public boolean haveRecL = false;	//判断是否需要刷新左边列表
	public ArrayList<String> recLL;		//接收服务端的
	public JPanel spcePanel;			//空白面板用于填充
	public MyPanelMidKindArray midC;	//盛放中间面板的面板容器
	public MyPanelMidBottom midB;		//盛放下方面板的面板容器
	public int selNo;					//被选中的条目编号
	GridBagLayout gbLayout;				//设置布局方式
	GridBagConstraints s;				//设置布局方式
	
	public MyPanelLeft(MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb) {
		this.midC = mpmka;
		this.midB = mpmb;
		init();
		
	}

	public void init() {
			
		selNo = 0;
		
		//************设置布局方式*****************
		gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		//****************************************

		haveRecL = true;			//暂时将判断条件设为true
		checkFlushL();
		setBackground(Color.WHITE);
		initSelected();
	}
	
	public void checkFlushL(){
		
		if(haveRecL){
			dataReceive();
			flushdata();
		}
	}
	
	public void dataReceive(){			//从服务端获得左边列表的数据
		
		recLL = new ArrayList<>();
		spcePanel = new JPanel();
		
		for(int i = 0; i < 8; i++){
			
			recLL.add("测试菜单 "+(i+1));
		}

		Lip = new LeftItemPanel[recLL.size()];
		
		for(int i = 0; i < recLL.size(); i++){
			
			Lip[i] = new LeftItemPanel(recLL.get(i), i, midC, midB, this);
			Lip[i].setBackground(new Color(255, 255, 255));
			Lip[i].setForeground(new Color(50, 50, 50));
			s.fill = GridBagConstraints.HORIZONTAL;
			s.gridx = 0;
			s.gridy = i;
			s.ipadx = 10;
			s.ipady = 10;
			s.weightx = 1;
			s.weighty = 0;
			s.gridwidth = 1;
			s.gridheight = 1;
			add(Lip[i], s);
		}
//		s.fill = GridBagConstraints.BOTH;
//		s.gridx = 0;
//		s.gridy = recLL.size();
//		s.ipadx = 10;
//		s.ipady = 10;
//		s.weightx = 1;
//		s.weighty = 0;
//		s.gridwidth = 0;
//		s.gridheight = 10;
//		add(spcePanel, s);
	}
	
	public void flushdata(){			//刷新左侧列表数据
		
		updateUI();
	}
	
	public int getCurLabNo() {
		return curLabNo;
	}

	public void setCurLabNo(int curLabNo) {
		this.curLabNo = curLabNo;
	}

	public void flushColor(){			//刷新左侧列表的颜色

		for(int i = 0; i < recLL.size(); i++){
			if(i != selNo){
				Lip[i].setBackground(new Color(255, 255, 255));
				Lip[i].lab.setForeground(new Color(50, 50, 50));
				Lip[i].updateUI();
			}
			
		}
	}
	
	public void initSelected(){			//初始化默认选中的左侧列表的条目

		Lip[0].setBackground(new Color(50, 50, 50));
		Lip[0].lab.setForeground(Color.WHITE);
		
	}
}
