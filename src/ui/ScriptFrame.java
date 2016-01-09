package ui;

import javax.swing.*;

import com.melloware.jintellitype.HotKey;
import service.ScriptService;

import java.awt.*;

public class ScriptFrame extends JFrame{
	public static final int WIDTH=400;
	public static final int HEIGHT=400;

	public ScriptFrame(){
		ScriptPanel sp=new ScriptPanel();
		ScriptService ss=new ScriptService(sp);
		sp.setScriptService(ss);
		HotKey hotkey=new HotKey(ss);
		hotkey.initHotkey();

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
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		new ScriptFrame();
	}
}
