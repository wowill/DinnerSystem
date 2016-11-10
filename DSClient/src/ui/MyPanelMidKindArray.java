package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import data.PCV;

public class MyPanelMidKindArray extends JPanel{

	public MyPanelMidArray[] MPMA;		//中间面板数组
	public int kindNum;					//左侧条目的数量
	int everyKOL[];						//左侧每个条目对应的菜的数目
	public int curLabNo;				//当前选中左侧列表的序号
	public MyPanelMidBottom midB;		//下侧面板，主要用来实时更新已购物品价格

	public MyPanelMidKindArray(MyPanelMidBottom midB) {
		
		this.midB = midB;
		init();
	}

	public void init() {
		kindNum = PCV.AllItemLeft;
		//*************模拟初始化 everyKOL[],真实数据传入再做修改
		everyKOL = new int[kindNum];
		System.out.println(kindNum);
		for(int i = 0; i < kindNum; i++){
			everyKOL[i] = PCV.leftItemOfDN.get(i);
		}
		//****************
		
		MPMA = new MyPanelMidArray[kindNum];
		setBackground(Color.WHITE);
		for(int i = 0; i < kindNum; i++){
			MPMA[i] = new MyPanelMidArray(everyKOL[i], i,midB);
		}
//		MPMA[0].setBackground(Color.WHITE);
		restLayouMidArr(0, this);
		
	}
	
	
	
	public void restLayouMidArr(int index, JPanel rel){							//点击左侧按钮切换页面，要重新布局,src要添加到rel面板中
		
		rel.add(MPMA[index]);
		updateUI();
	}
	
	public void reInit(int curLabNo) {
		kindNum = PCV.AllItemLeft;
		//*************模拟初始化 everyKOL[],真实数据传入再做修改
		everyKOL = new int[kindNum];
		System.out.println(kindNum);
		for(int i = 0; i < kindNum; i++){
			everyKOL[i] = PCV.leftItemOfDN.get(i);
		}
		//****************
		
		MPMA = new MyPanelMidArray[kindNum];
		setBackground(Color.WHITE);
		for(int i = 0; i < kindNum; i++){
			MPMA[i] = new MyPanelMidArray(everyKOL[i], i,midB);
		}
//		MPMA[0].setBackground(Color.WHITE);
		restLayouMidArr(curLabNo, this);
	}
	
	public int getKindNum() {
		return kindNum;
	}

	public void setKindNum(int kindNum) {
		this.kindNum = kindNum;
	}
	
	public MyPanelMidArray[] getMPMA() {
		return MPMA;
	}

	public void setMPMA(MyPanelMidArray[] mPMA) {
		MPMA = mPMA;
	}
	
	public int getCurLabNo() {
		return curLabNo;
	}

	public void setCurLabNo(int curLabNo) {
		this.curLabNo = curLabNo;
	}

	
}
