package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	public ConfirmPanel confimP;				//ȷ�Ϲ������
	GridBagLayout gbLayout;				//���ò��ַ�ʽ
	GridBagConstraints s;				//���ò��ַ�ʽ
	
	public MyPanelLeft(MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb) {
		this.midC = mpmka;
		this.midB = mpmb;
		confimP = new ConfirmPanel();
		init();
		
	}

	public void init() {
			
		selNo = 0;
		confimP.setBackground(new Color(150, 20, 20));
		confimP.confLab.setForeground(Color.WHITE);
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
		addCPAL();
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
		s.fill = GridBagConstraints.HORIZONTAL;
		s.gridx = 0;
		s.gridy = recLL.size();
		s.ipadx = 10;
		s.ipady = 210;
		s.weightx = 1;
		s.weighty = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
		spcePanel.setBackground(Color.WHITE);
		add(spcePanel, s);
		
		s.fill = GridBagConstraints.HORIZONTAL;
		s.gridx = 0;
		s.gridy = recLL.size()+1;
		s.ipadx = 10;
		s.ipady = 10;
		s.weightx = 1;
		s.weighty = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
		add(confimP, s);
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
	public void addCPAL(){
		confimP.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				confimP.setBackground(new Color(150, 0, 20));
				confimP.confLab.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				confimP.setBackground(new Color(220, 0, 0));
				confimP.confLab.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				confimP.setBackground(new Color(220, 0, 0));
				confimP.confLab.setForeground(Color.WHITE);
				JOptionPane.showConfirmDialog(null, "��ȷ���Ƿ���");
			}
		});
	}
}

class ConfirmPanel extends JPanel{
	
	JLabel confLab;
	public ConfirmPanel() {
		
		confLab = new JLabel("ȷ�Ϲ���");
		confLab.setFont(new Font("΢���ź�", 1, 15));
		this.add(confLab);
	}
	
	
	
}
