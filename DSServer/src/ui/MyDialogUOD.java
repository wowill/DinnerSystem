package ui;

import java.awt.Cursor;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.DataProcess;
import data.PCV;

public class MyDialogUOD extends JDialog{
	public int width = 400;			//对话框宽
	public int height = 400;		//对话框高
	public JLabel imgLab;			//图片标签
	public JTextField leaveField;	//库存输入框
	public JLabel levLab;			//库存提示标签
	public JTextField perNameFiled;	//每个菜菜名输入框
	public JLabel perNameLab;		//菜名提示标签
	public JLabel perPriceLab;		//菜价提示标签
	public JTextField priceFiled;	//菜价输入框
	public JPanel priceP;			//菜价面板
	public JPanel imgP;				//存放图片面板
	public JPanel labLP;			//库存面板
	public JPanel labNP;			//菜名面板
	public JFileChooser chooser;	//选择要添加的图片
	public String imgFileP;			//选择打开的图片文件的路径
	public JButton submitBtn;		//确认更新按钮按钮
	public JButton deleteBtn;		//确认删除按钮
	public JButton cancelBtn;		//取消按钮
	public int curLabNo;			//当前商品对应左侧条目的编号
	public int curPerNo;			//当前商品是第几个
	public MyPanelMidKindArray midC;//盛放中间面板的面板容器
	public MyPanelMidBottom midB;	//盛放下方面板的面板容器
	public DataProcess DP;			//用来重新设置补给后的数据
	
	public MyDialogUOD(int curLabNo, int curPerNo,MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb, DataProcess DP) {
		
		this.curLabNo = curLabNo;
		this.curPerNo = curPerNo;
		this.midC = mpmka;
		this.midB = mpmb;
		this.DP = DP;
		init();
	}

