package ui;

import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.DataProcess;
import data.ServerSocketProcess;

public class MyFrame extends JFrame{
	int FRAME_WIDTH = 900;
	int FRAME_HEIGHT = 700;
	
	int LP_WIDTH = 10;
	int MPMA_WIDTH = 660;
	int MPMA_HEIGHT = 600;
	int MPMB_WIDTH = 660;
	int MPMB_HEIGHT = 50;
	
	DataProcess DP;
	MyPanelLeft MPL;
	MyPanelMidBottom MPMB;
	MyPanelMidKindArray MPMKA;
	ServerSocketProcess server;
	
	
	
	public MyFrame() {
		
		DP = new DataProcess();
		MPMB = new MyPanelMidBottom();
		MPMKA = new MyPanelMidKindArray();
		MPL = new MyPanelLeft(MPMKA, MPMB);
		init();
		initBottomIndex();
		AddBtnNextListener();
		AddBtnFrontListener();
		server = new ServerSocketProcess();
	}

	public void init() {
		
		System.out.println(this.getClass());
		//************���ھ���*******************
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		int w = rect.width;
		int h = rect.height;
		this.setBounds((w - FRAME_WIDTH) / 2, (h - FRAME_HEIGHT) / 2, FRAME_WIDTH, FRAME_HEIGHT);
		//**************************************
//		setResizable(false);
		setTitle("Ordering   �����");
		try {
			this.setIconImage(ImageIO.read(this.getClass().getResource("/image/dinner.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//************���ò��ַ�ʽ*****************
		GridBagLayout gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		//****************************************
		
		this.add(MPL);
		this.add(MPMB);
		this.add(MPMKA);
		
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
		s.gridwidth = 1;
		s.gridheight = 2;
//		s.weightx = 0;
//		s.gridheight = 0;
//		s.weighty = 0;
//		s.weightx = 0;
		add(MPL, s);
		gbLayout.setConstraints(MPL, s);
		// *************************************
		
		// ************�����м����򲼾�***************
		s.fill = GridBagConstraints.BOTH;
//		s.ipadx = MPMA_WIDTH;
//		s.ipady = MPMA_HEIGHT;
		s.gridx = 1;
		s.gridy = 0;
		s.gridheight = 1;
		s.gridwidth = 0;
		s.weightx = 0.5;
		s.weighty = 0.95;
		add(MPMKA, s);
		gbLayout.setConstraints(MPMKA, s);
		// *************************************
		
		// ************�����������򲼾�***************
		s.fill = GridBagConstraints.HORIZONTAL;
//		s.ipadx = MPMB_WIDTH;
//		s.ipady = MPMB_HEIGHT;
		s.gridx = 1;
		s.gridy = 1;
		s.gridheight = 1;
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0.05;
		add(MPMB, s);
		gbLayout.setConstraints(MPMB, s);
		// *************************************
		
	}
	
	public void AddBtnNextListener(){							//Ϊ��һ����ť����¼�
		MPMB.nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyPanelMidArray tempP = MPMKA.MPMA[MPMKA.curLabNo];
				
				if(tempP.indexArr+1 < tempP.panelNum)
				{
					System.out.println(MPMKA.curLabNo+"  ||  "+tempP.indexArr + "   " +tempP.panelNum);
					tempP.indexArr++;
					tempP.removeAll();
					MPMKA.removeAll();
					tempP.restLayouMidArr(tempP.MPM[tempP.indexArr], tempP);
					MPMKA.restLayouMidArr(MPMKA.curLabNo, MPMKA);
					tempP.updateUI();
					MPMKA.updateUI();
					MPMB.setAllPageNum(tempP.getPanelNum());
					MPMB.setCurPage(tempP.indexArr+1);
					MPMB.setLabelText();
					MPMB.updateUI();
				}
				else
					System.out.println("�������һҳ");
				
			}
		});
	}
	

	public void AddBtnFrontListener(){							//Ϊ��һ����ť����¼�
		MPMB.frontBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyPanelMidArray tempP = MPMKA.MPMA[MPMKA.getCurLabNo()];
				if(tempP.indexArr-1 >= 0)
				{
					tempP.indexArr--;
					tempP.removeAll();
					MPMKA.removeAll();
					tempP.restLayouMidArr(tempP.MPM[tempP.indexArr], tempP);
					MPMKA.restLayouMidArr(MPMKA.curLabNo, MPMKA);
					tempP.updateUI();
					MPMKA.updateUI();
					MPMB.setAllPageNum(tempP.getPanelNum());
					MPMB.setCurPage(tempP.indexArr+1);
					MPMB.setLabelText();
					MPMB.updateUI();
				}
				else
					System.out.println("���ǵ�һҳ");
				
			}
		});
	}
	
	public void initBottomIndex(){			//��ʼ���ײ�����ҳ���ǩ
		
		MPMB.setCurPage(1);
		MPMB.setAllPageNum(MPMKA.MPMA[0].panelNum);
		MPMB.setLabelText();
		MPMB.updateUI();
	}
	
}
