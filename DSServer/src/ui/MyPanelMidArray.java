package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import data.DataProcess;

public class MyPanelMidArray extends JPanel{
	
	public int panelNum;			//中间区域每一个条目含有几页MPM
	public MyPanelMid[] MPM;		//中间区域的的面板数组		
	public int itemAllNum;			//左侧每一个条目对应的菜的总数目
	public int[] evePaneNum;		//每一页存放的菜的数目
	public int indexArr;			//中间显示数据的面板数组的下标
	public int curAllPN;			//当前选中左侧列表的含有中间面板的数目
	public int curLabNo;				//当前选中左侧列表的序号
	public MyPanelMidBottom midB;
	public DataProcess DP;
	public MyPanelMidKindArray mpmka;
	
	public MyPanelMidArray(MyPanelMidKindArray mpmka,MyPanelMidBottom midB,DataProcess DP,int itemAllNum, int curLabNo) {
		
		this.mpmka = mpmka;
		this.midB = midB;
		this.DP = DP;
		this.curLabNo = curLabNo;
		this.itemAllNum = itemAllNum;
		this.panelNum = this.itemAllNum / 9;
		if(this.itemAllNum - this.panelNum * 9 > 0){
			this.panelNum += 1;
		}
		if(this.itemAllNum == 9){
			this.panelNum += 1;
		}
		
		this.evePaneNum = new int[this.panelNum];
		
		MPM = new MyPanelMid[this.panelNum];
		initEve();
		if(this.itemAllNum == 9){
			this.evePaneNum[this.panelNum-1] = 0;
		}
		
		init();
		
	}

	public  void init() {
		indexArr = 0;
		for(int i = 0; i < panelNum; i++){
			
			MPM[i] = new MyPanelMid(mpmka, midB, DP,evePaneNum[i], curLabNo, this.itemAllNum,i);
		}
		MPM[0].setBackground(Color.WHITE);
		restLayouMidArr(MPM[0], this);
		
	}
	
	public void initEve(){				//初始化每页存放的菜的数目的面板
		
		int tempAN = itemAllNum;
		int tempPN = panelNum;
		
		if(tempAN / 9 == 0){
			evePaneNum[0] = tempAN % 9;
			return ;
		}
		for(int i = 0; i < tempPN; i++){
			
			if(tempAN - 9 > 0){
				evePaneNum[i] = 9;
				tempAN -= 9;
			}
			else{
				evePaneNum[i] = tempAN;
			}
		}
		
	}
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//点击切换页面按钮，要重新布局,src要添加到rel面板中
	
		rel.add(src);
		rel.updateUI();
	}
	
	public void restLayoutMAOI(int index){									//重新选定左侧列表对应的中间面板数组的第几页
		
		this.add(MPM[index]);
		this.updateUI();
	}
	public int getPanelNum() {
		return panelNum;
	}

	public void setPanelNum(int panelNum) {
		this.panelNum = panelNum;
	}
	
}
