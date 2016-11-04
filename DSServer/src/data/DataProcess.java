package data;

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
			
		init();
	}

	public void init() {				//�����е�������ݳ�ʼ��
		
		//***********ʵ�������ݿ⹤����*************
		DAO = new SqlServerDao();
		
		//*****************************************
		
		//***********����б����ݳ�ʼ��******
		toSelect = new int[1];
		toSelect[0] = 2;
		String sql = "select * from LeftItem";
		PCV.leftItemString = DAO.select(sql, toSelect);
		
		PCV.AllItemLeft = PCV.leftItemString.size();

		
		//***********************************
		
		//*************��ʼ��ÿһ����Ŀ��Ӧ���м��������*************
		
		PCV.sendSB = new StringBuilder();
		
		toSelect = new int[5];
		for(int i = 0; i < 5; i++){
			toSelect[i] = i+2;
		}
		
		PCV.perDetails = new ArrayList<>();
		PCV.perDetList = new ArrayList<ArrayList<String>>();
		PCV.leftItemOfDN = new ArrayList<>();
		
		String str = "";
		
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			ArrayList<String> list;
			sql = "select * from ItemToDetails where ItemID = " + (i+1);
			list = DAO.select(sql, toSelect);
			PCV.leftItemOfDN.add(list.size());
			int randX = list.size();		//ÿ����Ŀ��Ӧ�˵���Ŀ�������ݿ��ȡ
			str += i + " " + randX + " "; 
			for(int j = 0; j < randX; j++){
				
				str += list.get(j)+" ";
				
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
	
	//*************���·������ڽ��ӿͻ��˷��ص����ݷ����������壬ʹ�������������ݸ���*************************************
	public int[] getPerAllNumA() {
		return perAllNumA;
	}

	public void setPerAllNumA(int[] perAllNumA) {
		this.perAllNumA = perAllNumA;
	}

	public int[] getPanelNumA() {
		return panelNumA;
	}

	public void setPanelNumA(int[] panelNumA) {
		this.panelNumA = panelNumA;
	}

	public boolean isHaveRecL() {
		return haveRecL;
	}

	public void setHaveRecL(boolean haveRecL) {
		this.haveRecL = haveRecL;
	}

	public ArrayList<String> getRecLl() {
		return recLl;
	}

	public void setRecLl(ArrayList<String> recLl) {
		this.recLl = recLl;
	}

	public int getKindNum() {
		return kindNum;
	}

	public void setKindNum(int kindNum) {
		this.kindNum = kindNum;
	}

	//**********************************************************************************************************
	
}
