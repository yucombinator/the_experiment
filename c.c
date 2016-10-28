#include<stdio.h>

int main()
{
    int *ptr = malloc(sizeof(int));
    
    *ptr = 420;
    
    printf("Pointers are fun :D %d", ptr);
    printf("I think this needs more pointers!\n");
    
    free(ptr);
    
    return 0;
}
