#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

// Thread function
void* thread_function(void* arg) {
    printf("Thread running in process with PID: %d\n", getpid());
    return NULL;
}

int main() {
    pid_t pid;
    pthread_t t1;

    pid = fork();  // Create process

    if (pid < 0) {
        printf("Fork failed!\n");
        return 1;
    }

    // Both parent and child execute this
    if (pid == 0) {
        // Child process
        printf("\n--- Child Process ---\n");
        printf("Child PID: %d\n", getpid());

        pthread_create(&t1, NULL, thread_function, NULL);
        pthread_join(t1, NULL);
    }
    else {
        // Parent process
        printf("\n--- Parent Process ---\n");
        printf("Parent PID: %d\n", getpid());
        printf("Child PID: %d\n", pid);

        pthread_create(&t1, NULL, thread_function, NULL);
        pthread_join(t1, NULL);
    }

    return 0;
}
