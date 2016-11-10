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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.DataProcess;
import data.PCV;

public class MyPanelPer extends JPanel{

	public JLabel imgLab;				//���ͼƬ�ı�ǩ
	public PerBottom p;					//����panel
	GridBagLayout gbLayout;
	GridBagConstraints s;
	public MyPanelMidKindArray midC;
	public MyPanelMidBottom midB;
	public DataProcess DP;
	public String imgPath;				//ͼƬ����·��
	public int purches;					//�ѹ��������
	public int sold;					//��������
	public int leave;					//ʣ������
	public double price;				//�����۸�
	public String perName;				//ÿһ���˵�����
	public int curLabNo;				//��ǰ��Ŀ���
	public int perIndex;				//��ǰ�˵ı��
	public MyDialogUOD MDO;				//�޸Ļ�ɾ���Ի���
	public int pageNo;					//��ǰҳ���ǵڼ�ҳ
	
	public MyPanelPer(MyPanelMidKindArray midC,MyPanelMidBottom midB,DataProcess DP,ArrayList<String> list, int perIndex, int curLabNo, int pageNo) {
		
		//************��ʼ������********************
		this.pageNo = pageNo;
		String str = list.get(perIndex+pageNo*9);
		String sa[] = str.split(" ");
		this.midC = midC; 
		this.midB = midB;
		this.DP = DP;
		this.perIndex = perIndex;
		this.curLabNo = curLabNo;
		this.perName = sa[0];
		this.price = Double.parseDouble(sa[1]);
		this.leave = Integer.parseInt(sa[2]);
		this.sold = Integer.parseInt(sa[3]);
		this.imgPath = sa[4];
		
		//*****************************************
		
		init();
		addUODActionL();
	}
	
	public void init() {			//��ʼ��ÿһ���˵�������
		
		setLayout();
		imgLab = new JLabel();
		
		p = new PerBottom(price, leave, sold, curLabNo, perIndex);
		
		setBackground(Color.WHITE);
	
			ImageIcon img = new ImageIcon(imgPath);
			imgLab.setIcon(img);
	
		
		s.gridx = 0;
		s.gridy = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
//		s.weightx = 1;
//		s.weighty = 1;
		this.add(imgLab, s);
		
		
		s.gridx = 0;
		s.gridy = 1;
		s.gridwidth = 1;
		s.gridheight = 1;
		this.add(p, s);
	}

	public void setLayout(){				//���ò��ַ�ʽ
		
		gbLayout = new GridBagLayout();
		s = new GridBagConstraints();
		this.setLayout(gbLayout);
	}
	
	public void addUODActionL(){		//ΪͼƬ��ǩ��ӵ���¼�
		
		imgLab.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				MDO = new MyDialogUOD(curLabNo, perIndex, midC, midB, DP);
				MDO.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				imgLab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				imgLab.setToolTipText(perName+"����" + PCV.SPLINE+"����޸���Ʒ��Ϣ");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}

class PerBottom extends JPanel{
	public JLabel priceLab;				//�۸��ǩ
	public JLabel subNum;				//���ٰ�ť
	public JLabel addNum;				//���Ӱ�ť
	public JLabel soldNum;				//���۱�ǩ
	public JLabel leaveNum;				//ʣ���ǩ
	public JTextField showNum;			//��ʾ������ǩ
	public int purches;					//�ѹ��������
	public int sold;					//��������
	public int leave;					//ʣ������
	public double price;				//�����۸�
	public String perName;				//ÿһ���˵�����
	public int curLabNo;				//��ǰ��Ŀ���
	public int perIndex;				//��ǰ�˵ı��
	
	public PerBottom(double price, int leave, int sold, int curLabNo, int perIndex) {
		
		this.perIndex = perIndex;
		this.price = price;
		this.leave = leave;
		this.sold = sold;
		this.curLabNo = curLabNo;
		init();
		addSubAL();
		addAddAL();
	}

	public void init() {
		priceLab = new JLabel();
		subNum = new JLabel();
		addNum = new JLabel();
		showNum = new JTextField(2);
		soldNum = new JLabel();
		leaveNum = new JLabel();
		setBackground(Color.WHITE);
		
		try {
			ImageIcon imgSub = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/sub.png")));
			ImageIcon imgAdd = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/add.png")));
			subNum.setIcon(imgSub);
			addNum.setIcon(imgAdd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showNum.setText("0");
		showNum.setEditable(false);
		
		soldNum.setFont(new Font("΢���ź�", 0, 10));
		soldNum.setForeground(new Color(200, 10, 0));
		soldNum.setText(""+sold);
		
		leaveNum.setFont(new Font("΢���ź�", 0, 10));
		leaveNum.setForeground(new Color(200, 10, 0));
		leaveNum.setText(leave+"/");
		
		priceLab.setText("��"+price); 
		priceLab.setForeground(new Color(200, 10, 0));
		
		add(priceLab);
		add(subNum);
		add(showNum);
		add(addNum);
		add(leaveNum);
		add(soldNum);
	}
	
	public void goAddNum(){				//ֱ���޸Ŀ����
		
		leaveNum.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void addAddAL(){				//Ϊ��ӱ�ǩ����¼�
		
		addNum.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				purches++;
				showNum.setText(purches+"");
				updateList(curLabNo,perIndex,purches);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addNum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
	}
	
	public void addSubAL(){				//Ϊ���ٱ�ǩ����¼�
		
		subNum.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
					purches--;
					showNum.setText(purches+"");					
					updateList(curLabNo, perIndex,purches);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				subNum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
	}
	
	public void updateList(int curLabNo,int perIndex, int purches){				//�������¹����б�ķ���
		
		boolean flag = false;
		for(int i = 0; i < PCV.buyList.size(); i++){
			if(PCV.buyList.get(i).contains(curLabNo+" "+perIndex+"")){
				String s[] = PCV.buyList.get(i).split(" ");
				PCV.buyList.set(i,s[0]+" "+s[1]+ " "+ purches);				
				flag = true;
			}
		}
		if(!flag){
			PCV.buyList.add(curLabNo+" "+perIndex+" "+purches);
		}
	}
}