package ui;

import javax.swing.JPanel;

public class MyPanelMid extends JPanel{

	int MPP_HEIGHT;				//每一道菜对应的panel的高
	int MPP_WIDTH;				//每一道菜对应的panel的宽
	MyPanelPer[] MPP;			//每一道菜对应的panel
	public int perAllNum;		//左侧每一个条目对应的菜的总数目

	public MyPanelMid() {
		
		MPP = new MyPanelPer[perAllNum];
		init();
	}

	public void init() {
		
		
	}
	
	public int getPerAllNum() {
		return perAllNum;
	}

	public void setPerAllNum(int perAllNum) {
		this.perAllNum = perAllNum;
	}

}
