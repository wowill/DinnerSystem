package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.PCV;
import data.SocketClient;


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
	public ConfirmPanel confimP;		//ȷ�Ϲ������
	public LeftTop ltp;					//���Ͻ�logo���
	GridBagLayout gbLayout;				//���ò��ַ�ʽ
	GridBagConstraints s;				//���ò��ַ�ʽ
	SocketClient client;				//��Ҫ���ڷ�������
	
	public MyPanelLeft(MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb, SocketClient client) {
		this.midC = mpmka;
		this.midB = mpmb;
		this.client = client;
		init();
		
	}

	public void init() {
			
		selNo = 0;
		confimP = new ConfirmPanel(this);
		ltp = new LeftTop();
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
		addLogoAL();
	}
	
	public void checkFlushL(){
		
		if(haveRecL){
			dataReceive();
			flushdata();
		}
	}
	
	
	public void dataReceive(){			//�Ѵ����ݿ�������б�����ݣ����µ�������
		
		spcePanel = new JPanel();
		recLL = PCV.leftItemString;
		
		s.fill = GridBagConstraints.NORTH;
		s.gridx = 0;
		s.gridy = 0;
		s.ipadx = 0;
		s.ipady = 0;
		s.weightx = 0;
		s.weighty = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
		ltp.setBackground(Color.WHITE);
		add(ltp, s);
		
		Lip = new LeftItemPanel[recLL.size()];
		
		for(int i = 0; i < recLL.size(); i++){
			
			Lip[i] = new LeftItemPanel(recLL.get(i), i, midC, midB, this);
			Lip[i].setBackground(new Color(255, 255, 255));
			Lip[i].setForeground(new Color(50, 50, 50));
			s.fill = GridBagConstraints.HORIZONTAL;
			s.gridx = 0;
			s.gridy = i+1;
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
		s.gridy = recLL.size()+1;
		s.ipadx = 10;
		s.ipady = 220;
		s.weightx = 1;
		s.weighty = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
		spcePanel.setBackground(Color.WHITE);
		add(spcePanel, s);
		
		s.fill = GridBagConstraints.HORIZONTAL;
		s.gridx = 0;
		s.gridy = recLL.size()+2;
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
				try {
					Lip[i].imgLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/black.png"))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Lip[i].updateUI();
			}
			
		}
	}
	
	public void initSelected(){			//��ʼ��Ĭ��ѡ�е�����б����Ŀ

		Lip[0].setBackground(new Color(176,190,197));
		Lip[0].lab.setForeground(Color.WHITE);
		
	}
	
	public void restSelect(){			//ˢ�º�����ѡ��ԭ�ȱ�ѡ�е�����б���Ŀ
		
		Lip[PCV.curLabNo].setBackground(new Color(176,190,197));
		Lip[PCV.curLabNo].lab.setForeground(Color.WHITE);
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
				confimP.setBackground(new Color(220, 0, 0));
				confimP.confLab.setForeground(Color.WHITE);
				int n = JOptionPane.showConfirmDialog(null, formatBuyMes(),"�����嵥",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
				
				if(n == 0){
					afterFlushAP();						//����ˢ����������
					midB.curAPriceLab.setText(String.format("�����ѣ���%4.2f", 0.0));
					midB.curAPriceLab.setForeground(Color.RED);
				}
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
				confimP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public String formatBuyMes(){				//����������ʾ�������Ϣ
		
		double sum = 0;
		PCV.sendStrFC = "";
		StringBuilder sb = new StringBuilder();
		sb.append("�ѹ���Ʒ"+"    "+"��Ʒ����"+"    "+"��������"+PCV.SPLINE);

		for(int i = 0; i < PCV.buyList.size(); i++){
			String[] st = PCV.buyList.get(i).split(" ");
			int lId = Integer.parseInt(st[0]);			//��Ӧ����б���
			int pId = Integer.parseInt(st[1]);			//��Ӧ�м����ڼ�����
			int pNum = Integer.parseInt(st[2]);			//����ÿ���˵�����
			
			String[] stt = PCV.perDetList.get(lId).get(pId).split(" ");
			String perName = stt[0];
			double perPrice = Double.parseDouble(stt[1]);
			
			
			int lenP = 5-(perPrice+"").length()+6;
			System.out.println(lenP);
			sb.append(perName+"        "+"��"+String.format("%-"+lenP+".2f", perPrice) + "" + String.format("%16d", pNum)+PCV.SPLINE);
			
			sum += pNum * perPrice;
			PCV.sendStrFC += PCV.buyList.get(i).trim() + ",";
		}
		sb.append("�ܼƽ�"+"                "+"��"+String.format("%.2f", sum)+PCV.SPLINE);
		PCV.sendStrFC = PCV.sendStrFC.trim();
		return sb.toString();
		
	}
	
	
	public void afterFlushAP(){				//���ͺ�ˢ�£�����ˢ����������ĸ������
		
		client.updataData();			//���Ͳ����շ�������
		//*********��������б����********
		this.removeAll();
		this.dataReceive();
		this.restSelect();
		this.updateUI();
		//********************************
		
		//**********�����м����**********
		midC.removeAll();
		midC.reInit(PCV.curLabNo);
		midC.MPMA[PCV.curLabNo].restLayoutMAOI(PCV.curMPNo);		//��������ѡ�е��м����	
		
		//*******************************
//		frame.repaint();
	}
	
	public void flushAPS(){					//ˢ����������ĸ������
		
		client.init();						//�����˷������󣬽�����������
		//*********��������б����********
		this.removeAll();
		this.dataReceive();
		this.restSelect();
		this.updateUI();
		//********************************
		
		//**********�����м����**********
		midC.removeAll();
		midC.reInit(PCV.curLabNo);
		midC.MPMA[PCV.curLabNo].restLayoutMAOI(0);		//��������ѡ�е��м����	
		
		//*******************************
		
		midB.setCurPage(1);
		midB.setLabelText();
		midB.updateUI();
//		frame.repaint();
	}
	
public void addLogoAL(){			//Ϊ���Ͻ���ӵ���¼�
		
		ltp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				flushAPS();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ltp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
	}
}

class ConfirmPanel extends JPanel{
	
	JLabel confLab;
	MyPanelLeft mpl;
	public ConfirmPanel(MyPanelLeft mpl) {
		
		this.mpl = mpl;
		confLab = new JLabel("ȷ�ϸ���");
		confLab.setFont(new Font("΢���ź�", 1, 15));
		this.add(confLab);
	}
	
}

class LeftTop extends JPanel{
	
	JLabel imgLab;
	public LeftTop() {
		
		init();
	}
	public void init() {
		
		imgLab = new JLabel();
		try {
			ImageIcon img = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/leftTop.png")));
			imgLab.setIcon(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(imgLab);
	}
	
}
