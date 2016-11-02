package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MyPanelMidKindArray extends JPanel{

	MyPanelMidArray[] MPMA;				//�м��������
	public int kindNum;					//�����Ŀ������
	int everyKOL[];						//���ÿ����Ŀ��Ӧ�Ĳ˵���Ŀ
	

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
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//�����ఴť�л�ҳ�棬Ҫ���²���,srcҪ��ӵ�rel�����
		
		rel.add(src);
	}
	
	public int getKindNum() {
		return kindNum;
	}

	public void setKindNum(int kindNum) {
		this.kindNum = kindNum;
	}
}
