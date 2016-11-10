package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.PCV;

public class MyPanelMidBottom extends JPanel{

	public JButton frontBtn;			//��һҳ��ť
	public JButton nextBtn;				//��һҳ��ť
	public JLabel pageLab;				//ҳ����Ϣ��ǩ
	private int allPageNum;				//ҳ������
	private int curPage;				//��ǰҳ��
	public JLabel curAPriceLab;			//��ǰ�ѹ���Ʒ�ļ۸�ı�ǩ
	public String curAllPrice;			//��ǰ�ѹ���Ʒ�ļ۸�
	public JLabel spaceLab;				//�հױ�ǩ
	public JLabel spaceLab2;			//�հױ�ǩ
	
	public MyPanelMidBottom()
	{
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setBackground(Color.WHITE);
		mackPanel();
	}
	public void mackPanel(){
		frontBtn = new JButton("��һ��");
		nextBtn = new JButton("��һ��");
		pageLab = new JLabel();
		curAPriceLab = new JLabel();
		spaceLab = new JLabel("��������������������");
		spaceLab2 = new JLabel("��������������������");
		curAllPrice = "";
		curAPriceLab.setText(String.format("�����ѣ���%4.2f", 0.0));
		curAPriceLab.setForeground(Color.RED);
		frontBtn.setContentAreaFilled(false);
		nextBtn.setContentAreaFilled(false);
		this.add(spaceLab);
		this.add(frontBtn);
		this.add(nextBtn);
		this.add(pageLab);
		this.add(spaceLab2);
		this.add(curAPriceLab);
	}
	
	public void setPriceLabText(){			//�����ѹ��۸��ǩ����
		double price = 0.0;
		for(int i = 0; i < PCV.buyList.size(); i++){
			String[] st = PCV.buyList.get(i).split(" ");
			int lId = Integer.parseInt(st[0]);			//��Ӧ����б���
			int pId = Integer.parseInt(st[1]);			//��Ӧ�м����ڼ�����
			int pNum = Integer.parseInt(st[2]);			//����ÿ���˵�����
			String[] stt = PCV.perDetList.get(lId).get(pId).split(" ");
			String perName = stt[0];
			double perPrice = Double.parseDouble(stt[1]);
			price += perPrice*pNum;
		}
		curAPriceLab.setText(String.format("�����ѣ���%4.2f", price));
		curAPriceLab.setForeground(Color.RED);
	}
	
	public void setLabelText(){
		pageLab.setText(curPage+"/"+allPageNum);
	}
	
	public int getAllPageNum() {
		return allPageNum;
	}

	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
}
