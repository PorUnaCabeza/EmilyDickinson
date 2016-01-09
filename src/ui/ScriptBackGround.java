package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ScriptBackGround extends LayOut{

	private static final Image img = new ImageIcon("Script1.2/src/image/bg2.jpg").getImage();
	public ScriptBackGround(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
	//	g.drawImage(img, 0, 0, w, y, 0, 0, img.getWidth(null), img.getHeight(null), null);
		g.drawImage(img,0,0,w,h,null);
		
	}

}
