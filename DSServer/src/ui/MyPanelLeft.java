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

import data.DataProcess;
import data.PCV;
import data.ServerSocketProcess;

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
	public DataProcess DP;				//用来重新设置补给后的数据
	
	public MyPanelLeft(MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb, DataProcess DP) {
		
		this.midC = mpmka;
		this.midB = mpmb;
		this.DP = DP;
		init();
		
	}

	public void init() {
			
		selNo = 0;
		confimP = new ConfirmPanel(this);
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
		this.setBackground(Color.WHITE);
		initSelected();
		addCPAL();
		addLogoAL();
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
		s.ipady = 5;
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
			Lip[i].setForeground(new Color(50,50,50));
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
				Lip[i].lab.setForeground(new Color(50,50,50));
				try {
					Lip[i].imgLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/black.png"))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Lip[i].updateUI();
			}
			
		}
	}
	
	public void initSelected(){			//初始化默认选中的左侧列表的条目

		Lip[0].setBackground(new Color(176,190,197));
		Lip[0].lab.setForeground(Color.WHITE);
		
	}
	
	public void restSelect(){			//刷新后重新选定原先被选中的左侧列表条目
		
		Lip[PCV.curLabNo].setBackground(new Color(176,190,197));
		Lip[PCV.curLabNo].lab.setForeground(Color.WHITE);
	}
	
	public void addCPAL(){				//为确认更新面板添加点击事件
		confimP.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				confimP.setBackground(new Color(220, 0, 0));
				confimP.confLab.setForeground(Color.WHITE);
				int n = JOptionPane.showConfirmDialog(null, formatBuyMes(),"购物清单",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
				
				if(n == 0){
					DP.DAO.cAndSUP(buyLTS(), 0);
					afterFlushAP();						//重新刷新整个界面
				}
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
				confimP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public String buyLTS(){			//服务端补给的列表转换成字符串
		
		String str = "";
		for(int i = 0; i < PCV.buyList.size(); i++){
			
			str += PCV.buyList.get(i).trim() + ",";
		}
		return str;
	}
	
	public String formatBuyMes(){				//重新设置显示结算的信息
		
		double sum = 0;
		PCV.sendStrFC = "";
		StringBuilder sb = new StringBuilder();
		sb.append("补给商品"+"    "+"商品单价"+"    "+"补给数量"+PCV.SPLINE);

		for(int i = 0; i < PCV.buyList.size(); i++){
			String[] st = PCV.buyList.get(i).split(" ");
			int lId = Integer.parseInt(st[0]);			//对应左侧列表编号
			int pId = Integer.parseInt(st[1]);			//对应中间面板第几道菜
			int pNum = Integer.parseInt(st[2]);			//购买每道菜的数量
			
			String[] stt = PCV.perDetList.get(lId).get(pId).split(" ");
			String perName = stt[0];
			double perPrice = Double.parseDouble(stt[1]);
			
			
			int lenP = 5-(perPrice+"").length()+6;
//			System.out.println(lenP);
			sb.append(perName+"        "+"￥"+String.format("%-"+lenP+".2f", perPrice) + "" + String.format("%16d", pNum)+PCV.SPLINE);
			
			sum += pNum;
			PCV.sendStrFC += PCV.buyList.get(i).trim() + ",";
		}
		sb.append("合计数量："+"                           "+""+String.format("%.0f", sum)+PCV.SPLINE);
		PCV.sendStrFC = PCV.sendStrFC.trim();
		return sb.toString();
		
	}
	
	
	public void afterFlushAP(){				//发送后刷新，重新刷新整个界面的各个组件
		PCV.buyList = new ArrayList<>();
		DP.init();
		//*********更新左侧列表面板********
		this.removeAll();
		this.dataReceive();
		this.restSelect();
		this.updateUI();
		//********************************
		
		//**********更新中间面板**********
		midC.removeAll();
		midC.reInit(PCV.curLabNo);
		midC.MPMA[PCV.curLabNo].removeAll();
		midC.MPMA[PCV.curLabNo].indexArr = PCV.curMPNo;
		midC.MPMA[PCV.curLabNo].restLayoutMAOI(PCV.curMPNo);		//重新设置选中的中间面板	
		
		//*******************************
		
		PCV.buyList = new ArrayList<>();
//		frame.repaint();
	}
	
	public void flushAPS(){					//刷新整个界面的各个组件
		
		DP.init();
		//*********更新左侧列表面板********
		this.removeAll();
		this.dataReceive();
		this.restSelect();
		this.updateUI();
		//********************************
		
		//**********更新中间面板**********
		midC.removeAll();
		midC.reInit(PCV.curLabNo);
		midC.MPMA[PCV.curLabNo].restLayoutMAOI(0);		//点击坐上logo刷新，重新设置选中的中间面板	
		
		//*******************************
		
		//*********更新下方面板***********
		midB.setCurPage(1);
		midB.setLabelText();
		midB.updateUI();
		//*******************************
		

//		frame.repaint();
	}
	
	public void addLogoAL(){			//为左上角添加点击事件
		
		ltp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				flushAPS();
				restBuyMes();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ltp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2){			//双击，清空购物列表，并刷新数据
					PCV.buyList = new ArrayList<>();
					flushAPS();	
				}
			}
		});
	}
	
	public void restBuyMes(){			//恢复购物信息
		
		for(int i = 0; i < PCV.buyList.size(); i++){
			String sa[] = PCV.buyList.get(i).split(" ");
			midC.MPMA[Integer.parseInt(sa[0])].MPM[Integer.parseInt(sa[3])].MPP[Integer.parseInt(sa[1])].p.showNum.setText(sa[2]);
			midC.MPMA[Integer.parseInt(sa[0])].MPM[Integer.parseInt(sa[3])].MPP[Integer.parseInt(sa[1])].p.updateUI();
		}
	}

	
}

class ConfirmPanel extends JPanel{
	
	JLabel confLab;
	MyPanelLeft mpl;
	public ConfirmPanel(MyPanelLeft mpl) {
		
		this.setBackground(Color.WHITE);
		this.mpl = mpl;
		confLab = new JLabel("   确认更新");
		try {
			confLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/shoppingCar.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
}
