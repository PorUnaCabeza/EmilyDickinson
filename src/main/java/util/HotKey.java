package util;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.*;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import service.ScriptService;
import ui.ScriptPanel;
import util.ScriptUtil;


public class HotKey implements HotkeyListener {
    static final int KEY_1 = 88;
    static final int KEY_2 = 89;
    static final int KEY_3 = 90;
    static final int KEY_4=91;
    private int hwnd=0;

    private ScriptPanel sp;
    private JTextArea ta;

    private ScriptService ss;

    public HotKey(ScriptService ss){
        this.ss=ss;
    }

    /**
     * 该方法负责监听注册的系统热键事件
     *
     * @param key:触发的热键标识
     */
    public void onHotKey(int key) {
        switch (key) {
            case KEY_1:
                System.out.println("ctrl+alt+I 按下.........");
                ScriptUtil.mouseClick(054, 1, 1);
                break;
            case KEY_2:
                System.out.println("F1按下.........");
                ss.changeHwnd();
                break;
            case KEY_3:
                System.out.println("系统退出..a........");
                destroy();
                break;
            case KEY_4:
                System.out.println("f2按下");
                break;
        }

    }


    /**
     * 解除注册并退出
     */
    void destroy() {
        JIntellitype.getInstance().unregisterHotKey(KEY_1);
        JIntellitype.getInstance().unregisterHotKey(KEY_2);
        JIntellitype.getInstance().unregisterHotKey(KEY_3);
        JIntellitype.getInstance().unregisterHotKey(KEY_4);
        System.exit(0);
    }

    /**
     * 初始化热键并注册监听事件
     */
    public void initHotkey() {
        //参数KEY_1表示改组热键组合的标识，第二个参数表示组合键，如果没有则为0，该热键对应ctrl+alt+I
        JIntellitype.getInstance().registerHotKey(KEY_1, JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT,
                (int) 'I');
        JIntellitype.getInstance().registerHotKey(KEY_2, 0, 0x70);
        JIntellitype.getInstance().registerHotKey(KEY_3, JIntellitype.MOD_CONTROL + JIntellitype.MOD_ALT,
                (int) 'X');
        JIntellitype.getInstance().registerHotKey(KEY_4, 0, 0x71);

        JIntellitype.getInstance().addHotKeyListener(this);
    }

/*   public static void main(String[] args) {
        HotKey key = new HotKey();
        key.initHotkey();

        //下面模拟长时间执行的任务
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (Exception ex) {
                break;
            }
        }
    }*/
}
