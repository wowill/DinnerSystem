package data;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PCV {		//�������ڴ��ȫ��ʹ�õı����ͳ���			
	
	public static int AllItemLeft;							//�����Ŀ������
//	public static ArrayList<Integer> leftItemId;			//����б���Ŀ���
	public static ArrayList<String> leftItemString;			//����б������
	public static ArrayList<String> perDetails;				//ÿһ����Ŀ��Ӧ�����е���Ϣ
//	public static ArrayList<ImageIcon> imgIcon;				//ÿһ����Ŀ��Ӧһ��ͼƬ��Ϣ
	public static ArrayList<Integer> leftItemOfDN;			//����б�ÿһ����Ŀ��Ӧ�Ĳ˵�����
	public static ArrayList<ArrayList<String>> perDetList;	//����б�ÿһ����Ŀ��Ӧ����Ϣ���б�洢
	public static String strPerDetails;						//ÿһ����Ŀ��Ӧ�����е���Ϣ,�ַ����洢
	public static ArrayList<String> imgPath;				//ÿ��ͼƬ��·��
	public static String imgFolder;							//ͼƬĬ�ϴ���ļ���·��
	public static boolean initB = false;					//�ж��Ƿ���н����ʼ��
	public static ArrayList<Integer> buyPerIdList;			//������Ʒ�ı���б�
	public static ArrayList<Double> buyNumList;				//������Ʒ���������
	public static ArrayList<Integer> buyItemIdList;			//������Ʒ��Ӧ�������Ŀ�ı���б�
	public static ArrayList<String> buyList;				//������Ʒ�б� , ��ʽ"��Ŀid ��id ��������"
	public static int curLabNo = 0;								//��ǰ����б�ı��
	public static int curMPNo = 0;								//��ǰ�м��������ҳ��
}
