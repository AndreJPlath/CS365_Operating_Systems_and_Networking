#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

void forkprogram()
{
    
    // child process because return value zero
    if (fork() == 0)
    printf("Hello from Child Process! Process id is %d\n", getpid());
    
    // parent process because value return is non-zero
    else
    printf("Hello from Parent Process! Process id is %d\n", getpid());
       
}

int main()
{
    fork();
    fork();
    forkprogram();
    return 0;
}
