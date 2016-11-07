package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.PCV;
import data.SocketClient;


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
	public ConfirmPanel confimP;		//确认购买面板
	public LeftTop ltp;					//左上角logo面板
	GridBagLayout gbLayout;				//设置布局方式
	GridBagConstraints s;				//设置布局方式
	SocketClient client;				//主要用于发送数据
	
	public MyPanelLeft(MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb, SocketClient client) {
		this.midC = mpmka;
		this.midB = mpmb;
		this.client = client;
		init();
		
	}

	public void init() {
			
		selNo = 0;
		confimP = new ConfirmPanel();
		ltp = new LeftTop();
		confimP.setBackground(new Color(150, 20, 20));
		confimP.confLab.setForeground(Color.WHITE);
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
		addCPAL();
	}
	
	public void checkFlushL(){
		
		if(haveRecL){
			dataReceive();
			flushdata();
		}
	}
	
	
	public void dataReceive(){			//把从数据库获得左边列表的数据，更新到界面上
		
		spcePanel = new JPanel();
		recLL = PCV.leftItemString;
		
		s.fill = GridBagConstraints.NORTH;
		s.gridx = 0;
		s.gridy = 0;
		s.ipadx = 0;
		s.ipady = 0;
		s.weightx = 0;
		s.weighty = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
		ltp.setBackground(Color.WHITE);
		add(ltp, s);
		
		Lip = new LeftItemPanel[recLL.size()];
		
		for(int i = 0; i < recLL.size(); i++){
			
			Lip[i] = new LeftItemPanel(recLL.get(i), i, midC, midB, this);
			Lip[i].setBackground(new Color(255, 255, 255));
			Lip[i].setForeground(new Color(50, 50, 50));
			s.fill = GridBagConstraints.HORIZONTAL;
			s.gridx = 0;
			s.gridy = i+1;
			s.ipadx = 10;
			s.ipady = 10;
			s.weightx = 1;
			s.weighty = 0;
			s.gridwidth = 1;
			s.gridheight = 1;
			add(Lip[i], s);
		}
		s.fill = GridBagConstraints.HORIZONTAL;
		s.gridx = 0;
		s.gridy = recLL.size()+1;
		s.ipadx = 10;
		s.ipady = 220;
		s.weightx = 1;
		s.weighty = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
		spcePanel.setBackground(Color.WHITE);
		add(spcePanel, s);
		
		s.fill = GridBagConstraints.HORIZONTAL;
		s.gridx = 0;
		s.gridy = recLL.size()+2;
		s.ipadx = 10;
		s.ipady = 10;
		s.weightx = 1;
		s.weighty = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
		add(confimP, s);
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
	public void addCPAL(){
		confimP.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				confimP.setBackground(new Color(150, 0, 20));
				confimP.confLab.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				confimP.setBackground(new Color(220, 0, 0));
				confimP.confLab.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				confimP.setBackground(new Color(220, 0, 0));
				confimP.confLab.setForeground(Color.WHITE);
				int n = JOptionPane.showConfirmDialog(null, PCV.buyList.toString());
				
				if(n == 0){
					client.updataData();
				}
			}
		});
	}
	
	public void flushAP(){				//从服务端接收完数据，需要重新刷新整个界面
		
		
		
	}
}

class ConfirmPanel extends JPanel{
	
	JLabel confLab;
	public ConfirmPanel() {
		
		confLab = new JLabel("确认更新");
		confLab.setFont(new Font("微软雅黑", 1, 15));
		this.add(confLab);
	}
	
}

class LeftTop extends JPanel{
	
	JLabel imgLab;
	public LeftTop() {
		
		init();
	}
	public void init() {
		
		imgLab = new JLabel();
		try {
			ImageIcon img = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/leftTop.png")));
			imgLab.setIcon(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(imgLab);
	}
	public void addLogoAL(){			//为左上角添加点击事件
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
