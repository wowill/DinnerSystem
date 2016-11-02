package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelPer extends JPanel{

	JLabel imgLab;				//存放图片的标签
	JLabel priceLab;			//价格标签
	JButton subNum;				//减少按钮
	JButton addNum;				//增加按钮
	JButton showNum;			//显示数量标签
	JPanel p;					//容器panel
	GridBagLayout gbLayout;
	GridBagConstraints s;
	
	public MyPanelPer() {
		
		init();
	}
	
	public void init() {			//初始化每一道菜的面板
		
		setLayout();
		imgLab = new JLabel();
		priceLab = new JLabel("19.22");
		subNum = new JButton("-");
		addNum = new JButton("+");
		showNum = new JButton("0");
		p = new JPanel();
		
		try {
			ImageIcon img = new ImageIcon(ImageIO.read(this.getClass().getResource("/image/test1.png")));
			imgLab.setIcon(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showNum.setContentAreaFilled(false);
		
		s.gridx = 0;
		s.gridy = 0;
		s.gridwidth = 1;
		s.gridheight = 1;
//		s.weightx = 1;
//		s.weighty = 1;
		this.add(imgLab, s);
		
		p.add(priceLab);
		p.add(subNum);
		p.add(showNum);
		p.add(addNum);
		s.gridx = 0;
		s.gridy = 1;
		s.gridwidth = 1;
		s.gridheight = 1;
		this.add(p, s);
		
		
		setBackground(Color.BLUE);
	}

	public void setLayout(){				//设置布局方式
		
		gbLayout = new GridBagLayout();
		s = new GridBagConstraints();
		this.setLayout(gbLayout);
	}
}
