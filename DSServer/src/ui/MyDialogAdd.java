package ui;

import java.awt.Cursor;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.DataProcess;
import data.PCV;

public class MyDialogAdd extends JDialog{

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
	public JButton submitBtn;		//确认提交按钮
	public JButton cancelBtn;		//取消按钮
	public int curLabNo;			//当前商品对应左侧条目的编号
	public int curPerNo;			//当前商品是第几个
	public MyPanelMidKindArray midC;//盛放中间面板的面板容器
	public MyPanelMidBottom midB;	//盛放下方面板的面板容器
	public DataProcess DP;			//用来重新设置补给后的数据
	public int itemAllNum;			//左侧每一个条目对应的菜的总数目
	
	public MyDialogAdd(int curLabNo, int curPerNo,MyPanelMidKindArray mpmka, MyPanelMidBottom mpmb, DataProcess DP, int itemAllNum) {
		
		this.itemAllNum = itemAllNum;
		this.curLabNo = curLabNo;
		this.curPerNo = curPerNo;
		this.midC = mpmka;
		this.midB = mpmb;
		this.DP = DP;
		init();
	}

	public void init(){
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
		try {
			imgLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/Add_Per.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		
		submitBtn = new JButton("确认提交");
		cancelBtn = new JButton("取消");
		submitBtn.setBounds(100, 300, 100, 40);
		cancelBtn.setBounds(220, 300, 100, 40);
		submitBtn.setContentAreaFilled(false);
		cancelBtn.setContentAreaFilled(false);
		
		
		add(imgP);
		add(labLP);
		add(labNP);
		add(priceP);
		add(submitBtn);
		add(cancelBtn);
		
		
		addImgPanelAL();
		addSubmitAL();
		addCancelAL();
		closeDialogAL();
//		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
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
				PCV.buyTotalList.add("'"+perName+"',"+" "+price+", "+leaveNum+", "+"0,"+" "+"'"+ imgFileP +"',"+" "+(itemAllNum+1)+", "+(curLabNo+1));
				DP.DAO.UOIMes();
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
		System.out.println(PCV.curLabNo);
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
					System.out.println("imgFileP : "+imgFileP);
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
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
