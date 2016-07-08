package ui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import service.ScriptService;
import util.ScriptUtil;


public class ScriptPanel extends JPanel{
	private List<LayOut> layout=new ArrayList<LayOut>();
	private ScriptHwnd hwndLayout=new ScriptHwnd(7,93 , 195, 120);
	private ScriptPosition positionLayout=new ScriptPosition(207, 93, 180, 120);
	private ScriptService ss;

	public void init(){
		layout.add(new ScriptBackGround(0, 0, ScriptFrame.WIDTH, ScriptFrame.HEIGHT));
		layout.add(new ScriptNotice(7, 10, 380, 78));
		layout.add(hwndLayout);
		layout.add(positionLayout);
	}
	public void setScriptService(ScriptService ss){
		this.ss=ss;
	}
	public ScriptPanel(){
		init();
		new Thread(new flashPos()).start();
	}
	@Override
	public void paint(Graphics g) {
		// ���û��෽��
		super.paint(g);
		for(int i=0;i<layout.size();i++)
			layout.get(i).paint(g);
	}

	public void changeHwnd(){
		hwndLayout.setHwndStr(ss.getHwnd());
		repaint();
	}
	public void changePosition(){
		if(ss.getHwnd()!=null)
			positionLayout.setXAndY(ss.getPosition());
	}
	
	
	
	class flashPos implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					if(ss.getFocus()&&ss.getHwnd()!=null){
						changePosition();
						repaint();
					}
					Thread.sleep(50);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
