package data;

import javax.swing.ImageIcon;

public class PCV {		//此类用于存放全局使用的变量和常量			
	
	public static int LeftItemId;					//左边列表条目编号
	public static double[][][] perDetails;			//每一个条目对应一个数据三维数组，数组第一维表示LeftItemId,第二维只有一个数据，表示每一道菜的编号,第三维总共有4个数据，分别是价格，购买数目，已售数目
	public static ImageIcon[][][] imgIcon;			//每一个条目对应一个图片二维数组，数组第一维表示LeftItemId，第二维只有一个数据，表示每一道菜的编号，第三维只有一个数据表示图片
	
	
}
