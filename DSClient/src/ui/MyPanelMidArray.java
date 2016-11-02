package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MyPanelMidArray extends JPanel{
	
	public int panelNum;			//中间区域每一种的面板数目
	MyPanelMid[] MPM;				//中间区域的的面板数组		
	
	public MyPanelMidArray() {
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
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//点击切换页面按钮，要重新布局,src要添加到rel面板中
	
		//********设计布局方式**********
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
	
	public int getPanelNum() {
		return panelNum;
	}

	public void setPanelNum(int panelNum) {
		this.panelNum = panelNum;
	}
	
}
