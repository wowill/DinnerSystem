package data;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PCV {		//此类用于存放全局使用的变量和常量			
	
	public static int AllItemLeft;							//左边条目总数量
	public static ArrayList<Integer> leftItemId;			//左边列表条目编号
	public static ArrayList<String> leftItemString;			//左侧列表的数据
	public static ArrayList<String> perDetails;				//每一个条目对应的所有的信息
	public static ArrayList<ImageIcon> imgIcon;				//每一个条目对应一个图片信息
	public static ArrayList<Integer> leftItemOfDN;			//左边列表每一个条目对应的菜的数量
	public static ArrayList<ArrayList<String>> perDetList;	//左边列表每一个条目对应的信息用列表存储
	public static String strPerDetails;						//每一个条目对应的所有的信息,字符串存储
	public static ArrayList<String> imgPath;				//每张图片的路径
}
