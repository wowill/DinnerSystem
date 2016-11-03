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

	public JLabel imgLab;				//存放图片的标签
	public PerBottom p;					//容器panel
	GridBagLayout gbLayout;
	GridBagConstraints s;
	
	public MyPanelPer() {
		
		init();
	}
	
	public void init() {			//初始化每一道菜的面板
		
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

	public void setLayout(){				//设置布局方式
		
		gbLayout = new GridBagLayout();
		s = new GridBagConstraints();
		this.setLayout(gbLayout);
	}
	
}

class PerBottom extends JPanel{
	public JLabel priceLab;				//价格标签
	public JLabel subNum;				//减少按钮
	public JLabel addNum;				//增加按钮
	public JLabel soldNum;				//已售标签
	public JLabel leaveNum;				//剩余标签
	public JTextField showNum;			//显示数量标签
	public int purches;					//已购买的数量
	public int sold;					//已售数量
	public int leave;					//剩余数量
	public double price;				//售卖价格
	
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
		
		
		soldNum.setFont(new Font("微软雅黑", 0, 10));
		soldNum.setForeground(new Color(200, 10, 0));
		soldNum.setText(""+sold);
		
		leaveNum.setFont(new Font("微软雅黑", 0, 10));
		leaveNum.setForeground(new Color(200, 10, 0));
		leaveNum.setText(leave+"/");
		
		priceLab.setText("￥"+price); 
		priceLab.setForeground(new Color(200, 10, 0));
		
		add(priceLab);
		add(subNum);
		add(showNum);
		add(addNum);
		add(leaveNum);
		add(soldNum);
	}
	
	public void goAddNum(){				//直接修改库存量
		
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
	
	public void addAddAL(){				//为添加标签添加事件
		
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
	
	public void addSubAL(){				//为减少标签添加事件
		
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