package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.PCV;

public class MyPanelMidBottom extends JPanel{

	public JButton frontBtn;			//上一页按钮
	public JButton nextBtn;				//下一页按钮
	public JLabel pageLab;				//页码信息标签
	private int allPageNum;				//页码总数
	private int curPage;				//当前页码
	public JLabel curAPriceLab;			//当前已购物品的价格的标签
	public String curAllPrice;			//当前已购物品的价格
	public JLabel spaceLab;				//空白标签
	public JLabel spaceLab2;			//空白标签
	
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
		curAPriceLab = new JLabel();
		spaceLab = new JLabel("　　　　　　　　　　");
		spaceLab2 = new JLabel("　　　　　　　　　　");
		curAllPrice = "";
		curAPriceLab.setText(String.format("已消费：￥%4.2f", 0.0));
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
	
	public void setPriceLabText(){			//设置已购价格标签内容
		double price = 0.0;
		for(int i = 0; i < PCV.buyList.size(); i++){
			String[] st = PCV.buyList.get(i).split(" ");
			int lId = Integer.parseInt(st[0]);			//对应左侧列表编号
			int pId = Integer.parseInt(st[1]);			//对应中间面板第几道菜
			int pNum = Integer.parseInt(st[2]);			//购买每道菜的数量
			String[] stt = PCV.perDetList.get(lId).get(pId).split(" ");
			String perName = stt[0];
			double perPrice = Double.parseDouble(stt[1]);
			price += perPrice*pNum;
		}
		curAPriceLab.setText(String.format("已消费：￥%4.2f", price));
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
