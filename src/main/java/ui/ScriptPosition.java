package ui;

import java.awt.Graphics;

public class ScriptPosition extends LayOut {
    private ScriptLetter letter = new ScriptLetter();
    private ScriptNum num = new ScriptNum();
    private int numY = 22;
    private int numMarginY = 40;
    private int numMarginX = 60;
    private String xStr = "NULL";
    private String yStr = "NULL";

    public ScriptPosition(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        creatLayout(g);
        letter.draw(g, x + 10, y + numY, "x", 1);
        letter.draw(g, x + 10, y + numY + numMarginY, "y", 1);
        num.draw(g, x + numMarginX, y + numY, xStr, 1);
        num.draw(g, x + numMarginX, y + numY + numMarginY, yStr, 1);

    }

    public void setXAndY(String str) {
        xStr = str.split(",")[0];
        yStr = str.split(",")[1];
    }

}
