package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.PCV;

public class MyPanelMid extends JPanel{

	int MPP_HEIGHT = 190;		//每一道菜对应的panel的高
	int MPP_WIDTH = 160;		//每一道菜对应的panel的宽
	MyPanelPer[] MPP;			//每一道菜对应的panel
	public int perAllNum;		//左侧每一个条目对应的菜的总数目
	public int perItemLeave;	//左侧每一个条目对应的每一个菜的剩余剩余数量
	public double perItemPrice;	//左侧每一个条目对应的没一个菜的价格
	GridBagLayout gbLayout;		//设计布局方式
	GridBagConstraints s;		//设计布局方式
	public int curLabNo;		//当前选中左侧列表的序号
	
	public MyPanelMid(int perAllNum, int curLabNo) {
		
		this.curLabNo = curLabNo;
		this.perAllNum = perAllNum;
		MPP = new MyPanelPer[perAllNum];
		init();
	}

	public void init() {
		
		setBackground(Color.WHITE);
		//********设计布局方式**********
		gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		s = new GridBagConstraints();
		//***************************
		
		//***********将每个列表对应条目的每个菜的信息存到一个list***********
		ArrayList<String> list;
		list = PCV.perDetList.get(curLabNo);
		
		//****************************************************************
		
		
		for(int i = 0; i < perAllNum; i++){
			
			MPP[i] = new MyPanelPer(list, i);
			restLayouMidArr(MPP[i], this, i);
		}
		
	}
	
	
	public void restLayouMidArr(JPanel src, JPanel rel, int i){							//点击切换页面按钮，要重新布局,src要添加到rel面板中
		
		s.ipadx = 15;
		s.ipady = 5;
		s.gridx = i % 3;
		s.gridy = i / 3;
		s.gridwidth = 1;
		s.gridheight = 1;
		s.weightx = 1;
		s.weighty = 1;
		if(i % 3 == 2){
			s.weightx = 0;
		}
		if(i >= 5 && i <= 8){
			s.weighty = 0;
		}
		gbLayout.setConstraints(src, s);
		
		rel.add(src);
	}
	
	public int getPerAllNum() {
		return perAllNum;
	}

	public void setPerAllNum(int perAllNum) {
		this.perAllNum = perAllNum;
	}

}
