package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import data.PCV;

public class MyPanelMidKindArray extends JPanel{

	public MyPanelMidArray[] MPMA;		//�м��������
	public int kindNum;					//�����Ŀ������
	int everyKOL[];						//���ÿ����Ŀ��Ӧ�Ĳ˵���Ŀ
	public int curLabNo;				//��ǰѡ������б�����
	public MyPanelMidBottom midB;		//�²���壬��Ҫ����ʵʱ�����ѹ���Ʒ�۸�

	public MyPanelMidKindArray(MyPanelMidBottom midB) {
		
		this.midB = midB;
		init();
	}

	public void init() {
		kindNum = PCV.AllItemLeft;
		//*************ģ���ʼ�� everyKOL[],��ʵ���ݴ��������޸�
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
	
	
	
	public void restLayouMidArr(int index, JPanel rel){							//�����ఴť�л�ҳ�棬Ҫ���²���,srcҪ��ӵ�rel�����
		
		rel.add(MPMA[index]);
		updateUI();
	}
	
	public void reInit(int curLabNo) {
		kindNum = PCV.AllItemLeft;
		//*************ģ���ʼ�� everyKOL[],��ʵ���ݴ��������޸�
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
