package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MyPanelMidKindArray extends JPanel{

	MyPanelMidArray[] MPMA;				//�м��������
	public int kindNum;					//�����Ŀ������
	
	

	public MyPanelMidKindArray() {
		kindNum = 1;
		MPMA = new MyPanelMidArray[kindNum];
		init();
	}

	public void init() {
		
		for(int i = 0; i < kindNum; i++){
			MPMA[i] = new MyPanelMidArray();
		}
		MPMA[0].setBackground(Color.cyan);
		restLayouMidArr(MPMA[0], this);
		updateUI();
	}
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//����л�ҳ�水ť��Ҫ���²���,srcҪ��ӵ�rel�����
	
		//********��Ʋ��ַ�ʽ**********
		GridBagLayout gbLayout = new GridBagLayout();
		this.setLayout(gbLayout);
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		//***************************
		
		s.gridwidth = 1;
		s.gridheight = 1;
		s.weightx = 1;
		s.weighty = 1;
		gbLayout.setConstraints(src, s);
		
		rel.add(src);
		
		
	}
	
	public int getKindNum() {
		return kindNum;
	}

	public void setKindNum(int kindNum) {
		this.kindNum = kindNum;
	}
}
