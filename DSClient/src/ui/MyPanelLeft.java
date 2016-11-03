package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelLeft extends JPanel{

	public int curLabNo;				//��ǰѡ������б�����
	public LeftItemPanel[] Lip;			//����б�ť����
	public JLabel[] labA;				//����б�ť���Ʊ�ǩ����
	public boolean haveRecL = false;	//�ж��Ƿ���Ҫˢ������б�
	public ArrayList<String> recLL;		//���շ���˵�
	public JPanel spcePanel;			//�հ�����������
	public MyPanelMidKindArray midC;	//ʢ���м������������
	public MyPanelMidBottom midB;		//ʢ���·������������
	public int selNo;					//��ѡ�е���Ŀ���
	GridBagLayout gbLayout;				//���ò��ַ�ʽ
	GridBagConstraints s;				//���ò��ַ�ʽ
	
	public MyPanelLeft(MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb) {
		this.midC = mpmka;
		this.midB = mpmb;
		init();
		
	}

	public void init() {
			
		selNo = 0;
		
		//************���ò��ַ�ʽ*****************
		gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		//****************************************

		haveRecL = true;			//��ʱ���ж�������Ϊtrue
		checkFlushL();
		setBackground(Color.WHITE);
		initSelected();
	}
	
	public void checkFlushL(){
		
		if(haveRecL){
			dataReceive();
			flushdata();
		}
	}
	
	public void dataReceive(){			//�ӷ���˻������б������
		
		recLL = new ArrayList<>();
		spcePanel = new JPanel();
		
		for(int i = 0; i < 8; i++){
			
			recLL.add("���Բ˵� "+(i+1));
		}

		Lip = new LeftItemPanel[recLL.size()];
		
		for(int i = 0; i < recLL.size(); i++){
			
			Lip[i] = new LeftItemPanel(recLL.get(i), i, midC, midB, this);
			Lip[i].setBackground(new Color(255, 255, 255));
			Lip[i].setForeground(new Color(50, 50, 50));
			s.fill = GridBagConstraints.HORIZONTAL;
			s.gridx = 0;
			s.gridy = i;
			s.ipadx = 10;
			s.ipady = 10;
			s.weightx = 1;
			s.weighty = 0;
			s.gridwidth = 1;
			s.gridheight = 1;
			add(Lip[i], s);
		}
//		s.fill = GridBagConstraints.BOTH;
//		s.gridx = 0;
//		s.gridy = recLL.size();
//		s.ipadx = 10;
//		s.ipady = 10;
//		s.weightx = 1;
//		s.weighty = 0;
//		s.gridwidth = 0;
//		s.gridheight = 10;
//		add(spcePanel, s);
	}
	
	public void flushdata(){			//ˢ������б�����
		
		updateUI();
	}
	
	public int getCurLabNo() {
		return curLabNo;
	}

	public void setCurLabNo(int curLabNo) {
		this.curLabNo = curLabNo;
	}

	public void flushColor(){			//ˢ������б����ɫ

		for(int i = 0; i < recLL.size(); i++){
			if(i != selNo){
				Lip[i].setBackground(new Color(255, 255, 255));
				Lip[i].lab.setForeground(new Color(50, 50, 50));
				Lip[i].updateUI();
			}
			
		}
	}
	
	public void initSelected(){			//��ʼ��Ĭ��ѡ�е�����б����Ŀ

		Lip[0].setBackground(new Color(50, 50, 50));
		Lip[0].lab.setForeground(Color.WHITE);
		
	}
}
