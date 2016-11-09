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
	
	public JLabel lab;					//左列表的每一个条目			
	public String labName;				//条目的名字
	public int labNo;					//当前左侧列表条目的序号
	public MyPanelMidKindArray midC;	//盛放中间面板的面板容器
	public MyPanelMidBottom midB;		//盛放下方面板的面板容器
	public MyPanelLeft mpl;				//左侧列表
	public boolean flag;				//判断当前条目是否被选中
	public JLabel imgLab;				//存放图片的标签
	public JLabel sp;					//空白面板
	
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
		lab.setFont(new Font("微软雅黑", 1, 14));
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
				
				//*****确定当前选中的左侧列表条目的编号*****
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
	
	public void restIndexBottom(){		//重置下方页码提示的数值
		
		midC.MPMA[labNo].indexArr = 0;
		midC.MPMA[labNo].curAllPN = midC.MPMA[labNo].panelNum;
		midB.setCurPage(1);
		midB.setAllPageNum(midC.MPMA[labNo].panelNum);
		midB.setLabelText();
		midB.updateUI();
		
		
	}
	
	public void changeMidPanel(){		//点击或左侧列表，切换右侧面板页面
		
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
