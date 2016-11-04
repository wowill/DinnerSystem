package ui;

import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.DataProcess;
import data.ServerSocketProcess;

public class MyFrame extends JFrame{
	int FRAME_WIDTH = 900;
	int FRAME_HEIGHT = 700;
	
	int LP_WIDTH = 10;
	int MPMA_WIDTH = 660;
	int MPMA_HEIGHT = 600;
	int MPMB_WIDTH = 660;
	int MPMB_HEIGHT = 50;
	
	DataProcess DP;
	MyPanelLeft MPL;
	MyPanelMidBottom MPMB;
	MyPanelMidKindArray MPMKA;
	ServerSocketProcess server;
	
	
	
	public MyFrame() {
		
		DP = new DataProcess();
		MPMB = new MyPanelMidBottom();
		MPMKA = new MyPanelMidKindArray();
		MPL = new MyPanelLeft(MPMKA, MPMB);
		init();
		initBottomIndex();
		AddBtnNextListener();
		AddBtnFrontListener();
		server = new ServerSocketProcess();
	}

	public void init() {
		
		System.out.println(this.getClass());
		//************窗口居中*******************
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		int w = rect.width;
		int h = rect.height;
		this.setBounds((w - FRAME_WIDTH) / 2, (h - FRAME_HEIGHT) / 2, FRAME_WIDTH, FRAME_HEIGHT);
		//**************************************
//		setResizable(false);
		setTitle("Ordering   服务端");
		try {
			this.setIconImage(ImageIO.read(this.getClass().getResource("/image/dinner.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//************设置布局方式*****************
		GridBagLayout gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		//****************************************
		
		this.add(MPL);
		this.add(MPMB);
		this.add(MPMKA);
		
		GridBagConstraints s = new GridBagConstraints();
		//s.fill = GridBagConstraints.BOTH; // 是用来控制添加进的组件的显示位置
											// 该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
											// NONE：不调整组件大小。
											// HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
											// VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
											// BOTH：使组件完全填满其显示区域。
		
		// ************设置左边区域布局***************
		s.fill = GridBagConstraints.VERTICAL;
		s.ipadx = LP_WIDTH;
		s.gridx = 0;
		s.gridy = 0;
		s.gridwidth = 1;
		s.gridheight = 2;
//		s.weightx = 0;
//		s.gridheight = 0;
//		s.weighty = 0;
//		s.weightx = 0;
		add(MPL, s);
		gbLayout.setConstraints(MPL, s);
		// *************************************
		
		// ************设置中间区域布局***************
		s.fill = GridBagConstraints.BOTH;
//		s.ipadx = MPMA_WIDTH;
//		s.ipady = MPMA_HEIGHT;
		s.gridx = 1;
		s.gridy = 0;
		s.gridheight = 1;
		s.gridwidth = 0;
		s.weightx = 0.5;
		s.weighty = 0.95;
		add(MPMKA, s);
		gbLayout.setConstraints(MPMKA, s);
		// *************************************
		
		// ************设置中下区域布局***************
		s.fill = GridBagConstraints.HORIZONTAL;
//		s.ipadx = MPMB_WIDTH;
//		s.ipady = MPMB_HEIGHT;
		s.gridx = 1;
		s.gridy = 1;
		s.gridheight = 1;
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0.05;
		add(MPMB, s);
		gbLayout.setConstraints(MPMB, s);
		// *************************************
		
	}
	
	public void AddBtnNextListener(){							//为下一个按钮添加事件
		MPMB.nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyPanelMidArray tempP = MPMKA.MPMA[MPMKA.curLabNo];
				
				if(tempP.indexArr+1 < tempP.panelNum)
				{
					System.out.println(MPMKA.curLabNo+"  ||  "+tempP.indexArr + "   " +tempP.panelNum);
					tempP.indexArr++;
					tempP.removeAll();
					MPMKA.removeAll();
					tempP.restLayouMidArr(tempP.MPM[tempP.indexArr], tempP);
					MPMKA.restLayouMidArr(MPMKA.curLabNo, MPMKA);
					tempP.updateUI();
					MPMKA.updateUI();
					MPMB.setAllPageNum(tempP.getPanelNum());
					MPMB.setCurPage(tempP.indexArr+1);
					MPMB.setLabelText();
					MPMB.updateUI();
				}
				else
					System.out.println("这是最后一页");
				
			}
		});
	}
	

	public void AddBtnFrontListener(){							//为上一个按钮添加事件
		MPMB.frontBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyPanelMidArray tempP = MPMKA.MPMA[MPMKA.getCurLabNo()];
				if(tempP.indexArr-1 >= 0)
				{
					tempP.indexArr--;
					tempP.removeAll();
					MPMKA.removeAll();
					tempP.restLayouMidArr(tempP.MPM[tempP.indexArr], tempP);
					MPMKA.restLayouMidArr(MPMKA.curLabNo, MPMKA);
					tempP.updateUI();
					MPMKA.updateUI();
					MPMB.setAllPageNum(tempP.getPanelNum());
					MPMB.setCurPage(tempP.indexArr+1);
					MPMB.setLabelText();
					MPMB.updateUI();
				}
				else
					System.out.println("这是第一页");
				
			}
		});
	}
	
	public void initBottomIndex(){			//初始化底部面板的页码标签
		
		MPMB.setCurPage(1);
		MPMB.setAllPageNum(MPMKA.MPMA[0].panelNum);
		MPMB.setLabelText();
		MPMB.updateUI();
	}
	
}
