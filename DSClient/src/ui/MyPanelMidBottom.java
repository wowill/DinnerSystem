package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelMidBottom extends JPanel{

	public JButton frontBtn;			//��һҳ��ť
	public JButton nextBtn;				//��һҳ��ť
	public JLabel pageLab;				//ҳ����Ϣ��ǩ
	private int allPageNum;				//ҳ������
	private int curPage;				//��ǰҳ��
	
	
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
		frontBtn.setContentAreaFilled(false);
		nextBtn.setContentAreaFilled(false);
		this.add(frontBtn);
		this.add(nextBtn);
		this.add(pageLab);
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
