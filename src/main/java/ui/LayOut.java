package ui;

import util.ImageLoader;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public abstract class LayOut {
    protected static final int PADDING = 16;
    private static Image img2 = ImageLoader.getImage("image/border3.png");
    private static final int size = 7;
    private static int imgW = img2.getWidth(null);
    private static int imgH = img2.getHeight(null);

    protected int x;
    protected int y;
    protected int w;
    protected int h;

    public LayOut(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void creatLayout(Graphics g) {
        g.drawImage(img2, x, y, x + size, y + size, 0, 0, size, size, null);
        g.drawImage(img2, x + size, y, x + w - size, y + size, size, 0, imgW
                - size, size, null);
        g.drawImage(img2, x + w - size, y, x + w, y + size, imgW - size, 0,
                imgW, size, null);
        g.drawImage(img2, x, y + size, x + size, y + h - size, 0, size, size,
                imgH - size, null);
        g.drawImage(img2, x + size, y + size, x + w - size, y + h - size, size,
                size, imgW - size, imgH - size, null);
        g.drawImage(img2, x + w - size, y + size, x + w, y + h - size, imgW
                - size, size, imgW, imgH - size, null);
        g.drawImage(img2, x, y + h - size, x + size, y + h, 0, imgH - size,
                size, imgH, null);
        g.drawImage(img2, x + size, y + h - size, x + w - size, y + h, size,
                imgH - size, imgW - size, imgH, null);
        g.drawImage(img2, x + w - size, y + h - size, x + w, y + h,
                imgW - size, imgH - size, imgW, imgH, null);
    }


    abstract public void paint(Graphics g);
}
