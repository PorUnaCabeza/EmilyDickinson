package service;

import ui.ScriptPanel;
import util.ScriptUtil;

/**
 * Created by Cabeza on 2016/1/9.
 */
public class ScriptService {
    private String hwnd=null;
    private boolean focus=false;
    private ScriptPanel sp;

    public ScriptService(ScriptPanel sp){
        this.sp=sp;
    }

    public String getHwnd() {
        return hwnd;
    }

    public void changeHwnd(){
        hwnd=ScriptUtil.getHwnd();
        sp.changeHwnd();
        focus=!focus;
    }

    public boolean getFocus() {
        return focus;
    }
    public String getPosition(){
        return ScriptUtil.getPosition(Integer.parseInt(hwnd));
    }
}
