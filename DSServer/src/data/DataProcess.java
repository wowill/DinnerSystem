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
	
	public DataProcess() {
			
		init();
	}

	public void init() {				//�����е�������ݳ�ʼ��
		
		//***********����б����ݳ�ʼ��******
		PCV.AllItemLeft = 8;
		PCV.leftItemString = new String[8];
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			PCV.leftItemString[i] = "���Բ˵� "+(i+1);
		}
		
		//***********************************
		
		//*************��ʼ��ÿһ����Ŀ��Ӧ���м��������*************
		
		PCV.perDetails = new String[PCV.AllItemLeft];
		String str = "";
		
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			int randX = (int)(Math.random()*30+1);		//�������ÿ����Ŀ��Ӧ�Ĳ˵���Ŀ
			str += i + " " + randX + " "; 
			for(int j = 0; j < randX; j++){
				
				for(int k = 0; k < 3; k++){
					
					String price = (int)(Math.random()*50+5)+"."+(int)(Math.random()*9)+""+(int)(Math.random()*9);
					String sold = (int)(Math.random()*100+5) + "";
					String leave = (int)(Math.random()*100+20) + "";
					str += price+" "+sold+" "+leave+" ";
				}
				String imgPath = "/image/000"+(int)(Math.random()*8+1)+".png";
				str += imgPath+" ";
			}
			PCV.perDetails[i] = str;
			str = "";
		}
		//**********************************************************
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
