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

	public JButton frontBtn;			//上一页按钮
	public JButton nextBtn;				//下一页按钮
	public JLabel pageLab;				//页码信息标签
	private int allPageNum;				//页码总数
	private int curPage;				//当前页码
	public JLabel spaceLab;				//空白标签
	public JLabel spaceLab2;				//空白标签
	public JLabel configLab;			//用来显示连接信息的标签
	
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
		frontBtn = new JButton("上一张");
		nextBtn = new JButton("下一张");
		pageLab = new JLabel();
		spaceLab = new JLabel("　　　　　　　　　　　　　　　　");
		spaceLab2 = new JLabel("　　　　　　　　　　　　　　　　");
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
	public void addConfigShowAL(){				//为显示配置信息的标签添加点击事件
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
				str += "服务端（本机）IP："+ ip+PCV.SPLINE;
				str = "数据库地址："+PCV.databaseAddr + PCV.SPLINE;
				str += "数据库连接端口："+PCV.databasePort + PCV.SPLINE;
				str += "数据库名称："+PCV.databaseName + PCV.SPLINE;
				str += "数据库登录用户名："+PCV.databaseUserName + PCV.SPLINE;
				str += "数据库登录密码："+PCV.databasePassword+PCV.SPLINE;
				int v = JOptionPane.showConfirmDialog(null, str, "配置信息", JOptionPane.YES_OPTION);
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
