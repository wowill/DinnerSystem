package ui;

import javax.swing.JPanel;

public class MyPanelMid extends JPanel{

	int MPP_HEIGHT;				//ÿһ���˶�Ӧ��panel�ĸ�
	int MPP_WIDTH;				//ÿһ���˶�Ӧ��panel�Ŀ�
	MyPanelPer[] MPP;			//ÿһ���˶�Ӧ��panel
	public int perAllNum;		//���ÿһ����Ŀ��Ӧ�Ĳ˵�����Ŀ

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
