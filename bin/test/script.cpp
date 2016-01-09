#include "stdafx.h"
#include "windef.h"
#include "windows.h"
#include "ScriptUtil.h"
#include "jni.h"
#include<string.h>


JNIEXPORT void JNICALL Java_ScriptUtil_keyPress
  (JNIEnv *env, jclass cls, jint hwnd, jint keycode){
	//SendMessage((HWND)hwnd,0x0100,keycode,0);
	//Sleep(100);
	//SendMessage((HWND)hwnd,WM_KEYUP,keycode,0);
	PostMessageA((HWND)hwnd,WM_KEYDOWN,WPARAM(keycode),1);
  }
  
  JNIEXPORT void JNICALL Java_ScriptUtil_mouseClick
  (JNIEnv *env, jclass cls, jint hwnd, jint x, jint y){
	LPARAM lparam=MAKELPARAM(x,y);
	SendMessage((HWND)hwnd, WM_LBUTTONDOWN,MK_LBUTTON,lparam);
	Sleep(50);
	SendMessage((HWND)hwnd, WM_LBUTTONUP,MK_LBUTTON,lparam);
	
  }
  JNIEXPORT jstring JNICALL Java_ScriptUtil_getPosition
  (JNIEnv *env, jclass cls, jint hwnd){
	char posX[4];
	char posY[4];
	char pos[9];
	RECT rc;
	POINT p;
	HWND h=(HWND)hwnd;
	GetWindowRect(h,&rc);
	GetCursorPos(&p);
	sprintf(posX,"%d",p.x - rc.left);
	sprintf(posY,"%d",p.y - rc.top);
	strcpy(pos,posX);
	strcat(pos,",");
	strcat(pos,posY);
	jclass strClass = env->FindClass("Ljava/lang/String;");   
    jmethodID ctorID = env->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");   
    jbyteArray bytes = env->NewByteArray(strlen(pos));   
    env->SetByteArrayRegion(bytes, 0, strlen(pos), (jbyte*)pos);   
    jstring encoding = env->NewStringUTF("utf-8");   
    jstring rstStr =(jstring) env->NewObject(strClass, ctorID, bytes, encoding);  
    return rstStr;  
  }