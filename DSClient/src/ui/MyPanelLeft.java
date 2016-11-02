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

	public JButton[] btnA;				//����б�ť����
	public JLabel[] labA;				//����б�ť���Ʊ�ǩ����
	public boolean haveRecL = false;	//�ж��Ƿ���Ҫˢ������б�
	public ArrayList<String> recLL;		//���շ���˵�
	GridBagLayout gbLayout;				//���ò��ַ�ʽ
	GridBagConstraints s;				//���ò��ַ�ʽ
	
	public MyPanelLeft() {
		
		init();
	}

	public void init() {
			
		//************���ò��ַ�ʽ*****************
		gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		s = new GridBagConstraints();
		
		//****************************************

		haveRecL = true;			//��ʱ���ж�������Ϊtrue
		checkFlushL();
		setBackground(Color.red);
	}
	
	public void checkFlushL(){
		
		if(haveRecL){
			dataReceive();
			flushdata();
		}
	}
	
	public void dataReceive(){			//�ӷ���˻������б������
		
		recLL = new ArrayList<>();
		
		for(int i = 0; i < 10; i++){
			
			recLL.add("���Բ˵� "+i);
		}

		btnA = new JButton[recLL.size()];
		
		for(int i = 0; i < recLL.size(); i++){
			
			btnA[i] = new JButton();
			btnA[i].setText(recLL.get(i));
			btnA[i].setFont(new Font("΢���ź�", 1, 14));
			s.fill = GridBagConstraints.HORIZONTAL;
			s.gridx = 0;
			s.gridy = i;
			s.ipadx = 10;
			s.ipady = 10;
			s.weightx = 1;
			s.gridwidth = 1;
			s.gridheight = 1;
			add(btnA[i], s);
		}
	}
	
	public void flushdata(){			//ˢ������б�����
		
		updateUI();
	}
	
}
