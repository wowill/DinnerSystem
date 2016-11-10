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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.PCV;

public class MyPanelPer extends JPanel{

	public JLabel imgLab;				//存放图片的标签
	public PerBottom p;					//容器panel
	GridBagLayout gbLayout;
	GridBagConstraints s;
	public String imgPath;				//图片所在路径
	public int purches;					//已购买的数量
	public int sold;					//已售数量
	public int leave;					//剩余数量
	public double price;				//售卖价格
	public String perName;				//每一道菜的名字
	public int curLabNo;				//当前条目编号
	public int perIndex;				//当前菜的编号
	public int pageNo;					//当前页面是第几页
	public MyPanelMidBottom midB;		//下侧面板，主要用来实时更新已购物品价格
	
	public MyPanelPer(ArrayList<String> list, int perIndex, int curLabNo, int pageNo,MyPanelMidBottom midB) {
		
		//************初始化数据********************
		this.midB = midB;
		this.pageNo = pageNo;
		String str = list.get(perIndex+pageNo*9);
		String sa[] = str.split(" ");
		
		this.perIndex = perIndex;
		this.curLabNo = curLabNo;
		this.perName = sa[0];
		this.price = Double.parseDouble(sa[1]);
		this.leave = Integer.parseInt(sa[2]);
		this.sold = Integer.parseInt(sa[3]);
		this.imgPath = sa[4];
		
		//*****************************************
		
		init();
		addImgLabAL();
	}
	public void addImgLabAL(){			//为图片标签添加鼠标事件
		imgLab.addMouseListener(new MouseListener() {
			
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
				imgLab.setToolTipText(perName);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void init() {			//初始化每一道菜的面板界面
		
		setLayout();
		imgLab = new JLabel();
		
		
		p = new PerBottom(price, leave, sold, curLabNo, perIndex,midB,pageNo);
		
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createEtchedBorder());
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
	public String perName;				//每一道菜的名字
	public int curLabNo;				//当前条目编号
	public int perIndex;				//当前菜的编号
	public MyPanelMidBottom midB;		//下侧面板，主要用来实时更新已购物品价格
	public int pageNo;					//当前页面是第几页
	
	public PerBottom(double price, int leave, int sold, int curLabNo, int perIndex, MyPanelMidBottom midB, int pageNo) {
		
		this.pageNo = pageNo;
		this.midB = midB;
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
				purches++;
				showNum.setText(purches+"");
				updateList(curLabNo,perIndex,purches);
				midB.setPriceLabText();
				midB.updateUI();
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
	
	public void addSubAL(){				//为减少标签添加事件
		
		subNum.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(purches > 0){
					purches--;
					showNum.setText(purches+"");					
					updateList(curLabNo, perIndex,purches);
					midB.setPriceLabText();
					midB.updateUI();
				}
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
	
	public void updateList(int curLabNo,int perIndex, int purches){				//用来更新购物列表的方法
		
		boolean flag = false;
		for(int i = 0; i < PCV.buyList.size(); i++){
			if(PCV.buyList.get(i).contains(curLabNo+" "+(perIndex+pageNo*9)+"")){
				String s[] = PCV.buyList.get(i).split(" ");
				PCV.buyList.set(i,s[0]+" "+s[1]+ " "+ purches+" "+pageNo);				
				flag = true;
			}
		}
		if(!flag){
			PCV.buyList.add(curLabNo+" "+(perIndex+pageNo*9)+" "+purches+" "+pageNo);
		}
	}
}