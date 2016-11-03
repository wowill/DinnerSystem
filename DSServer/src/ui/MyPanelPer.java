package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanelPer extends JPanel{

	public JLabel imgLab;				//���ͼƬ�ı�ǩ
	public PerBottom p;					//����panel
	GridBagLayout gbLayout;
	GridBagConstraints s;
	
	public MyPanelPer() {
		
		init();
	}
	
	public void init() {			//��ʼ��ÿһ���˵����
		
		setLayout();
		imgLab = new JLabel();
		p = new PerBottom();
		setBackground(Color.WHITE);
		try {
			int randX = (int)(Math.random()*8+1);
			ImageIcon img = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/000"+randX+".png")));
			imgLab.setIcon(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public PerBottom() {
		
		init();
		addSubAL();
		addAddAL();
	}

	public void init() {
		priceLab = new JLabel("19.22");
		subNum = new JLabel();
		addNum = new JLabel();
		showNum = new JTextField(2);
		soldNum = new JLabel();
		leaveNum = new JLabel();
		setBackground(Color.WHITE);
		purches = 0;
		sold = 0;
		leave = 10;
		price = 19.22;
		
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
				
				purches++;
				showNum.setText(purches+"");
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
				if(purches > 0){
					purches--;
					showNum.setText(purches+"");
				}
				
			}
		});
	}
}