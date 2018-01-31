//Andre J Plath
//CS365_Operating_Systems_and_Networking
//Lab_2

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#include <sys/types.h>
#include <wait.h>

int main(int argc, char * argv[])
{
    char * ls_args[3] = {"ls", "-l", NULL}; // Runs ls -l /bin
    pid_t process_pid, pid;
    int status;

    process_pid = fork(); // Duplicate

    if (process_pid == 0)
    {
        printf("Child: I'm the child process: %d\n", process_pid); // Return fork() is zero.

       
        printf("Child: Will sleep for 4 seconds, and then exit with code 12\n");

        printf("Initializing sleep........................\n");
        sleep(4); // Sleep for 4 seconds

        

        exit(12); // Exit status code 12 
    }
    else if (process_pid > 0)
    {
        printf("Parent: I'm the parent process: %d\n", process_pid); // Return fork() process id of child.

        pid = wait(&status);

        if(WIFEXITED(status)){
            printf("Parent: Child has exited with status: %d\n", WEXITSTATUS(status));
        }
    }
    else
    {
        perror("Fork failed!"); // Return fork() is negative.
        _exit(2); // Exit failure
    }

        printf("Executing ls\n");
        execvp(ls_args[0], ls_args); // Executing ls
        perror("execve did not complete!");

    return 0; // Success
}