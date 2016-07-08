#include <windows.h>
#include<stdio.h>
#include<string.h>

int main()
{
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
	
	getchar();
}