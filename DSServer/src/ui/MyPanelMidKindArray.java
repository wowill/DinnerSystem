package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MyPanelMidKindArray extends JPanel{

	public MyPanelMidArray[] MPMA;		//�м��������
	public int kindNum;					//�����Ŀ������
	int everyKOL[];						//���ÿ����Ŀ��Ӧ�Ĳ˵���Ŀ
	public int curLabNo;				//��ǰѡ������б������
	

	public MyPanelMidKindArray() {
		
		init();
	}

	public void init() {
		kindNum = 8;
		//*************ģ���ʼ�� everyKOL[],��ʵ���ݴ��������޸�
		everyKOL = new int[kindNum];
		for(int i = 0; i < kindNum; i++){
			everyKOL[i] = (int) (i+1+(Math.random()*20));
		}
		//****************
		
		MPMA = new MyPanelMidArray[kindNum];
		setBackground(Color.WHITE);
		for(int i = 0; i < kindNum; i++){
			MPMA[i] = new MyPanelMidArray(everyKOL[i]);
		}
//		MPMA[0].setBackground(Color.WHITE);
		restLayouMidArr(0, this);
		updateUI();
	}
	
	public void restLayouMidArr(int index, JPanel rel){							//�����ఴť�л�ҳ�棬Ҫ���²���,srcҪ���ӵ�rel�����
		
		rel.add(MPMA[index]);
		
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