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

	public int width = 400;			//�Ի����
	public int height = 400;		//�Ի����
	public JLabel imgLab;			//ͼƬ��ǩ
	public JTextField leaveField;	//��������
	public JLabel levLab;			//�����ʾ��ǩ
	public JTextField perNameFiled;	//ÿ���˲��������
	public JLabel perNameLab;		//������ʾ��ǩ
	public JLabel perPriceLab;		//�˼���ʾ��ǩ
	public JTextField priceFiled;	//�˼������
	public JPanel priceP;			//�˼����
	public JPanel imgP;				//���ͼƬ���
	public JPanel labLP;			//������
	public JPanel labNP;			//�������
	public JFileChooser chooser;	//ѡ��Ҫ��ӵ�ͼƬ
	public String imgFileP;			//ѡ��򿪵�ͼƬ�ļ���·��
	public JButton submitBtn;		//ȷ���ύ��ť
	public JButton cancelBtn;		//ȡ����ť
	public int curLabNo;			//��ǰ��Ʒ��Ӧ�����Ŀ�ı��
	public int curPerNo;			//��ǰ��Ʒ�ǵڼ���
	public MyPanelMidKindArray midC;//ʢ���м������������
	public MyPanelMidBottom midB;	//ʢ���·������������
	public DataProcess DP;			//�����������ò����������
	public int itemAllNum;			//���ÿһ����Ŀ��Ӧ�Ĳ˵�����Ŀ
	
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
		//************���ھ���*******************
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		int w = rect.width;
		int h = rect.height;
		this.setBounds((w - width) / 2, (h - height) / 2, width, height);
		//**************************************
		setLayout(null);
		setTitle("��Ʒ���");
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
		levLab.setText("���ÿ�棺");
		leaveField.setColumns(8);
		labLP.setBounds(200, 10, 100, 60);
		
		
		labNP.add(perNameLab);
		labNP.add(perNameFiled);
		perNameLab.setText("������Ʒ����");
		perNameFiled.setColumns(8);
		labNP.setBounds(200, 65, 100, 60);
		
		priceP.add(perPriceLab);
		perPriceLab.setText("������Ʒ�۸�");
		priceP.add(priceFiled);
		priceFiled.setColumns(8);
		priceP.setBounds(200, 120, 100, 60);
		
		
		submitBtn = new JButton("ȷ���ύ");
		cancelBtn = new JButton("ȡ��");
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
	
	public void closeDialogAL(){				//�رնԻ����¼�
		
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
	
	public void addCancelAL(){					//Ϊȡ����ť���
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
	
	public void addSubmitAL(){					//δȷ���ύ��ť��ӵ���¼�
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
	public void flushMidCB(){				//ˢ���м����͵ײ����
		
		DP.init();
		
		//**********�����м����**********
		midC.removeAll();
		midC.reInit(PCV.curLabNo);
		midC.MPMA[PCV.curLabNo].restLayoutMAOI(0);		//�������logoˢ�£���������ѡ�е��м����	
		System.out.println(PCV.curLabNo);
		//*******************************
		
		//*********�����·����***********
		midB.setCurPage(1);
		midB.setLabelText();
		midB.updateUI();
		//*******************************
		
		PCV.buyList = new ArrayList<>();
		PCV.buyTotalList = new ArrayList<>();
	}
	public void addImgPanelAL(){				//Ϊ���ͼƬ����¼�
		
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
