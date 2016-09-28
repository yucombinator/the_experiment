#include<stdio.h>

int main()
{
    int *ptr = malloc(sizeof(int));
    
    *ptr = 420;
    
    printf("Pointers are fun :D %d", ptr);
    
    free(ptr);
    
    return 0;
}