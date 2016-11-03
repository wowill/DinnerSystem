package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelMidBottom extends JPanel{

	public JButton frontBtn;			//上一页按钮
	public JButton nextBtn;				//下一页按钮
	public JLabel pageLab;				//页码信息标签
	private int allPageNum;				//页码总数
	private int curPage;				//当前页码
	
	
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
		frontBtn = new JButton("上一张");
		nextBtn = new JButton("下一张");
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
