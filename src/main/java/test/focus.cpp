#include <windows.h>
#include "jni.h"
#include<stdio.h>
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
int main()
{
	char posX[4];
	char posY[4];
	char pos[9];
	int hwnd=855324;
	RECT rc;
	POINT p;
	HWND h=(HWND)hwnd;
	GetWindowRect(h,&rc);
	GetCursorPos(&p);
	printf("%d,%d\n",p.x,p.y);
	sprintf(posX,"%d",p.x);
	sprintf(posY,"%d",p.y);
	strcpy(pos,posX);
	strcat(pos,",");
	strcat(pos,posY);
	printf("%s\n",pos);
//	printf("%d,%d\n",rc.left,rc.right);
	getchar();
}