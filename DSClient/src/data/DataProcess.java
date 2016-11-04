package data;

import java.io.BufferedReader;
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
	public int[] toSelect;				//��ѯָ������������
	
	
	public DataProcess() {
			
		init();
	}

	public void init() {				//�����е�������ݳ�ʼ��
		
		dataToDiv();
	}
	
	
	public void dataToDiv(){			//�Ѵӷ���˽��������ַ������ݷ�����˿ͻ���
		
		String s[] = PCV.strPerDetails.split(System.getProperty("line.separator"));
		
		//********�������б������****************
		String sl[] = s[0].split(" ");
		PCV.AllItemLeft = sl.length;
		PCV.leftItemString = new ArrayList<>();
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			PCV.leftItemString.add(sl[i]);
		}
		
		//**************************************
		
		
		//**************����м���������*************
		PCV.perDetList = new ArrayList<ArrayList<String>>();
		PCV.leftItemOfDN = new ArrayList<>();
		PCV.imgPath = new ArrayList<>();
		
		ArrayList<String> list = new ArrayList<>();			//������ʱ�������б�ÿ����Ŀ��Ӧ��������Ϣ
		
		for(int i = 1; i < s.length; i++){
			
			String sm[] = s[i].split(" ");
			String stm = "";
			PCV.leftItemOfDN.add(Integer.parseInt(sm[1]));
			for(int j = 2; j < sm.length; j += 5){
				stm = "";
				stm += sm[(j+0-2)]+" ";
				stm += sm[(j+1-2)]+" ";
				stm += sm[(j+2-2)]+" ";
				stm += sm[(j+3-2)]+" ";
				stm += sm[(j+4-2)]+" ";
				stm = stm.trim();
				list.add(stm);
				PCV.imgPath.add(sm[(j+4-2)]);
			}
			PCV.perDetList.add(list);
			
			list.clear();
		}
		
		//********************************************
		
	}
	
	
	
}
