package ui;

import javax.swing.*;

import com.melloware.jintellitype.HotKey;

import java.awt.*;

public class ScriptFrame extends JFrame{
	public static final int WIDTH=400;
	public static final int HEIGHT=400;
	
	private HotKey hotkey;
	
	public static void main(String[] args) {
		new ScriptFrame().init();
	}
	
	public void init(){
		ScriptPanel sp=new ScriptPanel();
		sp.setSize(new Dimension(400,300));
		JTextArea textArea=new JTextArea(10,5);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setTitle("test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLocation(100, 100);
		this.add(sp,BorderLayout.CENTER);
		this.add(scroll,BorderLayout.SOUTH);
		this.setAlwaysOnTop(true);
		hotkey=new HotKey(sp,textArea);
		hotkey.initHotkey();
		this.setVisible(true);
		
	}
}
