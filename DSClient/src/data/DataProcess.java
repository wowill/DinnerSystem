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
	public Map<String, Map<String, ArrayList<String>>> map = new HashMap<String, Map<String,ArrayList<String>>>();

	public DataProcess() {
		
		init();
	}

	public void init() {
		
		
	}
	
	public void recData(){				//�ӷ���˽�������
		
		
	}
	
	public void dividRD(){				//�Խ��յ����ݽ��з���,�ֱ�Ϊ������б����ݣ��м��������
		
		
	}
	
	//*************���·������ڽ��ͻ��˴����ݶλ�ȡ�����ݷ����������壬ʹ�������������ݸ���*************************************
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
