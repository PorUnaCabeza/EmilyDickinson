#include "windef.h"
#include<stdio.h>
#include "windows.h"
#include<tchar.h>
int main(){
	int hwnd=1510160;
	HWND h=(HWND)hwnd;
	POINT p;
	GetCursorPos(&p);
	ScreenToClient(h,&p);
	printf("%d,%d",p.x,p.y);
	getchar();
}