package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelMid extends JPanel{

	int MPP_HEIGHT = 190;		//ÿһ���˶�Ӧ��panel�ĸ�
	int MPP_WIDTH = 160;		//ÿһ���˶�Ӧ��panel�Ŀ�
	MyPanelPer[] MPP;			//ÿһ���˶�Ӧ��panel
	public int perAllNum;		//���ÿһ����Ŀ��Ӧ�Ĳ˵�����Ŀ
	public int perItemLeave;	//���ÿһ����Ŀ��Ӧ��ÿһ���˵�ʣ��ʣ������
	public double perItemPrice;	//���ÿһ����Ŀ��Ӧ��ûһ���˵ļ۸�
	GridBagLayout gbLayout;		//��Ʋ��ַ�ʽ
	GridBagConstraints s;		//��Ʋ��ַ�ʽ
	
	public MyPanelMid() {
		perAllNum = 9;
		MPP = new MyPanelPer[perAllNum];
		init();
	}

	public void init() {
		
		//********��Ʋ��ַ�ʽ**********
		gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		s = new GridBagConstraints();
		//***************************
		
		
		for(int i = 0; i < perAllNum; i++){
			
			MPP[i] = new MyPanelPer();
			restLayouMidArr(MPP[i], this, i);
		}
		
	}
	
	
	public void restLayouMidArr(JPanel src, JPanel rel, int i){							//����л�ҳ�水ť��Ҫ���²���,srcҪ��ӵ�rel�����
		
		s.ipadx = 5;
		s.ipady = 5;
		s.gridx = i % 3;
		s.gridy = i / 3;
		s.gridwidth = 1;
		s.gridheight = 1;
//		s.weightx = 1;
//		s.weighty = 1;
		gbLayout.setConstraints(src, s);
		
		rel.add(src);
	}
	
	public int getPerAllNum() {
		return perAllNum;
	}

	public void setPerAllNum(int perAllNum) {
		this.perAllNum = perAllNum;
	}

}
