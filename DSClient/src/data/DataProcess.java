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
	public Map<String, Map<String, ArrayList<String>>> map = new HashMap<String, Map<String,ArrayList<String>>>();

	public DataProcess() {
		
		init();
	}

	public void init() {
		
		
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
