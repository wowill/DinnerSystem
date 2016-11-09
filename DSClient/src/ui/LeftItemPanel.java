package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.PCV;

public class LeftItemPanel extends JPanel{
	
	public JLabel lab;					//���б��ÿһ����Ŀ			
	public String labName;				//��Ŀ������
	public int labNo;					//��ǰ����б���Ŀ�����
	public MyPanelMidKindArray midC;	//ʢ���м������������
	public MyPanelMidBottom midB;		//ʢ���·������������
	public MyPanelLeft mpl;				//����б�
	public boolean flag;				//�жϵ�ǰ��Ŀ�Ƿ�ѡ��
	public JLabel imgLab;				//���ͼƬ�ı�ǩ
	public JLabel sp;					//�հ����
	
	public LeftItemPanel(String name, int labNo, MyPanelMidKindArray midC, MyPanelMidBottom midB, MyPanelLeft mpl) {
		
		this.mpl = mpl;
		this.midC = midC;
		this.midB = midB;
		this.labNo = labNo;
		this.labName = name;
		init();
	}

	public void init() {
		
		flag = false;
		lab = new JLabel(labName);
		lab.setFont(new Font("΢���ź�", 1, 14));
		imgLab = new JLabel();
		sp = new JLabel();
		sp.setText("     ");
		try {
			imgLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/black.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.add(imgLab);
		this.add(sp);
		this.add(lab);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(midC.MPMA[labNo].itemAllNum+"   ||    "+Arrays.toString(midC.MPMA[labNo].evePaneNum));
				try {
					imgLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/white.png"))));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				 	e1.printStackTrace();
				}
				changeMidPanel();
				restIndexBottom();
				setBackground(new Color(176,190,197));
				lab.setForeground(Color.WHITE);
				mpl.selNo = labNo;
				
				//*****ȷ����ǰѡ�е�����б���Ŀ�ı��*****
				PCV.curLabNo = labNo;
				//****************************************
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
				mpl.flushColor();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setBackground(new Color(176,190,197));
				lab.setForeground(Color.WHITE);
				try {
					imgLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/white.png"))));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void restIndexBottom(){		//�����·�ҳ����ʾ����ֵ
		
		midC.MPMA[labNo].indexArr = 0;
		midC.MPMA[labNo].curAllPN = midC.MPMA[labNo].panelNum;
		midB.setCurPage(1);
		midB.setAllPageNum(midC.MPMA[labNo].panelNum);
		midB.setLabelText();
		midB.updateUI();
		
		
	}
	
	public void changeMidPanel(){		//���������б��л��Ҳ����ҳ��
		
		midC.removeAll();
		midC.restLayouMidArr(labNo, midC);
		midC.updateUI();
		midC.setCurLabNo(labNo);
		
		MyPanelMidArray tempP = midC.MPMA[midC.getCurLabNo()];
		tempP.indexArr = 0;
		tempP.removeAll();
		midC.removeAll();
		tempP.restLayouMidArr(tempP.MPM[tempP.indexArr], tempP);
		midC.restLayouMidArr(midC.curLabNo, midC);
		tempP.updateUI();
		midC.updateUI();
		midB.setAllPageNum(tempP.getPanelNum());
		midB.setCurPage(tempP.indexArr+1);
		midB.setLabelText();
		midB.updateUI();
	}
	

	
	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public int getLabNo() {
		return labNo;
	}

	public void setLabNo(int labNo) {
		this.labNo = labNo;
	}

	
}
