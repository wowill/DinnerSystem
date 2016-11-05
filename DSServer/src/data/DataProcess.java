package data;

import java.io.File;
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
	public SqlServerDao DAO;			//数据库工具类
	public int[] toSelect;				//查询指定列数的数组
	
	
	public DataProcess() {
		
		initImgFolderName();
		createFolder(PCV.imgFolder);
		init();
	}

	public void init() {				//将所有的面板数据初始化
		
		PCV.sendSB = new StringBuilder();
		
		//***********实例化数据库工具类*************
		DAO = new SqlServerDao();
		
		//*****************************************
		
		//***********左侧列表数据初始化******
		toSelect = new int[1];
		toSelect[0] = 2;
		String sql = "select * from LeftItem";
		PCV.leftItemString = DAO.select(sql, toSelect);
		
		PCV.AllItemLeft = PCV.leftItemString.size();

		//********左侧列表条目封装到StringBuilder里*****
		
		String sTT = "";
		for(int i = 0; i < PCV.AllItemLeft; i++){
			sTT += PCV.leftItemString.get(i)+" ";
		}
		sTT = sTT.trim()+ System.getProperty("line.separator");
		PCV.sendSB.append(sTT);
		//*********************************************
		
		
		//***********************************
		
		//*************初始化每一个条目对应的中间面板数据*************
		
		
		
		toSelect = new int[5];
		for(int i = 0; i < 5; i++){
			toSelect[i] = i+2;
		}
		
		PCV.perDetails = new ArrayList<>();
		PCV.perDetList = new ArrayList<ArrayList<String>>();
		PCV.leftItemOfDN = new ArrayList<>();
		PCV.fileList = new ArrayList<>();
		
		String str = "";
		
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			ArrayList<String> list;
			sql = "select * from ItemToDetails where ItemID = " + (i+1);
			list = DAO.select(sql, toSelect);
			PCV.leftItemOfDN.add(list.size());
			int randX = list.size();		//每个条目对应菜的数目，从数据库获取
			str += i + " " + randX + " "; 
			for(int j = 0; j < randX; j++){
				
				String sa[] = list.get(j).split(" ");
				
				str += list.get(j)+" ";
				if(!PCV.fileList.contains(sa[4])){
					
					PCV.fileList.add(new File(""+this.getClass().getResource(sa[4])));
				} 
				
				
			}
			str = str.trim();
			
			PCV.sendSB.append(str + System.getProperty("line.separator"));
			PCV.perDetails.add(str);
			PCV.perDetList.add(list);
			str = "";
		}
		 System.out.println(PCV.sendSB.toString());
		 
		//**********************************************************
	}
	
	public void initImgFolderName(){					//初始化图片默认存放文件夹路径
		
		PCV.imgFolder = "c:/OrderingImages";
	}
	
	public void createFolder(String fname){				//创建文件夹
		
		File file = new File(fname);
		if(!file.exists()){
			file.mkdirs();
		} 
	}
	
	
}
