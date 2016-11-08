package data;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PCV {		//此类用于存放全局使用的变量和常量			
	
	public static int AllItemLeft;										//左边条目总数量
//	public static ArrayList<Integer> leftItemId;						//左边列表条目编号
	public static ArrayList<String> leftItemString;						//左侧列表的数据
	public static ArrayList<String> perDetails;							//每一个条目对应的所有的信息
//	public static ArrayList<ImageIcon> imgIcon;							//每一个条目对应一个图片信息
	public static ArrayList<Integer> leftItemOfDN;						//左边列表每一个条目对应的菜的数量
	public static ArrayList<ArrayList<String>> perDetList;				//左边列表每一个条目对应的信息用列表存储
	public static StringBuilder sendSB;									//发送给客户端的封装好的字符串数据
	public static ArrayList<File> fileList;								//存储要发送给客户端的图片数据
	public static String imgFolder;										//图片默认存放文件夹路径
	public static String commitStat;									//提交客户端用户更新数据库数据的返回信息
	public static int curLabNo = 0;										//当前左侧列表的编号
	public static int curMPNo = 0;										//当前中间面板所在页码
	public static String SPLINE = System.getProperty("line.separator");	//换行符
	public static String sendStrFC;										//服务端补给提示信息
	public static ArrayList<String> buyList = new ArrayList<>();							//服务端的补给信息 , 格式"条目id 菜id 购买数量"
}
