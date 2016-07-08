package ui;

import util.ImageLoader;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ScriptNum {
    private static final Image img = ImageLoader.getImage("image/num.png");
    private int x, y;
    private String letters;
    private int letterCount = 12;
    private int picWidth;
    private int picHeight;
    private int drawWidth;
    private int drawHeight;
    private double multiple;

    public ScriptNum(int x, int y, String letters, double multiple) {
        this.x = x;
        this.y = y;
        this.letters = letters;
        this.multiple = multiple;
        picWidth = img.getWidth(null) / letterCount;
        picHeight = img.getHeight(null);
        drawWidth = (int) (picWidth * multiple);
        drawHeight = (int) (picHeight * multiple);
    }

    public ScriptNum() {
        picWidth = img.getWidth(null) / letterCount;
        picHeight = img.getHeight(null);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < letters.length(); i++) {
            int index = letters.toUpperCase().charAt(i) - '0';
            g.drawImage(img, x + i * drawWidth, y, x + (i + 1) * drawWidth, y + drawHeight, index * picWidth, 0, (index + 1) * picWidth, picHeight, null);
        }
    }

    public void draw(Graphics g, int x, int y, String letters, double multiple) {
        drawWidth = (int) (picWidth * multiple);
        drawHeight = (int) (picHeight * multiple);
        for (int i = 0; i < letters.length(); i++) {
            int index = letters.toUpperCase().charAt(i) - '0';
            g.drawImage(img, x + i * drawWidth, y, x + (i + 1) * drawWidth, y + drawHeight, index * picWidth, 0, (index + 1) * picWidth, picHeight, null);
        }
    }

}
