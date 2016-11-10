package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import data.DataProcess;

public class MyPanelMidArray extends JPanel{
	
	public int panelNum;			//�м�����ÿһ����Ŀ���м�ҳMPM
	public MyPanelMid[] MPM;		//�м�����ĵ��������		
	public int itemAllNum;			//���ÿһ����Ŀ��Ӧ�Ĳ˵�����Ŀ
	public int[] evePaneNum;		//ÿһҳ��ŵĲ˵���Ŀ
	public int indexArr;			//�м���ʾ���ݵ����������±�
	public int curAllPN;			//��ǰѡ������б�ĺ����м�������Ŀ
	public int curLabNo;				//��ǰѡ������б�����
	public MyPanelMidBottom midB;
	public DataProcess DP;
	public MyPanelMidKindArray mpmka;
	
	public MyPanelMidArray(MyPanelMidKindArray mpmka,MyPanelMidBottom midB,DataProcess DP,int itemAllNum, int curLabNo) {
		
		this.mpmka = mpmka;
		this.midB = midB;
		this.DP = DP;
		this.curLabNo = curLabNo;
		this.itemAllNum = itemAllNum;
		this.panelNum = this.itemAllNum / 9;
		if(this.itemAllNum - this.panelNum * 9 > 0){
			this.panelNum += 1;
		}
		if(this.itemAllNum == 9){
			this.panelNum += 1;
		}
		
		this.evePaneNum = new int[this.panelNum];
		
		MPM = new MyPanelMid[this.panelNum];
		initEve();
		if(this.itemAllNum == 9){
			this.evePaneNum[this.panelNum-1] = 0;
		}
		
		init();
		
	}

	public  void init() {
		indexArr = 0;
		for(int i = 0; i < panelNum; i++){
			
			MPM[i] = new MyPanelMid(mpmka, midB, DP,evePaneNum[i], curLabNo, this.itemAllNum,i);
		}
		MPM[0].setBackground(Color.WHITE);
		restLayouMidArr(MPM[0], this);
		
	}
	
	public void initEve(){				//��ʼ��ÿҳ��ŵĲ˵���Ŀ�����
		
		int tempAN = itemAllNum;
		int tempPN = panelNum;
		
		if(tempAN / 9 == 0){
			evePaneNum[0] = tempAN % 9;
			return ;
		}
		for(int i = 0; i < tempPN; i++){
			
			if(tempAN - 9 > 0){
				evePaneNum[i] = 9;
				tempAN -= 9;
			}
			else{
				evePaneNum[i] = tempAN;
			}
		}
		
	}
	
	public void restLayouMidArr(JPanel src, JPanel rel){							//����л�ҳ�水ť��Ҫ���²���,srcҪ��ӵ�rel�����
	
		rel.add(src);
		rel.updateUI();
	}
	
	public void restLayoutMAOI(int index){									//����ѡ������б��Ӧ���м��������ĵڼ�ҳ
		
		this.add(MPM[index]);
		this.updateUI();
	}
	public int getPanelNum() {
		return panelNum;
	}

	public void setPanelNum(int panelNum) {
		this.panelNum = panelNum;
	}
	
}
