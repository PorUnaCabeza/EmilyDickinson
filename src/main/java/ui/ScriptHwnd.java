package ui;

import java.awt.Graphics;

public class ScriptHwnd extends LayOut {
    private ScriptLetter letter = new ScriptLetter();
    private ScriptNum num = new ScriptNum();
    private int letterY = 22;
    private int letterMargin = 40;
    private String hwndStr = "null";

    public ScriptHwnd(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        creatLayout(g);
        letter.draw(g, x + 10, y + letterY, "HWND", 1);
        num.draw(g, x + 10, y + letterY + letterMargin, hwndStr, 1);
    }

    public void setHwndStr(String num) {
        this.hwndStr = num;
    }

}
