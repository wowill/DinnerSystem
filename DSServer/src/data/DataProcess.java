package data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataProcess {
	
	public int[] perAllNumA;			//�������������ÿһ����Ŀ��Ӧ�Ĳ˵�����Ŀ
	public int[] panelNumA;				//���ÿһ����Ŀ��Ӧ���м������ҳ����
	public boolean haveRecL = false;	//�ж��Ƿ���Ҫˢ������б�
	public boolean haveRecM = false;	//�ж��Ƿ���Ҫˢ���м����
	public ArrayList<Double> pointPer;	//���Ҫ���ĵ�ÿһ���˵�����
	public ArrayList<String> recLl;		//����б���Ҫˢ�µĸ�������
	public int kindNum;					//�����Ŀ������
	public SqlServerDao DAO;			//���ݿ⹤����
	public int[] toSelect;				//��ѯָ������������
	
	
	public DataProcess() {
		
		initImgFolderName();
		createFolder(PCV.imgFolder);
		init();
	}

	public void init() {				//�����е�������ݳ�ʼ��
		
		PCV.sendSB = new StringBuilder();
		
		//***********ʵ�������ݿ⹤����*************
		DAO = new SqlServerDao();
		
		//*****************************************
		
		//***********����б����ݳ�ʼ��******
		toSelect = new int[1];
		toSelect[0] = 2;
		String sql = "select * from LeftItem";
		PCV.leftItemString = DAO.select(sql, toSelect);
		
		PCV.AllItemLeft = PCV.leftItemString.size();

		//********����б���Ŀ��װ��StringBuilder��*****
		
		String sTT = "";
		for(int i = 0; i < PCV.AllItemLeft; i++){
			sTT += PCV.leftItemString.get(i)+" ";
		}
		sTT = sTT.trim()+ System.getProperty("line.separator");
		PCV.sendSB.append(sTT);
		//*********************************************
		
		
		//***********************************
		
		//*************��ʼ��ÿһ����Ŀ��Ӧ���м��������*************
		
		
		
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
			int randX = list.size();		//ÿ����Ŀ��Ӧ�˵���Ŀ�������ݿ��ȡ
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
	
	public void initImgFolderName(){					//��ʼ��ͼƬĬ�ϴ���ļ���·��
		
		PCV.imgFolder = "c:/OrderingImages";
	}
	
	public void createFolder(String fname){				//�����ļ���
		
		File file = new File(fname);
		if(!file.exists()){
			file.mkdirs();
		} 
	}
	
	
}
