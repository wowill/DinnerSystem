package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MyPanelMidArray extends JPanel{
	
	public int panelNum;			//�м�����ÿһ����Ŀ���м�ҳMPM
	MyPanelMid[] MPM;				//�м�����ĵ��������		
	
	public MyPanelMidArray(int panelNum) {
		this.panelNum = panelNum;
		panelNum  = 1;
		MPM = new MyPanelMid[panelNum];
		init();
	}

	public  void init() {
		
		for(int i = 0; i < panelNum; i++){
			
			MPM[i] = new MyPanelMid();
		}
		MPM[0].setBackground(Color.ORANGE);
		restLayouMidArr(MPM[0], this);
		updateUI();
	}
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//����л�ҳ�水ť��Ҫ���²���,srcҪ��ӵ�rel�����
	
		//********��Ʋ��ַ�ʽ**********
		GridBagLayout gbLayout = new GridBagLayout();
		this.setLayout(gbLayout);
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		//***************************
		
//		s.gridwidth = 1;
//		s.gridheight = 1;
//		s.weightx = 0;
//		s.weighty = 0;
//		s.gridx = 0;
//		s.gridy = 0;
		gbLayout.setConstraints(src, s);
		
		rel.add(src);
	}
	
	public int getPanelNum() {
		return panelNum;
	}

	public void setPanelNum(int panelNum) {
		this.panelNum = panelNum;
	}
	
}
