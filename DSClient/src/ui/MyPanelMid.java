package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.PCV;

public class MyPanelMid extends JPanel{

	int MPP_HEIGHT = 190;		//ÿһ���˶�Ӧ��panel�ĸ�
	int MPP_WIDTH = 160;		//ÿһ���˶�Ӧ��panel�Ŀ�
	MyPanelPer[] MPP;			//ÿһ���˶�Ӧ��panel
	public int perAllNum;		//���ÿһ����Ŀ��Ӧ�Ĳ˵�����Ŀ
	public int perItemLeave;	//���ÿһ����Ŀ��Ӧ��ÿһ���˵�ʣ��ʣ������
	public double perItemPrice;	//���ÿһ����Ŀ��Ӧ��ûһ���˵ļ۸�
	GridBagLayout gbLayout;		//��Ʋ��ַ�ʽ
	GridBagConstraints s;		//��Ʋ��ַ�ʽ
	public int curLabNo;		//��ǰѡ������б�����
	public JPanel spaP;			//�հ����
	public JLabel blankLab;		//��ſհ�ͼƬ�ı�ǩ
	public int pageNo;			//��ǰҳ���ǵڼ�ҳ
	public MyPanelMidBottom midB;	//�²���壬��Ҫ����ʵʱ�����ѹ���Ʒ�۸�
	
	public MyPanelMid(int perAllNum, int curLabNo, int pageNo,MyPanelMidBottom midB) {
		
		this.midB = midB;
		this.pageNo = pageNo;
//		System.out.println("cyr" + curLabNo);
		this.curLabNo = curLabNo;
		this.perAllNum = perAllNum;
		MPP = new MyPanelPer[perAllNum];
		init();
	}

	public void init() {
		
		this.setBackground(Color.WHITE);
		//********��Ʋ��ַ�ʽ**********
		gbLayout = new GridBagLayout();
		setLayout(gbLayout);
		s = new GridBagConstraints();
		//***************************
		
		//***********��ÿ���б��Ӧ��Ŀ��ÿ���˵���Ϣ�浽һ��list***********
		ArrayList<String> listm = new ArrayList<>();
		listm.addAll( PCV.perDetList.get(curLabNo));
		//****************************************************************
		
		
		for(int i = 0; i < perAllNum; i++){
			
			MPP[i] = new MyPanelPer(listm, i, curLabNo, pageNo,midB);
			restLayouMidArr(MPP[i], this, i);
		}
		if(perAllNum < 9 && perAllNum > 0){
			
			if(perAllNum % 9 == 2){
				addBlank();
				restLayouMidArr(spaP,this,perAllNum+1);
			}
			if(perAllNum % 9 == 1){
				addBlank();
				restLayouMidArr(spaP,this,perAllNum+1);
				addBlank();
				restLayouMidArr(spaP,this,perAllNum+2);
			}

		}
	}
	
	public void addBlank(){																//��ӿհ�����
		spaP = new JPanel();
		
		blankLab = new JLabel();
		try {
			blankLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/blank.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spaP.setSize(175, 160);
		blankLab = new JLabel();
		try {
			blankLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/blank.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spaP.add(blankLab);
		spaP.setBackground(Color.WHITE);
		this.add(spaP);
	}
	
	public void restLayouMidArr(JPanel src, JPanel rel, int i){							//����л�ҳ�水ť��Ҫ���²���,srcҪ��ӵ�rel�����
		
		s.ipadx = 15;
		s.ipady = 5;
		s.gridx = i % 3;
		s.gridy = i / 3;
		s.gridwidth = 1;
		s.gridheight = 1;
		s.weightx = 1;
		s.weighty = 1;
		if(i % 3 == 2){
			s.weightx = 0;
		}
		if(i >= 5 && i <= 8){
			s.weighty = 0;
		}
		gbLayout.setConstraints(src, s);
		
		rel.add(src);
	}
	
	public int getPerAllNum() {
		return perAllNum;
	}

	public void setPerAllNum(int perAllNum) {
		this.perAllNum = perAllNum;
	}

}
