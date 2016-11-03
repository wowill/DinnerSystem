package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataProcess {
	
	public int[] perAllNumA;			//整数数组存放左侧每一个条目对应的菜的总数目
	public int[] panelNumA;				//左侧每一个条目对应的中间区域分页总数
	public boolean haveRecL = false;	//判断是否需要刷新左边列表
	public boolean haveRecM = false;	//判断是否需要刷新中间面板
	public ArrayList<Double> pointPer;	//存放要更改的每一道菜的数据
	public ArrayList<String> recLl;		//左侧列表需要刷新的更新数据
	public int kindNum;					//左侧条目的数量
	
	public DataProcess() {
			
		init();
	}

	public void init() {				//将所有的面板数据初始化
		
		//***********左侧列表数据初始化******
		PCV.AllItemLeft = 8;
		PCV.leftItemString = new String[8];
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			PCV.leftItemString[i] = "测试菜单 "+(i+1);
		}
		
		//***********************************
		
		//*************初始化每一个条目对应的中间面板数据*************
		
		PCV.perDetails = new String[PCV.AllItemLeft];
		String str = "";
		
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			int randX = (int)(Math.random()*30+1);		//随机生成每个条目对应的菜的数目
			str += i + " " + randX + " "; 
			for(int j = 0; j < randX; j++){
				
				for(int k = 0; k < 3; k++){
					
					String price = (int)(Math.random()*50+5)+"."+(int)(Math.random()*9)+""+(int)(Math.random()*9);
					String sold = (int)(Math.random()*100+5) + "";
					String leave = (int)(Math.random()*100+20) + "";
					str += price+" "+sold+" "+leave+" ";
				}
				String imgPath = "/image/000"+(int)(Math.random()*8+1)+".png";
				str += imgPath+" ";
			}
			PCV.perDetails[i] = str;
			str = "";
		}
		//**********************************************************
	}
	
	public void recData(){				//从服务端接收数据
		
		
	}
	
	public void dividRD(){				//对接收的数据进行分类,分别为，左侧列表数据，中间面板数据
		
		
	}
	
	//*************以下方法用于将客户端从数据段获取的数据非配个各个面板，使各个面板完成数据更新*************************************
	public int[] getPerAllNumA() {
		return perAllNumA;
	}

	public void setPerAllNumA(int[] perAllNumA) {
		this.perAllNumA = perAllNumA;
	}

	public int[] getPanelNumA() {
		return panelNumA;
	}

	public void setPanelNumA(int[] panelNumA) {
		this.panelNumA = panelNumA;
	}

	public boolean isHaveRecL() {
		return haveRecL;
	}

	public void setHaveRecL(boolean haveRecL) {
		this.haveRecL = haveRecL;
	}

	public ArrayList<String> getRecLl() {
		return recLl;
	}

	public void setRecLl(ArrayList<String> recLl) {
		this.recLl = recLl;
	}

	public int getKindNum() {
		return kindNum;
	}

	public void setKindNum(int kindNum) {
		this.kindNum = kindNum;
	}

	//**********************************************************************************************************
	
}
