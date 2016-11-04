package data;

import java.io.BufferedReader;
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
	public int[] toSelect;				//查询指定列数的数组
	
	
	public DataProcess() {
			
		init();
	}

	public void init() {				//将所有的面板数据初始化
		
		dataToDiv();
	}
	
	
	public void dataToDiv(){			//把从服务端接收来的字符串数据分配给此客户端
		
		String s[] = PCV.strPerDetails.split(System.getProperty("line.separator"));
		
		//********存放左侧列表的名字****************
		String sl[] = s[0].split(" ");
		PCV.AllItemLeft = sl.length;
		PCV.leftItemString = new ArrayList<>();
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			PCV.leftItemString.add(sl[i]);
		}
		
		//**************************************
		
		
		//**************存放中间面板的数据*************
		PCV.perDetList = new ArrayList<ArrayList<String>>();
		PCV.leftItemOfDN = new ArrayList<>();
		PCV.imgPath = new ArrayList<>();
		
		ArrayList<String> list = new ArrayList<>();			//用来临时存放左边列表每个条目对应的所有信息
		
		for(int i = 1; i < s.length; i++){
			
			String sm[] = s[i].split(" ");
			String stm = "";
			PCV.leftItemOfDN.add(Integer.parseInt(sm[1]));
			for(int j = 2; j < sm.length; j += 5){
				stm = "";
				stm += sm[(j+0-2)]+" ";
				stm += sm[(j+1-2)]+" ";
				stm += sm[(j+2-2)]+" ";
				stm += sm[(j+3-2)]+" ";
				stm += sm[(j+4-2)]+" ";
				stm = stm.trim();
				list.add(stm);
				PCV.imgPath.add(sm[(j+4-2)]);
			}
			PCV.perDetList.add(list);
			
			list.clear();
		}
		
		//********************************************
		
	}
	
	
	
}
