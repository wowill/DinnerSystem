package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.DataProcess;

public class MyPanelPerAdd extends JPanel{

	public MyPanelLeft mpl;
	public JLabel imgLab;
	public MyPanelMidKindArray midC;
	public MyPanelMidBottom midB;
	public DataProcess DP;
	public int curPerNum;
	public int curLabNo;
	public MyDialogAdd MDA;						//添加商品的详细信息的对话框
	
	public MyPanelPerAdd(MyPanelMidKindArray midC,MyPanelMidBottom midB,DataProcess DP,int curPerNum, int curLabNo) {
		
		this.midC = midC; 
		this.midB = midB;
		this.DP = DP;
		this.curPerNum = curPerNum;
		this.curLabNo = curLabNo;
		
		init();
		addAddPerAL();
	}

	public void init() {
		
//		this.setSize(175, 180);
		
		try {
			imgLab = new JLabel();
			ImageIcon img = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/Add_Per.png")));
			imgLab.setIcon(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBackground(Color.WHITE);
		this.add(imgLab);
	}
	public void addAddPerAL(){			//为此添加面板添加点击事件
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				MDA = new MyDialogAdd(curLabNo, curPerNum, midC, midB, DP);
				MDA.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
