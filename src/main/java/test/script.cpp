
#include "windef.h"
#include "windows.h"
#include "util_ScriptUtil.h"
#include "jni.h"
#include<string.h>

jstring stoJstring(JNIEnv* env, const char* pat)   
{   
    jclass strClass = env->FindClass("Ljava/lang/String;");   
    jmethodID ctorID = env->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");   
    jbyteArray bytes = env->NewByteArray(strlen(pat));   
    env->SetByteArrayRegion(bytes, 0, strlen(pat), (jbyte*)pat);   
    jstring encoding = env->NewStringUTF("utf-8");   
    jstring rstStr =(jstring) env->NewObject(strClass, ctorID, bytes, encoding);  
    return rstStr;  
} 
JNIEXPORT void JNICALL Java_util_ScriptUtil_keyPress
  (JNIEnv *env, jclass cls, jint hwnd, jint keycode){
	//SendMessage((HWND)hwnd,0x0100,keycode,0);
	//Sleep(100);
	//SendMessage((HWND)hwnd,WM_KEYUP,keycode,0);
	PostMessageA((HWND)hwnd,WM_KEYDOWN,WPARAM(keycode),1);
  }
  
  JNIEXPORT void JNICALL Java_util_ScriptUtil_mouseClick
  (JNIEnv *env, jclass cls, jint hwnd, jint x, jint y){
	LPARAM lparam=MAKELPARAM(x,y);
	SendMessage((HWND)hwnd, WM_LBUTTONDOWN,MK_LBUTTON,lparam);
	Sleep(50);
	SendMessage((HWND)hwnd, WM_LBUTTONUP,MK_LBUTTON,lparam);
	
  }
  JNIEXPORT jstring JNICALL Java_util_ScriptUtil_getPosition
  (JNIEnv *env, jclass cls, jint hwnd){
	char posX[4];
	char posY[4];
	char pos[9];
//	RECT rc;
	POINT p;
	HWND h=(HWND)hwnd;
//	GetWindowRect(h,&rc);
	GetCursorPos(&p);
	ScreenToClient(h,&p);
//	sprintf(posX,"%d",p.x - rc.left);
//	sprintf(posY,"%d",p.y - rc.top);
	sprintf(posX,"%d",p.x);
	sprintf(posY,"%d",p.y);
	strcpy(pos,posX);
	strcat(pos,",");
	strcat(pos,posY);
	return stoJstring(env,pos);
  }
  JNIEXPORT jstring JNICALL Java_util_ScriptUtil_getHwnd
  (JNIEnv *env, jclass cls){
  
	POINT p;
	HWND hwnd=NULL;
	char pos[9];
	if(GetCursorPos(&p)){
		hwnd=WindowFromPoint(p);
		long long nwnd=(long long)hwnd;
		printf("%d,%d\n",p.x,p.y);
		sprintf(pos,"%d",nwnd);
		printf("%s\n",pos);
	}
	return stoJstring(env,pos);
  }