package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
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

		initImgFolderName();
		createFolder(PCV.imgFolder);
		init();
	}

	public void init() {				//�����е�������ݳ�ʼ��
		
		
	}
	
	public void initImgFolderName(){					//��ʼ��ͼƬĬ�ϴ���ļ���·��
		
		PCV.imgFolder = "c:/OrderingClient";
	}
	
	public void createFolder(String fname){				//�����ļ���
		
		File file = new File(fname);
		if(!file.exists()){
			file.mkdirs();
		} 
	}
	
	public void createNewFiles(String name){			//����Ϊÿ��ͼƬ�����հ��ļ�
		
		File file = new File(name);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void newFileFPath(){				//���ݴӷ���˴�����ͼƬ·�������հ�ͼƬ�ļ�
		
		for(int i = 0; i < PCV.imgPath.size(); i++){
			
			createNewFiles(PCV.imgPath.get(i));
		}
		System.out.println("�հ�ͼƬ�����ɹ�!");
	}
	
	public void dataToDiv(){			//�Ѵӷ���˽��������ַ������ݷ�����˿ͻ���
		
		String s[] = PCV.strPerDetails.split(",");
		
		//********�������б������****************
		String sl[] = s[0].split(" ");
		PCV.AllItemLeft = sl.length;
		PCV.leftItemString = new ArrayList<>();
		for(int i = 0; i < PCV.AllItemLeft; i++){
			
			PCV.leftItemString.add(sl[i]);
			
		}
		
		//******************************************
		
		
		//**************����м���������******************
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
				stm += sm[(j+0)]+" ";
				stm += sm[(j+1)]+" ";
				stm += sm[(j+2)]+" ";
				stm += sm[(j+3)]+" ";
				stm += sm[(j+4)]+" ";
				stm = stm.trim();
				list.add(stm);
				if(uniquePath(sm[(j+4)])){
					PCV.imgPath.add(spTocp(sm[(j+4)]) );
				}
				
			}
			PCV.perDetList.add(list);
			
			list.clear();
		}
		
		newFileFPath();			 //���ݴ�����ͼƬ·�������հ�ͼƬ
		
		//********************************************
		
	}
	
	public String spTocp(String name){			//�ѷ���˴�������ͼƬ·��ת���ɿͻ��˵ĵ�·��
		
		return  name.replace(name.split("/")[1], "OrderingClient");
		
		
	}
	
	public boolean uniquePath(String name){
		
		name = name.split("/")[2];
//		System.out.println("name "+name );
		for(int i = 0; i < PCV.imgPath.size(); i++){
			if(PCV.imgPath.get(i).split("/")[2].equals(name)){
				return false;
			}
		}
		return true;
	}
	
}
