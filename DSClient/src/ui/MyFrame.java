package ui;

import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	int FRAME_WIDTH = 900;
	int FRAME_HEIGHT = 700;
	
	int LP_WIDTH = 200;
	int MPMA_WIDTH = 660;
	int MPMA_HEIGHT = 600;
	int MPMB_WIDTH = 660;
	int MPMB_HEIGHT = 50;
	
	MyPanelLeft MPL;
	MyPanelMidArray MPMA;
	MyPanelMidBottom MPMB;
	
	
	
	
	public MyFrame() {
		
		MPL = new MyPanelLeft();
		MPMA = new MyPanelMidArray();
		MPMB = new MyPanelMidBottom();
		init();
		
	}

	public void init() {
		
		//************���ھ���*******************
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		int w = rect.width;
		int h = rect.height;
		this.setBounds((w - FRAME_WIDTH) / 2, (h - FRAME_HEIGHT) / 2, FRAME_WIDTH, FRAME_HEIGHT);
		//**************************************
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//************���ò��ַ�ʽ*****************
		GridBagLayout gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		//****************************************
		
		this.add(MPL);
		this.add(MPMA);
		this.add(MPMB);
		
		GridBagConstraints s = new GridBagConstraints();
		//s.fill = GridBagConstraints.BOTH; // ������������ӽ����������ʾλ��
											// �÷�����Ϊ���������������ڵ�������������Ҫ��ʱ����ʾ���
											// NONE�������������С��
											// HORIZONTAL���ӿ������ʹ����ˮƽ��������������ʾ���򣬵��ǲ��ı�߶ȡ�
											// VERTICAL���Ӹ������ʹ���ڴ�ֱ��������������ʾ���򣬵��ǲ��ı��ȡ�
											// BOTH��ʹ�����ȫ��������ʾ����
		
		// ************����������򲼾�***************
		s.fill = GridBagConstraints.VERTICAL;
		s.ipadx = LP_WIDTH;
		s.gridx = 0;
		s.gridy = 0;
		s.gridheight = 2;
//		s.weightx = 0;
//		s.gridheight = 0;
		add(MPL, s);
		gbLayout.setConstraints(MPL, s);
		// *************************************
		
		// ************�����м����򲼾�***************
		s.fill = GridBagConstraints.BOTH;
		s.ipadx = MPMA_WIDTH;
		s.ipady = MPMA_HEIGHT;
		s.gridx = 1;
		s.gridy = 0;
		s.gridheight = 1;
		s.gridwidth = 1;
//		s.weightx = 1;
//		s.gridheight = 1;
		add(MPMA, s);
		gbLayout.setConstraints(MPMA, s);
		// *************************************
		
		// ************�����������򲼾�***************
		s.fill = GridBagConstraints.HORIZONTAL;
		s.ipadx = MPMB_WIDTH;
		s.ipady = MPMB_HEIGHT;
		s.gridx = 1;
		s.gridy = 1;
		s.gridheight = 1;
		s.gridwidth = 1;
		
		add(MPMB, s);
		gbLayout.setConstraints(MPMB, s);
		// *************************************
		
	}
	
}
