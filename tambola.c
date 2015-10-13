/*
A rudimentary tambola game that plays itself.
*/

#include<conio.h>
#include<stdlib.h>
#include<time.h>

void reprint();
int tic1[10];
int tic2[10];
int i=0,j=0;
void main()
{
int x=0,n=0,p1=0,p2=0,a=0,p=0,done[100];
srand(time(NULL));

while(1)
{
	n++;
	done[p]=0;}
clrscr();
for(j=0;j<100;j=j+10)
  {
    tic1[i]=((rand())%10)+j;
    tic2[i]=((rand())%10)+j;
    i++;
  }
reprint();

for(n=0;n<100;n++)
{
  x=rand()%100;
  done[x]=1;
  printf("\n\nNUMBER : %d",x);
  for(a=0;a<10;a++)
    {
      if(x==tic1[a])
	{
	  p1++;
	  printf("\nP1 has %d.",x);
	  delay(500);
	}
      if(x==tic2[a])
	{
	  p2++;
	  printf("\nP2 has %d.",x);
	  delay(500);
	}
    }
    printf("\n");
    for(p=0;p<100;p++) {if (done[p]) printf("%d ",p);
    if(p1==10) {printf("\nP1 WINS!!!");getch();exit(0);}
    if(p2==10) {printf("\nP2 WINS!!!");getch();exit(0);}
    }
    delay(200);reprint();
}
getch();
}


/* reprint */


void reprint()
{
clrscr();
printf("\nPlayer 1 : ");
for(i=0;i<10;i++)
  {
    printf("%d ",tic1[i]);
  }

printf("\nPlayer 2 : ");
for(i=0;i<10;i++)
  {
    printf("%d ",tic2[i]);
  }
}
