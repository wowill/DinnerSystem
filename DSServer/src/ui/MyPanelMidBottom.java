package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.PCV;

public class MyPanelMidBottom extends JPanel{

	public JButton frontBtn;			//��һҳ��ť
	public JButton nextBtn;				//��һҳ��ť
	public JLabel pageLab;				//ҳ����Ϣ��ǩ
	private int allPageNum;				//ҳ������
	private int curPage;				//��ǰҳ��
	public JLabel spaceLab;				//�հױ�ǩ
	public JLabel spaceLab2;				//�հױ�ǩ
	public JLabel configLab;			//������ʾ������Ϣ�ı�ǩ
	
	public MyPanelMidBottom()
	{
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setBackground(Color.WHITE);
		try {
			mackPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addConfigShowAL();
	}
	public void mackPanel() throws IOException{
		frontBtn = new JButton("��һ��");
		nextBtn = new JButton("��һ��");
		pageLab = new JLabel();
		spaceLab = new JLabel("��������������������������������");
		spaceLab2 = new JLabel("��������������������������������");
		configLab = new JLabel();
		configLab.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/image/config.png"))));
		frontBtn.setContentAreaFilled(false);
		nextBtn.setContentAreaFilled(false);
		this.add(spaceLab);
		this.add(frontBtn);
		this.add(nextBtn);
		this.add(pageLab);
		this.add(spaceLab2);
		this.add(configLab);
	}
	public void addConfigShowAL(){				//Ϊ��ʾ������Ϣ�ı�ǩ��ӵ���¼�
		configLab.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				String str = "";
				InetAddress addr = null;
				try {
					addr = InetAddress.getLocalHost();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String ip = addr.getHostAddress().toString();
				str += "����ˣ�������IP��"+ ip+PCV.SPLINE;
				str = "���ݿ��ַ��"+PCV.databaseAddr + PCV.SPLINE;
				str += "���ݿ����Ӷ˿ڣ�"+PCV.databasePort + PCV.SPLINE;
				str += "���ݿ����ƣ�"+PCV.databaseName + PCV.SPLINE;
				str += "���ݿ��¼�û�����"+PCV.databaseUserName + PCV.SPLINE;
				str += "���ݿ��¼���룺"+PCV.databasePassword+PCV.SPLINE;
				int v = JOptionPane.showConfirmDialog(null, str, "������Ϣ", JOptionPane.YES_OPTION);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				configLab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void setLabelText(){
		pageLab.setText(curPage+"/"+allPageNum);
	}
	
	public int getAllPageNum() {
		return allPageNum;
	}

	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
}