	public void init() {
		//************窗口居中*******************
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		int w = rect.width;
		int h = rect.height;
		this.setBounds((w - width) / 2, (h - height) / 2, width, height);
		//**************************************
		setLayout(null);
		setTitle("商品添加");
		imgP = new JPanel();
		labLP = new JPanel();
		labNP = new JPanel();
		priceP = new JPanel();
		
		imgLab = new JLabel();
		leaveField = new JTextField();
		levLab = new JLabel();
		perNameFiled = new JTextField();
		perNameLab = new JLabel();
		perPriceLab = new JLabel();
		priceFiled = new JTextField();
		
		imgP.add(imgLab);
	
		imgP.setBounds(10, 10, 175, 160);
		
		labLP.add(levLab);
		labLP.add(leaveField);
		levLab.setText("设置库存：");
		leaveField.setColumns(8);
		labLP.setBounds(200, 10, 100, 60);
		
		
		labNP.add(perNameLab);
		labNP.add(perNameFiled);
		perNameLab.setText("设置商品名：");
		perNameFiled.setColumns(8);
		labNP.setBounds(200, 65, 100, 60);
		
		priceP.add(perPriceLab);
		perPriceLab.setText("设置商品价格：");
		priceP.add(priceFiled);
		priceFiled.setColumns(8);
		priceP.setBounds(200, 120, 100, 60);
		
		
		submitBtn = new JButton("确认更改");
		deleteBtn = new JButton("确认删除");
		cancelBtn = new JButton("取消");
		submitBtn.setBounds(40, 300, 100, 40);
		deleteBtn.setBounds(150, 300, 100, 40);
		cancelBtn.setBounds(260, 300, 100, 40);
		submitBtn.setContentAreaFilled(false);
		cancelBtn.setContentAreaFilled(false);
		deleteBtn.setContentAreaFilled(false);
		
		setLabMes();
		add(imgP);
		add(labLP);
		add(labNP);
		add(priceP);
		add(submitBtn);
		add(deleteBtn);
		add(cancelBtn);
		
		
		addImgPanelAL();
		addSubmitAL();
		addDeleteAL();
		addCancelAL();
		closeDialogAL();
//		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	}
	public void setLabMes(){					//从数据库中取出原有的数据，并添加到相应的标签上
		
		int a[] = new int[4];
		a[0] = 2; a[1] = 3; a[2] = 4; a[3] =6;
		String sql = "";
		String sa[] = null;
		sql = "select * from ItemToDetails where perID = "+(getCurPerNoT())+" and ItemID = "+(curLabNo+1);
		sa = DP.DAO.select(sql, a).get(0).split(" ");

		for(int i = 0; i < sa.length; i++){
			perNameFiled.setText(sa[0]);
			priceFiled.setText(sa[1]);
			leaveField.setText(sa[2]);
			imgFileP = sa[3];
			imgLab.setIcon(new ImageIcon(sa[3]));
	
		}
	}
	public void closeDialogAL(){				//关闭对话框事件
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
			}
		});
		setVisible(false);
	}
	
	public void addCancelAL(){					//为取消按钮添加
		cancelBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				closeDialogAL();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void addDeleteAL(){					//为删除按钮添加点击事件
		deleteBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				String sql = "";
				
				sql = "delete from ItemToDetails where perID = "+(getCurPerNoT()) +" and ItemID = "+(curLabNo+1);
				System.out.println("***"+sql);
				DP.DAO.delete(sql);
				flushMidCB();
				closeDialogAL();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public int getMaxPerNo(){				//获取最大的每道菜的编号
		
		int maxV = 0;
		int cpn = curPerNo + 1;
		int a[] = {7};
		int j = 0, k = cpn;
		
		while(true){
			String	sql = "select * from ItemToDetails where perID = "+(k)+" and ItemID = "+(curLabNo+1);
			k++;
			if(DP.DAO.select(sql, a).size() > 0){
				int x = Integer.parseInt(DP.DAO.select(sql, a).get(0).split(" ")[0]);
				if(x > maxV){
					maxV = x;
				}
				break;
			}
			
		}
		System.out.println("max "+maxV);
		return maxV;
		
	}
	
	public int getCurPerNoT(){				//通过点击的面板的编号，推算出是第几个面板
		
		int maxV = 0;
		int cpn = curPerNo + 1;
		int a[] = {7};
		int j = 0, k = cpn;
		ArrayList<String> list = new ArrayList<>();
		String	tsql = "select * from ItemToDetails where ItemID = "+(curLabNo+1);
		list = DP.DAO.select(tsql, a);
		
		if(list.size() > cpn-1){
			
			maxV = Integer.parseInt(list.get(cpn-1));
		}
		
		
		System.out.println("max "+maxV);
		return maxV;
		
	}
	
	public void addSubmitAL(){					//未确认提交按钮添加点击事件
		submitBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int leaveNum = Integer.parseInt(leaveField.getText());
				String perName = perNameFiled.getText();
				double price = Double.parseDouble(priceFiled.getText());
				String sql = "update ItemToDetails set name = "+"'"+perName+"' , price = "+price+" , "+"leave = "+leaveNum
						+" , picture = '"+imgFileP+"' where perID = "+(getCurPerNoT()) +" and ItemID = "+(curLabNo+1);     
				DP.DAO.update(sql);
				flushMidCB();
				closeDialogAL();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void flushMidCB(){				//刷新中间面板和底部面板
		
		DP.init();
		
		//**********更新中间面板**********
		midC.removeAll();
		midC.reInit(PCV.curLabNo);
		midC.MPMA[PCV.curLabNo].restLayoutMAOI(0);		//点击坐上logo刷新，重新设置选中的中间面板	
//		System.out.println(PCV.curLabNo);
		//*******************************
		
		//*********更新下方面板***********
		midB.setCurPage(1);
		midB.setLabelText();
		midB.updateUI();
		//*******************************
		
		PCV.buyList = new ArrayList<>();
		PCV.buyTotalList = new ArrayList<>();
	}
	public void addImgPanelAL(){				//为添加图片添加事件
		
		imgP.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int value = chooser.showOpenDialog(null);
				if(value == JFileChooser.APPROVE_OPTION){
					imgFileP = chooser.getSelectedFile().getPath();
//					System.out.println("imgFileP : "+imgFileP);
					imgLab.setIcon(new ImageIcon(imgFileP));
					imgP.updateUI();
					
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				imgP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
