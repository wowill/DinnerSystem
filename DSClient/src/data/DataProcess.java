package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

		initImgFolderName();
		createFolder(PCV.imgFolder);
		init();
	}

	public void init() {				//将所有的面板数据初始化
		
		
	}
	
	public void initImgFolderName(){					//初始化图片默认存放文件夹路径
		
		PCV.imgFolder = "c:/OrderingClient";
	}
	
	public void createFolder(String fname){				//创建文件夹
		
		File file = new File(fname);
		if(!file.exists()){
			file.mkdirs();
		} 
	}
	
	public void createNewFiles(String name){			//事先为每个图片创建空白文件
		
		File file = new File(name);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void newFileFPath(){				//根据从服务端传来的图片路径创建空白图片文件
		
		for(int i = 0; i < PCV.imgPath.size(); i++){
			
			createNewFiles(PCV.imgPath.get(i));
		}
//		System.out.println("空白图片创建成功!");
	}
	
	public void dataToDiv(){			//把从服务端接收来的字符串数据分配给此客户端
		
		String s[] = PCV.strPerDetails.split(",");
		
		//********存放左侧列表的名字****************
		String sl[] = s[0].split(" ");
		PCV.AllItemLeft = sl.length;
		PCV.leftItemString = new ArrayList<>();
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			PCV.leftItemString.add(sl[i]);
			
		}
		
		//******************************************
		
		
		//**************存放中间面板的数据******************
		PCV.perDetList = new ArrayList<ArrayList<String>>();
		PCV.leftItemOfDN = new ArrayList<>();
		PCV.imgPath = new ArrayList<>();
		
		ArrayList<String> list1 = new ArrayList<>();			//用来临时存放左边列表每个条目对应的所有信息
		
		for(int i = 1; i < s.length; i++){
			list1.clear();
			String sm[] = s[i].split(" ");
			String stm = "";
			PCV.leftItemOfDN.add(Integer.parseInt(sm[1]));
			for(int j = 2; j < sm.length; j += 5){
				stm = "";
				stm += sm[(j+0)]+" ";
				stm += sm[(j+1)]+" ";
				stm += sm[(j+2)]+" ";
				stm += sm[(j+3)]+" ";
				stm += sm[(j+4)]+" ";
				stm = stm.trim();
				list1.add(stm);
				if(uniquePath(sm[(j+4)])){
					PCV.imgPath.add(spTocp(sm[(j+4)]) );
				}
				
			}
			ArrayList<String> slist = new ArrayList<>();
			slist.addAll(list1);
			PCV.perDetList.add(slist);
//			System.out.println("list DP :"+PCV.perDetList.get(i-1).toString() +"     size :"+PCV.perDetList.get(i-1).size());
			
		}
		
		
		newFileFPath();			 //根据传来的图片路径创建空白图片
		
		//********************************************
		PCV.initB = true;
//		System.out.println("jieshu :　"+PCV.perDetList.size());
//		System.out.println(PCV.perDetList.get(0));
	}
	
	public String spTocp(String name){			//把服务端传输来的图片路径转换成客户端的的路径
		
		if(name.contains("/")){
			
		}
		else if(name.contains("\\")){
			name = name.replace("\\", "/");
			
		}
		return  name.replace(name.split("/")[1], "OrderingClient");
		
		
	}
	
	public boolean uniquePath(String name){
		if(name.contains("/")){
			name = name.split("/")[2];
		}
		else if(name.contains("\\")){
			name = name.replace("\\", "/");
			name = name.split("/")[2];
			
		}
		
//		System.out.println("name "+name );
		for(int i = 0; i < PCV.imgPath.size(); i++){
			if(PCV.imgPath.get(i).split("/")[2].equals(name)){
				return false;
			}
		}
		return true;
	}
	
}
