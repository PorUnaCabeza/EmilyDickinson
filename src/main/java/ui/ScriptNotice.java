package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ScriptNotice extends LayOut{

	public ScriptNotice(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		creatLayout(g);
		g.setColor(new Color(255,255,255));
		g.setFont(new Font("微软雅黑",Font.BOLD,27));
		g.drawString("按F1获得句柄,F2记录坐标 ",20,54);

	}

}
