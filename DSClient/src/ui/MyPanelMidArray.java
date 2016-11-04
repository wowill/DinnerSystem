package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MyPanelMidArray extends JPanel{
	
	public int panelNum;			//�м�����ÿһ����Ŀ���м�ҳMPM
	public MyPanelMid[] MPM;		//�м�����ĵ��������		
	public int itemAllNum;			//���ÿһ����Ŀ��Ӧ�Ĳ˵�����Ŀ
	public int[] evePaneNum;		//ÿһҳ��ŵĲ˵���Ŀ
	public int indexArr;			//�м���ʾ���ݵ����������±�
	public int curAllPN;			//��ǰѡ������б�ĺ����м�������Ŀ
	public int curLabNo;				//��ǰѡ������б�����
	
	public MyPanelMidArray(int itemAllNum, int curLabNo) {
		
		this.curLabNo = curLabNo;
		this.itemAllNum = itemAllNum;
		this.panelNum = itemAllNum / 9;
		if(itemAllNum - this.panelNum * 9 > 0){
			this.panelNum += 1;
		}
		
		this.evePaneNum = new int[panelNum];
		MPM = new MyPanelMid[this.panelNum];
		initEve();
		init();
	}

	public  void init() {
		indexArr = 0;
		for(int i = 0; i < panelNum; i++){
			
			MPM[i] = new MyPanelMid(evePaneNum[i], curLabNo);
		}
		MPM[0].setBackground(Color.WHITE);
		restLayouMidArr(MPM[0], this);
		updateUI();
	}
	
	public void initEve(){				//��ʼ��ÿҳ��ŵĲ˵���Ŀ�����
		
		int tempAN = itemAllNum;
		int tempPN = panelNum;
		
		if(tempAN / 9 == 0){
			evePaneNum[0] = tempAN % 9;
			return ;
		}
		for(int i = 0; i < tempPN; i++){
			
			if(tempAN - 9 > 0){
				evePaneNum[i] = 9;
				tempAN -= 9;
			}
			else{
				evePaneNum[i] = tempAN;
			}
		}
		
	}
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//����л�ҳ�水ť��Ҫ���²���,srcҪ��ӵ�rel�����
	
//		//********��Ʋ��ַ�ʽ**********
//		GridBagLayout gbLayout = new GridBagLayout();
//		this.setLayout(gbLayout);
//		GridBagConstraints s = new GridBagConstraints();
//		s.fill = GridBagConstraints.BOTH;
//		//***************************
//		
//		s.gridwidth = 1;
//		s.gridheight = 1;
//		s.weightx = 0;
//		s.weighty = 0;
//		s.gridx = 0;
//		s.gridy = 0;
//		gbLayout.setConstraints(src, s);
//		
//		rel.removeAll();
		rel.add(src);
//		rel.updateUI();
	}
	
	public int getPanelNum() {
		return panelNum;
	}

	public void setPanelNum(int panelNum) {
		this.panelNum = panelNum;
	}
	
}
