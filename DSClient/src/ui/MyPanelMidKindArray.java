package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MyPanelMidKindArray extends JPanel{

	MyPanelMidArray[] MPMA;				//中间面板数组
	public int kindNum;					//左侧条目的数量
	int everyKOL[];						//左侧每个条目对应的菜的数目
	

	public MyPanelMidKindArray() {
		
		init();
	}

	public void init() {
		
		kindNum = 1;
		MPMA = new MyPanelMidArray[kindNum];
		everyKOL = new int[10];
		setBackground(Color.CYAN);
		for(int i = 0; i < kindNum; i++){
			MPMA[i] = new MyPanelMidArray(everyKOL[i]);
		}
		MPMA[0].setBackground(Color.cyan);
		restLayouMidArr(MPMA[0], this);
		updateUI();
	}
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//点击左侧按钮切换页面，要重新布局,src要添加到rel面板中
		
		rel.add(src);
	}
	
	public int getKindNum() {
		return kindNum;
	}

	public void setKindNum(int kindNum) {
		this.kindNum = kindNum;
	}
}
