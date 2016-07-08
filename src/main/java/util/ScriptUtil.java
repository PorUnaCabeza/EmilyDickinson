package util;


public class ScriptUtil {
	public static native void keyPress(int hwnd,int keycode);
	public static native void mouseClick(int hwnd,int x,int y);
	public static native String getPosition(int hwnd);
	public static native String getHwnd();
	static{
		System.loadLibrary("script");
		
	}
	public static void main(String[] args) {
		int hwnd=591878;
		ScriptUtil.mouseClick(787170, 950, 440);
	//	for(int i=0;i<10;i++)
//		ScriptUtil.keyPress(hwnd, 0x0D);
//			ScriptUtil.keyPress(hwnd, parseHex("A"));
	//	System.out.println(0x41);
	//	System.out.println(parseHex("A"));
		//	System.out.println(ScriptUtil.getPosition(hwnd));
	}
	public static int parseHex(String key){
		int keyAscii=key.toUpperCase().charAt(0);
		return keyAscii;
	}
}