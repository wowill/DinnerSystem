package data;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PCV {		//此类用于存放全局使用的变量和常量			
	
	public static int AllItemLeft;							//左边条目总数量
//	public static ArrayList<Integer> leftItemId;			//左边列表条目编号
	public static ArrayList<String> leftItemString;			//左侧列表的数据
	public static ArrayList<String> perDetails;				//每一个条目对应的所有的信息
//	public static ArrayList<ImageIcon> imgIcon;				//每一个条目对应一个图片信息
	public static ArrayList<Integer> leftItemOfDN;			//左边列表每一个条目对应的菜的数量
	public static ArrayList<ArrayList<String>> perDetList;	//左边列表每一个条目对应的信息用列表存储
	public static String strPerDetails;						//每一个条目对应的所有的信息,字符串存储
	public static ArrayList<String> imgPath;				//每张图片的路径
	public static String imgFolder;							//图片默认存放文件夹路径
	public static boolean initB = false;					//判断是否进行界面初始化
	public static ArrayList<Integer> buyPerIdList;			//购买物品的编号列表
	public static ArrayList<Double> buyNumList;				//购买物品的数量编号
	public static ArrayList<Integer> buyItemIdList;			//购买物品对应的左侧条目的编号列表
	public static ArrayList<String> buyList;				//购买物品列表 , 格式"条目id 菜id 购买数量"
	public static int curLabNo = 0;								//当前左侧列表的编号
	public static int curMPNo = 0;								//当前中间面板所在页码
}
