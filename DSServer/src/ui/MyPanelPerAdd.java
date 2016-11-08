package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanelPerAdd extends JPanel{

	public MyPanelLeft mpl;
	public JLabel imgLab;
	public MyPanelPerAdd() {
		
		init();
	}

	public void init() {
		
//		this.setSize(175, 180);
		
		try {
			imgLab = new JLabel();
			ImageIcon img = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/Add_Per.png")));
			imgLab.setIcon(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(imgLab);
	}
	public void addAddPerAL(){			//为此添加面板添加点击事件
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int n = JOptionPane.showConfirmDialog(null, "请选择要添加的图片", "添加商品", JOptionPane.YES_NO_OPTION);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
