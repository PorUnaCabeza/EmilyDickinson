package ui;

import util.ImageLoader;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ScriptBackGround extends LayOut {

    private static final Image img = ImageLoader.getImage("image/bg2.jpg");

    public ScriptBackGround(int x, int y, int w, int h) {
        super(x, y, w, h);
        System.out.println(System.getProperty("user.dir"));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, w, h, null);

    }

}
