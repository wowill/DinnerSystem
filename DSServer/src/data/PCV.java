package data;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PCV {		//�������ڴ��ȫ��ʹ�õı����ͳ���			
	
	public static int AllItemLeft;										//�����Ŀ������
//	public static ArrayList<Integer> leftItemId;						//����б���Ŀ���
	public static ArrayList<String> leftItemString;						//����б������
	public static ArrayList<String> perDetails;							//ÿһ����Ŀ��Ӧ�����е���Ϣ
//	public static ArrayList<ImageIcon> imgIcon;							//ÿһ����Ŀ��Ӧһ��ͼƬ��Ϣ
	public static ArrayList<Integer> leftItemOfDN;						//����б�ÿһ����Ŀ��Ӧ�Ĳ˵�����
	public static ArrayList<ArrayList<String>> perDetList;				//����б�ÿһ����Ŀ��Ӧ����Ϣ���б�洢
	public static StringBuilder sendSB;									//���͸��ͻ��˵ķ�װ�õ��ַ�������
	public static ArrayList<File> fileList;								//�洢Ҫ���͸��ͻ��˵�ͼƬ����
	public static String imgFolder;										//ͼƬĬ�ϴ���ļ���·��
	public static String commitStat;									//�ύ�ͻ����û��������ݿ����ݵķ�����Ϣ
	public static int curLabNo = 0;										//��ǰ����б�ı��
	public static int curMPNo = 0;										//��ǰ�м��������ҳ��
	public static String SPLINE = System.getProperty("line.separator");	//���з�
	public static String sendStrFC;										//����˲�����ʾ��Ϣ
	public static ArrayList<String> buyList = new ArrayList<>();							//����˵Ĳ�����Ϣ , ��ʽ"��Ŀid ��id ��������"
}
